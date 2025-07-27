package web.steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.pages.LoginPage;

import static org.junit.Assert.*;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        WebDriverManager.chromedriver().setup();
        System.out.println("ChromeDriver has been set up");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = Hooks.driver;
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.enterUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.enterPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        assertEquals("https://www.saucedemo.com/inventory.html", loginPage.getUrl());
    }


    @Then("user view message on login page {string}")
    public void userViewMessageOnLoginPage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
