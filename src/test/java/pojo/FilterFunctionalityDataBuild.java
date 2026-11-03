package pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import TestData.FilterFunctionalityData;

public class FilterFunctionalityDataBuild {

    /*
     * 
     *
     * productName: ""
     * minPrice: null
     * maxPrice: null
     * productCategory: []
     * productFor: []
     * productSubCategory: []
     */
    private static FilterFunctionalityData defaultFilter() {
        return new FilterFunctionalityData();
    }

    private static List<String> safeList(List<String> values) {
        return values == null
                ? new ArrayList<>(Collections.<String>emptyList())
                : new ArrayList<>(values);
    }

    public static FilterFunctionalityData ProductName(String productName) {
        FilterFunctionalityData data = defaultFilter();
        data.setProductName(productName == null ? "" : productName);
        return data;
    }

    public static FilterFunctionalityData ProductPrices(Integer minPrice, Integer maxPrice) {
        FilterFunctionalityData data = defaultFilter();
        data.setMinPrice(minPrice);
        data.setMaxPrice(maxPrice);
        return data;
    }

    public static FilterFunctionalityData ProductCategory(List<String> productCategory) {
        FilterFunctionalityData data = defaultFilter();
        data.setProductCategory(safeList(productCategory));
        return data;
    }

    public static FilterFunctionalityData ProductSubCategory(List<String> productSubCategory) {
        FilterFunctionalityData data = defaultFilter();
        data.setProductSubCategory(safeList(productSubCategory));
        return data;
    }

    public static FilterFunctionalityData Gender(List<String> productFor) {
        FilterFunctionalityData data = defaultFilter();
        data.setProductFor(safeList(productFor));
        return data;
    }
}
