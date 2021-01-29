package utils;

import java.io.*;
import java.util.Properties;

public class ReadFileHandler {

    public static String loadProperties(final String propertyName, String pathName) {
        final Properties properties = new Properties();
        File file = new File(pathName);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
