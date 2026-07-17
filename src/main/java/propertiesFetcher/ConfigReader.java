// File: src/main/java/propertiesFetcher/ConfigReader.java

package propertiesFetcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;
    
    static {
        try {
            // Load default properties file
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties"
            );
            properties = new Properties();
            properties.load(fis);
            fis.close();
            System.out.println("Properties file loaded successfully");
        } catch (IOException e) {
            System.out.println("Properties file not found, will use environment variables");
            properties = new Properties();
        }
    }
    
   
    public static String getProperty(String key) {
               
        String envKey = key.replace(".", "_").toUpperCase();
        String envValue = System.getenv(envKey);
        if (envValue != null && !envValue.trim().isEmpty()) {
            System.out.println("Using ENV variable: " + envKey + " = " + maskSensitiveData(envKey, envValue));
            return envValue;
        }
        
        String sysProp = System.getProperty(key);
        if (sysProp != null && !sysProp.trim().isEmpty()) {
            System.out.println("Using System Property: " + key + " = " + maskSensitiveData(key, sysProp));
            return sysProp;
        }
        
        String propValue = properties.getProperty(key);
        if (propValue != null && !propValue.trim().isEmpty()) {
            System.out.println("Using Properties file: " + key + " = " + maskSensitiveData(key, propValue));
            return propValue;
        }
        
        throw new RuntimeException("Configuration key not found: " + key);
    }
    
    private static String maskSensitiveData(String key, String value) {
        if (key.toLowerCase().contains("password") || 
            key.toLowerCase().contains("token") || 
            key.toLowerCase().contains("secret") ||
            key.toLowerCase().contains("email")) {
            return "***MASKED***";
        }
        return value;
    }
}