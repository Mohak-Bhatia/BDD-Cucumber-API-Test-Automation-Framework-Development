# BDD-Cucumber-API-Test-Automation-Framework-Development

A comprehensive, enterprise-grade **Behavior-Driven Development (BDD) API testing framework** for e-commerce filtering APIs using Cucumber, REST Assured, and Java. Designed for scalability, maintainability, and seamless CI/CD integration.

---

## 📋 Overview

This framework demonstrates **professional-level API automation** leveraging industry best practices:
- **Business-Centric Testing** via Gherkin feature files (non-technical stakeholders can read tests)
- **Data-Driven Testing** using Scenario Outlines with parametrized Examples (16+ test scenarios)
- **Production-Ready CI/CD** with automated daily test execution via GitHub Actions
- **Clean Architecture** with Builder Pattern, Service Layer, and Hooks lifecycle management
- **Comprehensive Reporting** with ExtentReports and thread-safe concurrent execution

Automated **16+ test cases** across **5 filtering scenarios**: Product Search, Price Range, Category, Subcategory, and Gender-based filtering.

---

## 🛠 Technology Stack

| Component | Technology | Version | Purpose |
|-----------|-----------|---------|---------|
| **Language** | Java | 21 | Core programming language |
| **BDD Framework** | Cucumber | 7.34.3 | Gherkin test scenarios for business alignment |
| **API Testing** | REST Assured | 6.0.0 | HTTP client for API request/response validation |
| **Test Framework** | JUnit 4 | - | Test execution alongside Cucumber |
| **Build Tool** | Maven | - | Dependency management and build automation |
| **Reporting** | ExtentReports | 5.1.2 | Interactive HTML reports with real-time dashboards |
| **CI/CD** | GitHub Actions | - | Automated scheduled test execution |
| **Utilities** | Commons-IO | 2.21.0 | File I/O operations |

---

## ✨ Key Features

### 1. **BDD with Cucumber & Gherkin**
```gherkin
@FilterFeature
Feature: Filter Functionality APIs

  @FilterBySearch
  Scenario Outline: Filter by Product Name
    Given I click on search bar with "<productName>"
    Then I Validate the <ResponseCode> and "<ResponseMessage>"
    
    Examples:
      | productName | ResponseCode | ResponseMessage                   |
      | Adidas      | 200          | All Products fetched Successfully |
      | Reebok      | 200          | No Products Found                 |
```
- Non-technical stakeholders can read, understand, and review test scenarios
- Tags (`@FilterFeature`, `@FilterBySearch`, etc.) enable selective test execution
- Clear Given-When-Then structure for behavior-driven validation

### 2. **Data-Driven Testing with Scenario Outlines**
- **16+ parametrized test cases** generated from 5 Scenario Outlines
- Examples tables provide multiple data inputs for:
  - Product name search (2 cases)
  - Price range filtering (2 cases)
  - Category selection (5 cases - single & multiple)
  - Subcategory filtering (4 cases)
  - Gender-based filtering (3 cases)
- Single scenario template, multiple test executions = DRY principle

### 3. **Design Patterns & Clean Architecture**

#### **Builder Pattern**
```java
// RequestBuilder.java - Fluent API request construction
RequestSpecification req = new RequestSpecBuilder()
    .addHeader("Authorization", Hooks.getAccessToken())
    .setBaseUri(FetchResources.getBaseUri())
    .setContentType(ContentType.JSON)
    .build();
```

#### **Service Layer Pattern**
```java
// Services decouple business logic from step definitions
public class FilterService {
    public static void FilterBySearch(String productName) { ... }
    public static void FilterByCategory(List<String> categories) { ... }
}
```

#### **ThreadLocal Pattern**
```java
// Thread-safe response management for parallel execution
private static ThreadLocal<Response> lastResponse = new ThreadLocal<>();
```

