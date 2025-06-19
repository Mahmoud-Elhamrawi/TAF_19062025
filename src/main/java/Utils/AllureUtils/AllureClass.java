package Utils.AllureUtils;

import Utils.FileUtils.FileClass;
import Utils.LogUtils.LogClass;
import Utils.TeminalUtil.TerminalClass;
import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static Utils.DataUtil.ReadPropertiesData.getPropertyKey;


public class AllureClass {

    // add screenshot

    public static void addScreenshot(String screenName, String screenPath) {
        try {
            Allure.addAttachment(screenName, Files.newInputStream(Path.of(screenPath)));
        } catch (Exception e) {
            LogClass.error("Failed to add screenshot" + e.getMessage());
        }
    }

    // add logs
    public static void addLogs() {
        try {
            File logPath = FileClass.getLastFile(LogClass.LogPathFile);
            Allure.addAttachment("Logs", Files.readString(Path.of(logPath.getPath())));
        } catch (Exception e) {
            LogClass.error("Failed to add logs" + e.getMessage());
        }
    }
//  C:\Users\ArabTech\.m2\repository\allure\allure-2.33.0\bin


    // generate report
    static String Allure_Results_Path = "test-outputs/target/allure-results/";
    static String Allure_Report_Path = "test-outputs/allureReport/";
    static String USER_HOME = System.getProperty("user.home");
    static String Allure_Path_bin = USER_HOME + File.separator + ".m2" + File.separator + "repository" + File.separator + "allure" + File.separator + "allure-2.33.0" + File.separator + "bin" + File.separator + "allure";

    public static void generateReport() {
        if (Objects.requireNonNull(getPropertyKey("os.name")).toLowerCase().contains("win")) {
            String WIN = Allure_Path_bin + ".bat";

            TerminalClass.executeCommand(WIN, "generate", Allure_Results_Path, "-o", Allure_Report_Path, "clean", "--single-file");
            LogClass.info("Report generated successfully on Windows");
        } else {
            TerminalClass.executeCommand(Allure_Path_bin, " generate ", Allure_Results_Path, " -o ", Allure_Report_Path, "clean", "--single-file");
            LogClass.info("Report generated successfully on Linux");
        }

    }


    // open report
    public static void openReport() {
        String ALLURE_PATH = Allure_Report_Path + File.separator + "index.html";
        if (Objects.requireNonNull(getPropertyKey("openAllureReport")).equalsIgnoreCase("true")) {
            if (Objects.requireNonNull(getPropertyKey("os.name")).toLowerCase().contains("win")) {
                TerminalClass.executeCommand("cmd.exe", "/c", "start", ALLURE_PATH);
                LogClass.info("Report opened successfully on Windows");
            } else {
                TerminalClass.executeCommand("open", ALLURE_PATH);
                LogClass.info("Report opened successfully on Linux");
            }

        }

    }


}
