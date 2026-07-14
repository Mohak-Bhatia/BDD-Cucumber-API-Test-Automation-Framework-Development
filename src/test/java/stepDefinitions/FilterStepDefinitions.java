package stepDefinitions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import service.FilterService;
import service.ResponseValidationService;

public class FilterStepDefinitions {
	
	@Given("I click on search bar with {string}")
	public void i_click_on_search_bar_with_product_name(String productName) {
		FilterService.FilterBySearch(productName);
	}

	@Then("I Validate the {int} and {string}")
	public void i_validate_the_response_code_and_response_message(int StatusCode, String message) {
		ResponseValidationService.ValidateResponse(StatusCode, message);
	}

	@Given("I enter the price range with {int} and {int}")
	public void i_enter_the_price_range_with_min_price_and_max_price(int minPrice,int maxPrice) {
		FilterService.FilterByPrices(minPrice, maxPrice);
	}

	@Given("I choose {string} of my choice")
	public void i_choose_category_of_my_choice(String csv) {
		List<String> Category = parseCsv(csv);
		FilterService.FilterByCategory(Category);
	}

	@Given("I choose a particular {string}")
	public void i_choose_a_particular_subcategory(String csv) {
		List<String> SubCategory = parseCsv(csv);
	    FilterService.FilterBySubCategory(SubCategory);
	}

	@Given("I choose {string}")
	public void i_choose_gender(String csv) {
		List<String> Gender = parseCsv(csv);
		FilterService.FilterByGender(Gender);
	}
	
	private List<String> parseCsv(String csv) {
        if (csv == null) return Collections.emptyList();
        String trimmed = csv.trim();
        if (trimmed.isEmpty()) return Collections.emptyList();
        // strip surrounding quotes if present
        if (trimmed.startsWith("\"") && trimmed.endsWith("\"") && trimmed.length() >= 2) {
            trimmed = trimmed.substring(1, trimmed.length() - 1).trim();
        }
        if (trimmed.isEmpty()) return Collections.emptyList();
        return Arrays.stream(trimmed.split(","))
                     .map(String::trim)
                     .filter(s -> !s.isEmpty())
                     .collect(Collectors.toList());
    }

}
