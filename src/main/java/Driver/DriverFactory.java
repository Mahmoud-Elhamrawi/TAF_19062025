package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;
import java.util.Objects;

import static Utils.DataUtil.ReadPropertiesData.getPropertyKey;

public class DriverFactory {


    public static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-gpu");
                if(!Objects.requireNonNull(getPropertyKey("Execution_Type")).equalsIgnoreCase("local"))
                chromeOptions.addArguments("--headless");

                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                Map<String, Object> chromePrefs = Map.of(
                        "autofill_enabled", false,
                        "password_manager_enabled", false,
                        "profile.password_manager_enabled", false,
                        "profile.default_content_setting_values.notifications", 2
                );

                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                return new ChromeDriver(chromeOptions);
            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-popup-blocking");
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                Map<String, Object> firefoxPrefs = Map.of(
                        "autofill_enabled", false,
                        "password_manager_enabled", false,
                        "profile.password_manager_enabled", false,
                        "profile.default_content_setting_values.notifications", 2
                );

                firefoxOptions.asMap().put("prefs", firefoxPrefs);
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-gpu");
                if(!getPropertyKey("Execution_Type").equalsIgnoreCase("local"))
                   edgeOptions.addArguments("--headless");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                Map<String, Object> edgePrefs = Map.of(
                        "autofill_enabled", false,
                        "password_manager_enabled", false,
                        "profile.password_manager_enabled", false,
                        "profile.default_content_setting_values.notifications", 2
                );

                edgeOptions.setExperimentalOption("prefs", edgePrefs);


                return new EdgeDriver(edgeOptions);
            default:
                return null;


        }
    }


}
