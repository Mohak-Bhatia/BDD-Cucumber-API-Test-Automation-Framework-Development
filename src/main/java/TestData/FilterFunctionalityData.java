package TestData;

import java.util.List;

public class FilterFunctionalityData {
	
	private int maxPrice;
	private int minPrice;
	private List<String> productCategory;
	private List<String> productFor;
	private String productName;
	private List<String> productSubCategory;
	
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public List<String> getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(List<String> productCategory) {
		this.productCategory = productCategory;
	}
	public List<String> getProductFor() {
		return productFor;
	}
	public void setProductFor(List<String> productFor) {
		this.productFor = productFor;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<String> getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(List<String> productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
}
