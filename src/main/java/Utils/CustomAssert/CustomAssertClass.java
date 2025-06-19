package Utils.CustomAssert;

import Utils.LogUtils.LogClass;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class CustomAssertClass extends SoftAssert {


    public static CustomAssertClass customAssertClass = new CustomAssertClass();

    public static void customAssertAll(ITestResult result) {
        try {
            customAssertClass.assertAll("Assert All");

        } catch (AssertionError e) {
            LogClass.error("Failed to assert all" + e.getMessage());
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);

        }
    }


}
