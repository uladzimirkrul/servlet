package org.greenGroup.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    private Properties properties = new Properties();

    public PropertyUtils(String propertyFile) {

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertyFile)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property) {
        try {
            return properties.getProperty(property);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
