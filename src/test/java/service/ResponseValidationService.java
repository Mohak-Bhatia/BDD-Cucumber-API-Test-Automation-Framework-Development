package service;

import builders.ResponseBuilder;
import builders.ResponseValidator;
import io.restassured.response.Response;

public class ResponseValidationService {
	 
	public static void ValidateResponse(int StatusCode, String message) {
		
		Response response = ResponseValidator.getLastResponse();
        if (response == null) {
            throw new AssertionError("No response found. Ensure an API call was made before validation.");
        }
        response.then().spec(ResponseBuilder.BuildResponse(StatusCode, message));
		
	}

}
