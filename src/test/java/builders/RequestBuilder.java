package builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import propertiesFetcher.FetchResources;
import stepDefinitions.Hooks;

public class RequestBuilder {	
    
    public static RequestSpecification BuildRequest() {
    	RequestSpecification req = new RequestSpecBuilder().addHeader("Authorization", Hooks.getAccessToken())
    		    .setBaseUri(FetchResources.getBaseUri())  
    		    .setContentType(ContentType.JSON)
    		    .build();
    	return req;
    }
}
