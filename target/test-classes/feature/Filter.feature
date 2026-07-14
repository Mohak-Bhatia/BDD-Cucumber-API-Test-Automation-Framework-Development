@FilterFeature
Feature: Filter Functionality APIs
	
	@FilterBySearch
	Scenario Outline: Filter by Product Name
	    Given I click on search bar with <productName>
        Then I Validate the <ResponseCode> and <ResponseMessage>
        
        Examples:
		productName | ResponseCode | ResponseMessage
		Adidas      | 200          | All Products fetched Successfully
		Reebok      | 200          | No Products Found
		
	@FilterByPriceRange
	Scenario Outline: Filter by Price Range
	    Given I enter the price range with <minPrice> and <maxPrice>
        Then I Validate the <ResponseCode> and <ResponseMessage>
        
        Examples:
		minPrice  | maxPrice |ResponseCode | ResponseMessage
		5999      |12000     |200          | All Products fetched Successfully
		7000      |3000      |200          | No Products Found	
		
	@FilterByCategory
	Scenario Outline: Filter by Categories
	    Given I choose "<Category>" of my choice
        Then I Validate the <ResponseCode> and <ResponseMessage>
        
        Examples:
		Category         | ResponseCode | ResponseMessage
		fashion          | 200          | All Products fetched Successfully
		cars             | 200          | No Products Found
		fashion,household| 200          | All Products fetched Successfully
		building,cars    | 200          | No Products Found
		fashion,cars     | 200          | All Products fetched Successfully
		
	@FilterBySubCategory
	Scenario Outline: Filter by Subcategories
	    Given I choose a particular "<Subcategory>"
        Then I Validate the <ResponseCode> and <ResponseMessage>
        
        Examples:
		Subcategory      | ResponseCode | ResponseMessage
		shoes            | 200          | No Products Found
		diamond          | 200          | No Products Found
		mobiles,laptops  | 200          | All Products fetched Successfully
		buildings,mobiles| 200          | All Products fetched Successfully
		
	@FilterByGender
	Scenario Outline: Filter by Gender
	    Given I choose "<Gender>"
        Then I Validate the <ResponseCode> and <ResponseMessage>
        
        Examples:
		Gender   | ResponseCode | ResponseMessage
		men,women| 200          | All Products fetched Successfully
		women    | 200          | All Products fetched Successfully		