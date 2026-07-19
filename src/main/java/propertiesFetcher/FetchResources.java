package propertiesFetcher;

public class FetchResources {
    
    public static String getBaseUri() {
        return System.getenv("BASE_URI");
    }
    
    public static String getLoginResource() {
    	return System.getenv("LOGIN_ENDPOINT");
    }
    
    public static String getFilterResource() {
    	return System.getenv("FILTER_ENDPOINT");
    }

}
