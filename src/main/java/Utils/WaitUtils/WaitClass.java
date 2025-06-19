package Utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitClass {


    // wait ele to be exists
    public static WebElement waitForElementToBeExists(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> driver1.findElement(locator));
    }

    //wait ele to be clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> {
                    WebElement ele = waitForElementToBeExists(driver, locator);
                    return ele.isEnabled() ? ele : null;
                });
    }


    //wait ele to be visible
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> {
                    WebElement ele = waitForElementToBeExists(driver, locator);
                    return ele.isDisplayed() ? ele : null;
                });

    }


}
