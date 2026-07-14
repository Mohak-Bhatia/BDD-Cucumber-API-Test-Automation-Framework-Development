package propertiesFetcher;

import java.io.InputStream;
import java.util.Properties;

public class FetchResources {
	
private static Properties prop;
    
    static {
        try {
            prop = new Properties();
            InputStream input = FetchResources.class.getClassLoader()
                .getResourceAsStream("global.properties");
            prop.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getBaseUri() {
        return prop.getProperty("base");
    }
    
    public static String getLoginResource() {
    	return prop.getProperty("login");
    }
    
    public static String getFilterResource() {
    	return prop.getProperty("filter");
    }

}
