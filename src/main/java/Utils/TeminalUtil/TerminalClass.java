package Utils.TeminalUtil;

import Utils.LogUtils.LogClass;

public class TerminalClass {

    public static void executeCommand(String... command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            LogClass.info("Command executed successfully");
        } catch (Exception e) {
            LogClass.error("Error executing command: ", e.getMessage());
        }
    }


}
