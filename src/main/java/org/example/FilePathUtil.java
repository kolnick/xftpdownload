package org.example;

import java.io.File;

public class FilePathUtil {

    public static File getConfigPath(String subDir) {
        String path = System.getProperty("user.dir") + File.separator + subDir;
        File configFile = new File(path);
        if (!configFile.exists()) {
            path = FilePathUtil.class.getResource("/").getPath() + subDir;
            configFile = new File(path);
        }
        return configFile;
    }
}