### 4. **Cucumber Hooks Lifecycle Management**
```java
@BeforeAll          // One-time setup: JWT authentication
@Before             // Per-scenario setup: Create test entry in report
@After              // Per-scenario teardown: Log results
@AfterAll           // Final cleanup: Flush reports
```
- Centralized login & token extraction in `@BeforeAll`
- Per-scenario test tracking with ExtentReports
- Automatic cleanup after all tests

### 5. **CI/CD Integration - GitHub Actions**
```yaml
name: Daily API BDD TESTS

on:
  schedule:
    # Runs at 9:00 AM IST (3:30 AM UTC), Monday to Friday
    - cron: '30 3 * * 1-5'

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - Checkout code
      - Set up JDK 21
      - Run Cucumber tests with @FilterFeature tag
      - Upload test results as artifacts
```
- **Automated scheduled execution** (no manual intervention needed)
- **Artifact uploads** for report retention and analysis
- **Tag-based selective execution** via Maven command line
- **Linux environment** ensures cross-platform compatibility

### 6. **ExtentReports Integration**
- **Interactive HTML dashboards** with test execution trends
- **Real-time status tracking** (PASS/FAIL/SKIP)
- **Thread-safe concurrent reporting** for parallel test execution
- **Scenario-level metrics** and test duration tracking

### 7. **Advanced Test Data Management**
```java
// Efficient test data handling with Lists and parsing
List<String> categories = parseCsv("fashion,household");
FilterService.FilterByCategory(categories);
```
- CSV string parsing for comma-separated values
- Null-safe handling and empty collection validation
- Flexible input formats for real-world API scenarios

---

## 📁 Project Structure

```
src/
├── main/java/
│   ├── propertiesFetcher/
│   │   └── FetchResources.java       # Configuration management (Base URI, Login endpoint)
│   ├── utils/
│   │   └── Report.java               # ExtentReports initialization & configuration
│   └── TestData/
│       ├── LoginData.java            # POJO for login credentials
│       └── FilterFunctionalityData.java  # POJO for filter test data
│
├── test/java/
│   ├── stepDefinitions/
│   │   ├── FilterStepDefinitions.java   # Gherkin step implementations for filtering
│   │   └── Hooks.java                   # Lifecycle management (@Before, @After, @BeforeAll)
│   ├── service/
│   │   ├── FilterService.java           # Business logic for filter operations
│   │   └── ResponseValidationService.java # Response assertion & validation
│   ├── builders/
│   │   ├── RequestBuilder.java          # Builder pattern for REST requests
│   │   ├── ResponseBuilder.java         # Builder pattern for REST responses
│   │   └── ResponseValidator.java       # ThreadLocal response storage
│   └── pojo/
│       ├── UserLoginCredentials.java    # POJO for API request bodies
│       └── FilterFunctionalityDataBuild.java  # POJO for filter payloads
│
└── test/resources/
    ├── feature/
    │   └── Filter.feature               # 5 Scenario Outlines, 16+ test cases
    └── TestReports/                     # ExtentReports HTML output

pom.xml                                  # Maven configuration & dependencies
.github/workflows/maven.yml              # GitHub Actions CI/CD pipeline
```

---

## 🚀 How to Run

### **Prerequisites**
- Java 21 or higher
- Maven 3.6+
- Active internet connection (for API testing)

### **Setup**
```bash
# Clone the repository
git clone https://github.com/Mohak-Bhatia/BDD-Cucumber-API-Test-Automation-Framework-Development.git
cd BDD-Cucumber-API-Test-Automation-Framework-Development

# Install dependencies
mvn clean install
```

### **Run All Tests**
```bash
mvn test
```

### **Run Specific Feature Tag**
```bash
# Run only Search filter tests
mvn test -Dcucumber.filter.tags="@FilterBySearch"

# Run only Category filter tests
mvn test -Dcucumber.filter.tags="@FilterByCategory"

# Run entire Filter feature
mvn test -Dcucumber.filter.tags="@FilterFeature"
```

