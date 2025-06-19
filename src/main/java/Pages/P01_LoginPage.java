package Pages;

import Utils.BrowserUtils.BrowserActions;
import Utils.ElementUtils.ElementActions;
import Utils.Validation.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //Variables
   public WebDriver driver;

    //Constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    //Methods Actions
//navigate to login page
    @Step("Navigate to login page")
    public void navigateToLoginPage(String url) {
        BrowserActions.openBrowser(driver, url);
    }

    @Step("Enter username")
    public P01_LoginPage enterUsername(String username) {
        ElementActions.sendKeys(driver, this.username, username);
        return this;
    }

    @Step("Enter password")
    public P01_LoginPage enterPassword(String password) {
        ElementActions.sendKeys(driver, this.password, password);
        return this;
    }

    @Step("Click login button")
    public P02_landingPage clickLoginButton() {
        ElementActions.click(driver, loginButton);
        return new P02_landingPage(driver);
    }

    //Validations
    public P01_LoginPage validateLoginURL(String expectedURL) {
        ValidationClass.softValidateURL(BrowserActions.getCurrentUrl(driver), expectedURL, "URL is not correct");
        return this;
    }


}
