package Utils.ElementUtils;

import Utils.WaitUtils.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.ClassesUtils.ClassUtil.scrollIntoView;

public class ElementActions {

    //private Constructor
    private ElementActions() {
        super();
    }

    // click
    public static void click(WebDriver driver, By locator) {
        WaitClass.waitForElementToBeClickable(driver, locator);
        scrollIntoView(driver, locator);
        driver.findElement(locator).click();
    }


    //send keys
    public static void sendKeys(WebDriver driver, By locator, String value) {
        WaitClass.waitForElementToBeVisible(driver, locator);
        scrollIntoView(driver, locator);
        driver.findElement(locator).sendKeys(value);
    }


    //get text
    public static String getText(WebDriver driver, By locator) {
        WaitClass.waitForElementToBeVisible(driver, locator);
        return driver.findElement(locator).getText();
    }


}
