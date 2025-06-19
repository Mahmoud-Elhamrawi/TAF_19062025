package Utils.DataUtil;

import Utils.LogUtils.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertiesData {


    // load properties files in system
    static String propertiesPath = "src/main/resources/";

    public static Properties loadProperties() {
        try {
            Properties Properties = new Properties();
            Collection<File> collectionFile;
            collectionFile = FileUtils.listFiles(new File(propertiesPath), new String[]{"properties"}, true);
            collectionFile.forEach(file -> {
                try {
                    Properties.load(new FileInputStream(file));
                    Properties.putAll(System.getProperties());
                    System.getProperties().putAll(Properties);
                } catch (Exception e) {
                    LogClass.error("Failed to load properties file" + e.getMessage());
                }
            });
            return Properties;
        } catch (Exception e) {
            LogClass.error("Failed to load properties file" + e.getMessage());
            return null;
        }


    }


    // get value from properties file
    public static String getPropertyKey(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogClass.error("Failed to get value from properties file" + e.getMessage());
            return null;
        }
    }

}