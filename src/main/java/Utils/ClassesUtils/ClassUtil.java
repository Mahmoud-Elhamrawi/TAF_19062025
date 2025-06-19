package Utils.ClassesUtils;

import Driver.DriverManager;
import Utils.AllureUtils.AllureClass;
import Utils.LogUtils.LogClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassUtil {

    // take screenshot

    static String screenPath = "test-outputs/screenshots/";

    public static void takeScreenshot(String screenName) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File Dist = new File(screenPath + screenName + "_" + getTimestamp() + ".png");
            FileUtils.copyFile(src, Dist);
            AllureClass.addScreenshot(screenName, Dist.getPath());
            LogClass.info("Screenshot taken");

        } catch (Exception e) {
            LogClass.error("Failed to take screenshot" + e.getMessage());
        }

    }


    //scroll
    public static void scrollIntoView(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(locator));
    }


    // get timestamp
    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

    }

}
