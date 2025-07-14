package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    public static void loadProperties(String env) {
        String path = "src/test/resources/config/" + env + ".properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties for env: " + env, e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
