
package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import static org.junit.Assert.*;

import java.time.Duration;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;


    @Given("user is on login page")
    public void userIsOnLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver();
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
        assertEquals ("https://www.saucedemo.com/inventory.html", loginPage.getUrl ());
        try {
            Thread.sleep(3000); // buat delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }





}
