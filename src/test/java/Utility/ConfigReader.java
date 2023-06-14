package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
    public static Properties readProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream
                    (Constants.PROPERTIES_FILE_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e){
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return properties;
    }

    public static String getPropertyValue(String propertyKey){
        return properties.getProperty(propertyKey);
    }
}
