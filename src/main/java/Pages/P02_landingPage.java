package Pages;

import Utils.BrowserUtils.BrowserActions;
import Utils.LogUtils.LogClass;
import Utils.Validation.ValidationClass;
import org.openqa.selenium.WebDriver;

public class P02_landingPage {
    //Variable
    public WebDriver drivre;

    //constructor
    public P02_landingPage(WebDriver driver) {
        this.drivre = driver;
    }

    //Validations
    public P02_landingPage validateSuccessfullyLogin(String expectedUrl, String expectedTitle) {
        ValidationClass.softValidateURL(BrowserActions.getCurrentUrl(drivre), expectedUrl, "incorrect url");
          LogClass.info("actual url", BrowserActions.getCurrentUrl(drivre), "expected url", expectedUrl);
        ValidationClass.softValidateTitle(BrowserActions.getTitle(drivre), expectedTitle, "incorrect title");
          LogClass.info("actual title", BrowserActions.getTitle(drivre), "expected title", expectedTitle);
        return this;
    }


}
