package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        String fixedPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        try (FileInputStream input = new FileInputStream(fixedPath)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties from fixed path: " + fixedPath, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
