package pojo;

import java.util.List;

import TestData.FilterFunctionalityData;

public class FilterFunctionalityDataBuild {
	
	public static FilterFunctionalityData ProductName(String productName) {
		FilterFunctionalityData data = new FilterFunctionalityData();
		data.setProductName(productName);
		
		return data;
	}
	
	public static FilterFunctionalityData ProductPrices(int minPrice,int maxPrice) {
		FilterFunctionalityData data = new FilterFunctionalityData();
		data.setMinPrice(minPrice);
		data.setMaxPrice(maxPrice);
		
		return data;
	}
	
	public static FilterFunctionalityData ProductCategory(List<String> ProductCategory) {
		FilterFunctionalityData data = new FilterFunctionalityData();
		data.setProductCategory(ProductCategory);		
		
		return data;
	}
	
	public static FilterFunctionalityData ProductSubCategory(List<String> ProductSubCategory) {
		FilterFunctionalityData data = new FilterFunctionalityData();
		data.setProductSubCategory(ProductSubCategory);		
		
		return data;
	}

	public static FilterFunctionalityData Gender(List<String> productFor) {
		FilterFunctionalityData data = new FilterFunctionalityData();
		data.setProductFor(productFor);		
		
		return data;
	}
	
}
