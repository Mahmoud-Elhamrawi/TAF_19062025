package Utils.LogUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogClass {


    public static final String LogPathFile = "test-outputs/Logs/";

    // set logger
    public static Logger setLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    //get logger
    public static void info(String... message) {
        setLogger().info(String.join(" ", message));
    }

    public static void error(String... message) {
        setLogger().error(String.join(" ", message));
    }


    public static void debug(String... message) {
        setLogger().debug(String.join(" ", message));
    }


}
