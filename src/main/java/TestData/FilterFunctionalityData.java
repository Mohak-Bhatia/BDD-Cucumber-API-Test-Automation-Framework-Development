package TestData;

import java.util.ArrayList;
import java.util.List;

public class FilterFunctionalityData {

    private Integer maxPrice;
    private Integer minPrice;
    private List<String> productCategory = new ArrayList<>();
    private List<String> productFor = new ArrayList<>();
    private String productName = "";
    private List<String> productSubCategory = new ArrayList<>();

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
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
