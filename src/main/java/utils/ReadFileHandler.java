package utils;

import java.io.*;
import java.util.Properties;

public class ReadFileHandler {

    public static String loadProperties(final String propertyName) {
        File file = new File("src/test/resources/test-data.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final Properties properties = new Properties();
        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
