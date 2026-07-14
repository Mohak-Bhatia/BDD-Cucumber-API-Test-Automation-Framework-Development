package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.UserLoginCredentials;
import propertiesFetcher.FetchResources;
import utils.Report;

public class Hooks {

    private static String accessToken;
    private static ExtentReports report = Report.TestReport();

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

    @After
    public void afterTest(Scenario scenario) {
        io.cucumber.java.Status status = scenario.getStatus();
        if (status == io.cucumber.java.Status.FAILED) {
            report.addTestRunnerOutput("FAIL");
        } else if (status == io.cucumber.java.Status.PASSED) {
            report.addTestRunnerOutput("PASS");
        } else {
            report.addTestRunnerOutput("SKIPPED");
        }
    }

    @AfterAll
    public static void TestTeardown() {
        report.getStats();
        report.flush();
    }
}
