package Utils.FileUtils;

import Utils.LogUtils.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class FileClass {
//private Constructor
    private FileClass() {
        super();
    }

    //get last file
    public static File getLastFile(String file) {
        File file1 = new File(file);
        if (!file1.exists()) {
            LogClass.error("File does not exist");
        }

        File[] files = file1.listFiles();
        assert files != null;
        if (files.length == 0) {
            LogClass.error("File is empty");
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];

    }


    //delete all files
    public static void deleteAllFiles(File folder) {
        if (!folder.exists()) {
            LogClass.error("Folder does not exist");
        }

        File[] files = folder.listFiles();
        assert files != null;
        if (files.length == 0) {
            LogClass.error("Folder is empty");
        }

        for (File file : files) {
            if (file.isDirectory())
                deleteAllFiles(file);
            else {
                try {
                    Files.delete(file.toPath());
                } catch (Exception e) {
                    LogClass.error("Error deleting file: ", e.getMessage());
                }
            }
        }


    }


    //clean folder

    public static void cleanFolder(File folder) {
        try {
            FileUtils.deleteQuietly(folder);
        } catch (Exception e) {
            LogClass.error("Error cleaning folder: ", e.getMessage());
        }
    }

}
