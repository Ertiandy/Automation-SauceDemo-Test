package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.SortingPage;

public class SortingStep {

    WebDriver driver;
    LoginPage loginPage;
    SortingPage Sorting;

    @Given("I already Logged in")
    public void userIsAlreadyOnHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver ();
        loginPage = new LoginPage(driver);
        Sorting = new SortingPage(driver);

        loginPage.openLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        delay ();
    }

    @When("I click filter by {string}")
    public void iClickFilterBy(String filter) {
        Sorting.selectFilterBy(filter); // Sekarang parameternya digunakan
    }

    @Then("Product filtered by {string}")
    public void productFilteredBy(String arg0, String arg1) {
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupted status
            e.printStackTrace();
        }
    }

}
