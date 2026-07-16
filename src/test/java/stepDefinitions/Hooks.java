package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.UserLoginCredentials;
import propertiesFetcher.FetchResources;
import utils.Report;

public class Hooks {

    private static String accessToken;
    private static ExtentReports report = Report.TestReport();
    private static final Map<String, ExtentTest> tests = new ConcurrentHashMap<>();

    @BeforeAll
    public static void beforeAll() {
        Response response = given()
            .header("Content-Type","application/json").body(UserLoginCredentials.LogInCredentials())
        .when()
            .post(FetchResources.getBaseUri().concat(FetchResources.getLoginResource()))
        .then()
            .log().ifStatusCodeIsEqualTo(200)
            .extract().response();

        String body = response.asString();
        JsonPath jp = new JsonPath(body);
        Assert.assertEquals(jp.getString("message"), "Login Successfully");
        accessToken = jp.getString("token");
    }

    public static String getAccessToken() {
        return accessToken;
    }
    
    @Before
    public void beforeTest(Scenario scenario) {
    	String scenarioName = scenario.getName();
        String key = scenario.getId(); // unique id per scenario run
        ExtentTest test = report.createTest(scenarioName);
        tests.put(key, test);
        test.info("Scenario started: " + scenarioName);
    }
    
    @After
    public void afterTest(Scenario scenario) {
    	String key = scenario.getId();
        ExtentTest test = tests.get(key);
        io.cucumber.java.Status status = scenario.getStatus();
        if (status == io.cucumber.java.Status.FAILED) {
        	test.fail("FAILED");
        	report.addTestRunnerOutput("FAIL");
        } else if (status == io.cucumber.java.Status.PASSED) {
        	test.pass("PASSED");
            report.addTestRunnerOutput("PASS");
        } else {
        	test.skip("SKIPPED");
            report.addTestRunnerOutput("SKIPPED");
        }
    }

    @AfterAll
    public static void TestTeardown() {
        report.getStats();
        report.flush();
    }
}
