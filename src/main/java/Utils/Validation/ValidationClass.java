package Utils.Validation;

import Utils.CustomAssert.CustomAssertClass;
import org.testng.Assert;

import static Utils.CustomAssert.CustomAssertClass.customAssertClass;

public class ValidationClass {

    /// Hard Assert
    public static void validateURL(String actualURL, String expectedURL, String message) {
        Assert.assertTrue(actualURL.contains(expectedURL), message);
    }

    public static void validateTitle(String actualTitle, String expectedTitle, String message) {
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }

    public static void validateText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }


    /// soft assert
    public static void softValidateURL(String actualURL, String expectedURL, String message) {
        CustomAssertClass.customAssertClass.assertEquals(actualURL, expectedURL, message);
    }

    public static void softValidateTitle(String actualTitle, String expectedTitle, String message) {
        CustomAssertClass.customAssertClass.assertEquals(actualTitle, expectedTitle, message);
    }


}
