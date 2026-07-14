package builders;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;

public class ResponseBuilder {
	
	public static ResponseSpecification BuildResponse(int StatusCode, String message) {
    	ResponseSpecification res = new ResponseSpecBuilder().
    			expectStatusCode(StatusCode)
    			.expectContentType(ContentType.JSON).expectBody("message", equalTo(message)).build();

    	return res;
    }

}