### **Run with Parallel Execution**
```bash
mvn test -DthreadCount=4 -Dparallel=methods
```

### **Generate Reports**
After test execution, reports are available at:
```
target/cucumber-reports/index.html
```

---

## 📊 Test Coverage

### **Scenario Breakdown**

| Feature | Scenario | Test Cases | Coverage |
|---------|----------|-----------|----------|
| **Filter Functionality** | Product Search | 2 | Brand & no results |
| | Price Range | 2 | Valid & invalid range |
| | Categories | 5 | Single, multiple, edge cases |
| | Subcategories | 4 | Single, multiple combinations |
| | Gender | 3 | Single, multiple options |
| **Total** | 5 Scenario Outlines | **16+ Test Cases** | Comprehensive filtering |

### **Test Scenarios Include**
✅ Happy path scenarios (successful filter operations)  
✅ Empty result scenarios (no products found)  
✅ Multiple filter combinations  
✅ Edge cases (comma-separated values)  
✅ Response code validation (HTTP 200)  
✅ Response message validation (Business-level assertions)  

---

## 🔧 Configuration

### **Base Configuration** (`FetchResources.java`)
```java
public static String getBaseUri() {
    return "https://your-api-endpoint.com";
}

public static String getLoginResource() {
    return "/login";  // Relative endpoint
}
```

### **Authentication Flow** (`Hooks.java`)
```java
@BeforeAll
public static void beforeAll() {
    // Login once before all scenarios
    Response response = given()
        .header("Content-Type", "application/json")
        .body(UserLoginCredentials.LogInCredentials())
    .when()
        .post(FetchResources.getBaseUri() + FetchResources.getLoginResource())
    .then()
        .extract().response();
    
    // Extract & reuse token for all subsequent requests
    accessToken = new JsonPath(response.asString()).getString("token");
}
```

---

## 🏗 Architecture Highlights

### **Service Layer Abstraction**
```
Step Definitions (Gherkin → Java)
        ↓
Service Layer (Business Logic)
        ↓
Builders (Request/Response Construction)
        ↓
REST Assured (HTTP Client)
        ↓
API Endpoints
```

### **Thread-Safe Concurrent Execution**
- `ThreadLocal<Response>` for response management
- `ConcurrentHashMap` for scenario-level tracking
- ExtentReports thread-safe test creation

### **Single Responsibility Principle**
- `FilterStepDefinitions.java` → Gherkin step implementation only
- `FilterService.java` → Filter business logic only
- `ResponseValidationService.java` → Assertion logic only
- `RequestBuilder.java` → Request construction only

---

## 📈 CI/CD Pipeline - GitHub Actions

### **Automated Execution Schedule**
```
Every Weekday: Monday to Friday
Time: 9:00 AM IST (3:30 AM UTC)
Frequency: Daily
```

### **Pipeline Steps**
1. **Code Checkout** → Pull latest repo code
2. **JDK Setup** → Install Java 21 (Temurin distribution)
3. **Test Execution** → Run `mvn test -DCucumber.tags="@FilterFeature"`
4. **Artifact Upload** → Store test reports for analysis

### **Workflow File** (`.github/workflows/maven.yml`)
```yaml
- name: Run Cucumber Filter Feature Tests
  run: mvn test -DCucumber.tags="@FilterFeature"

- name: Upload test results
  if: always()  # Upload even if tests fail
  uses: actions/upload-artifact@v3
  with:
    name: cucumber-results
    path: target/cucumber-reports/
```

---

## 🎯 Design Patterns Utilized

### **1. Builder Pattern**
- **Where:** `RequestBuilder.java`, `ResponseBuilder.java`
- **Why:** Fluent, readable API request/response construction
- **Benefit:** Easy to maintain and extend request specifications

