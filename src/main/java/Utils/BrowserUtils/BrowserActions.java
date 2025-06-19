package Utils.BrowserUtils;

import Driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    //private Constructor
    private BrowserActions() {
    }


    // open browser
    public static void openBrowser(WebDriver driver, String url) {
        driver.get(url);
    }


    //get title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // get current url
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    // close browser
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
        DriverManager.removeDriver();
    }


}
