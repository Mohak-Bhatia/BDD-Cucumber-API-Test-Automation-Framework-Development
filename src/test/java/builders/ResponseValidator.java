package builders;

import io.restassured.response.Response;

public class ResponseValidator {
	
	private static ThreadLocal<Response> lastResponse = new ThreadLocal<>();

    public static void setLastResponse(Response response) {
        lastResponse.set(response);
    }

    public static Response getLastResponse() {
        return lastResponse.get();
    }

    public static void clearLastResponse() {
        lastResponse.remove();
    }

}
