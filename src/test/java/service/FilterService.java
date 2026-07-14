package service;

import java.util.List;

import builders.RequestBuilder;
import builders.ResponseValidator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.FilterFunctionalityDataBuild;
import propertiesFetcher.FetchResources;

public class FilterService {
	
	
	public static Response FilterBySearch(String productName) {
		
		Response response = (Response) RestAssured.given().spec(RequestBuilder.BuildRequest()).body(FilterFunctionalityDataBuild.ProductName(productName)).post(FetchResources.getFilterResource());
		ResponseValidator.setLastResponse(response);
		return response;
	}
	
	public static Response FilterByPrices(int minPrice,int maxPrice) {
		Response response = (Response) RestAssured.given().spec(RequestBuilder.BuildRequest()).body(FilterFunctionalityDataBuild.ProductPrices(minPrice,maxPrice)).post(FetchResources.getFilterResource());
		ResponseValidator.setLastResponse(response);
		return response;
	}
	
	public static Response FilterByCategory(List<String> Category) {
		Response response = (Response) RestAssured.given().spec(RequestBuilder.BuildRequest()).body(FilterFunctionalityDataBuild.ProductCategory(Category)).post(FetchResources.getFilterResource());
		ResponseValidator.setLastResponse(response);
		return response;
	}
	
	public static Response FilterBySubCategory(List<String> SubCategory) {
		Response response = (Response) RestAssured.given().spec(RequestBuilder.BuildRequest()).body(FilterFunctionalityDataBuild.ProductSubCategory(SubCategory)).post(FetchResources.getFilterResource());
		ResponseValidator.setLastResponse(response);
		return response;
	}
	
	public static Response FilterByGender(List<String> Gender) {
		Response response = (Response) RestAssured.given().spec(RequestBuilder.BuildRequest()).body(FilterFunctionalityDataBuild.Gender(Gender)).post(FetchResources.getFilterResource());
		ResponseValidator.setLastResponse(response);
		return response;
	}

}
