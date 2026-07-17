package propertiesFetcher;

public class FetchResources {
    
    public static String getBaseUri() {
        return ConfigReader.getProperty("base");
    }
    
    public static String getLoginResource() {
    	return ConfigReader.getProperty("login");
    }
    
    public static String getFilterResource() {
    	return ConfigReader.getProperty("filter");
    }

}
