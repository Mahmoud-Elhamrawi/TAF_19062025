package TestCases;

import Driver.DriverManager;
import Pages.P01_LoginPage;
import Utils.BrowserUtils.BrowserActions;
import Utils.DataUtil.ReadJsonData;
import Utils.LogUtils.LogClass;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import static Utils.DataUtil.ReadJsonData.getJsonData;
import static Utils.DataUtil.ReadPropertiesData.getPropertyKey;


@Listeners(Testnglistener.TestNGListener.class)
public class TC01_LoginTC {
    //variables
    public WebDriver driver;
    ReadJsonData readJsonData;


    @Test
    public void loginTest() {
        new P01_LoginPage(driver)
                .validateLoginURL(getPropertyKey("Login_URL"))
                .enterUsername(getJsonData("validCredentialsLogin.username"))
                .enterPassword(getJsonData("validCredentialsLogin.password"))
                .clickLoginButton()
                .validateSuccessfullyLogin(getPropertyKey("LandingPage_URL"), getPropertyKey("Page_Title"));

        LogClass.info("Login test completed");
    }


    //Configuration
    @BeforeClass
    public void setUpClass() {
        readJsonData = new ReadJsonData("jsonData");
        LogClass.info("JsonData file loaded");
    }

    @BeforeMethod
    public void setUpMethod() {

        String Browser =  System.getProperty("Browser")!=null?System.getProperty("Browser"):getPropertyKey("BrowserName");
        driver = DriverManager.createInstance(Browser);
        LogClass.info("Driver created", getPropertyKey("Browser"));

        new P01_LoginPage(driver)
                .navigateToLoginPage(getPropertyKey("Login_URL"));
        LogClass.info("Navigated to login page:", getPropertyKey("Login_URL"));

    }

    @AfterMethod
    public void tearDownMethod() {
        BrowserActions.closeBrowser(driver);
        LogClass.info("Driver closed");
    }


}