### **2. Service Layer Pattern**
- **Where:** `FilterService.java`, `ResponseValidationService.java`
- **Why:** Decouples test logic from business logic
- **Benefit:** Reusable services across multiple step definitions

### **3. Page/Endpoint Object Model (POM)**
- **Where:** Service layer acts as endpoint abstraction
- **Why:** Centralize API operations in one place
- **Benefit:** Single point of change when API contracts change

### **4. ThreadLocal Pattern**
- **Where:** `ResponseValidator.java`, `Listeners.java`
- **Why:** Thread-safe storage for concurrent test execution
- **Benefit:** Multiple tests can run in parallel without data collision

### **5. POJO (Plain Old Java Object) Pattern**
- **Where:** `UserLoginCredentials.java`, `FilterFunctionalityDataBuild.java`
- **Why:** Clean data representation and JSON serialization
- **Benefit:** REST Assured automatically marshals POJOs to/from JSON

### **6. Hooks Lifecycle Pattern**
- **Where:** `Hooks.java` with `@Before`, `@After`, `@BeforeAll`, `@AfterAll`
- **Why:** Centralized setup and teardown
- **Benefit:** DRY principle; reuse across all scenarios

---

## 📝 Reporting & Insights

### **ExtentReports Dashboard**
- Real-time test execution status
- Scenario-level pass/fail breakdown
- Test duration metrics
- Log entries for each step
- System information (environment, timestamp)

### **Report Location**
```
target/cucumber-reports/index.html  → Open in browser
```

---

## 🔮 Future Enhancements & Roadmap

### **Planned Features**
- ✅ **Current:** Filter Feature (Product, Price, Category, Subcategory, Gender)
- 🔄 **In Progress:** Cart & Checkout APIs
- 📋 **Planned:** Order History & Payment APIs
- 🛍️ **Planned:** Wishlist & Product Reviews APIs
- 🔐 **Planned:** Authentication & Authorization scenarios
- 📱 **Planned:** Error handling & negative test scenarios (4xx, 5xx responses)

### **Framework Enhancements**
- Configuration externalization (properties files, environment variables)
- Advanced logging with SLF4J & Logback
- Test retry mechanisms for flaky API behavior
- Performance benchmarking & response time analytics
- Multi-environment support (DEV, QA, STAGING, PROD)
- Allure Report integration for advanced analytics

---

## 🤝 Contributing

This framework is designed to be **scalable and maintainable**:

1. **Adding New Feature:** Create `.feature` file in `src/test/resources/feature/`
2. **Implementing Steps:** Create step definitions in `src/test/java/stepDefinitions/`
3. **Business Logic:** Add service methods in `src/test/java/service/`
4. **Test Data:** Extend POJOs in `src/test/java/pojo/`

---

## 📌 Key Takeaways

✅ **Production-Ready Framework** → Enterprise-grade patterns and practices  
✅ **Scalable Architecture** → Easy to extend with new features  
✅ **BDD Approach** → Business stakeholders can understand tests  
✅ **Data-Driven Testing** → 16+ scenarios from minimal test code  
✅ **Automated CI/CD** → Tests run daily without manual intervention  
✅ **Professional Reporting** → Interactive dashboards with metrics  
✅ **Thread-Safe Execution** → Parallel test runs without conflicts  
✅ **Clean Code** → Single Responsibility, DRY, SOLID principles  

---

## 📧 Contact & Support

**Author:** Mohak Bhatia  
**Repository:** [BDD-Cucumber-API-Test-Automation-Framework-Development](https://github.com/Mohak-Bhatia/BDD-Cucumber-API-Test-Automation-Framework-Development)  
**Experience:** 11 months of Test Automation Engineering  

---

## 📚 Resources & References

- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [REST Assured Guide](https://rest-assured.io/)
- [ExtentReports](https://extentreports.com/)
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Maven Documentation](https://maven.apache.org/)

---

**Last Updated:** July 2026  
**Version:** 1.0.0
