package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.SortingPage;
import static org.junit.Assert.assertTrue;


public class SortingStep {

    WebDriver driver;
    LoginPage loginPage;
    SortingPage Sorting;

    @Given("I already Logged in")
    public void userIsAlreadyOnHomepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
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
        Sorting.selectFilterBy(filter);
        delay ();
    }


    @Then("Product filtered by {string}")
    public void productFilteredBy(String filterName) {
        boolean isSorted = false;

        switch (filterName) {
            case "Price (low to high)":
                isSorted = Sorting.isSortedByLowToHighPrice();
                break;
            case "Price (high to low)":
                isSorted = Sorting.isSortedByHighToLowPrice();
                break;
            case "Name (A to Z)":
                isSorted = Sorting.isSortedByNameAToZ();
                break;
            case "Name (Z to A)":
                isSorted = Sorting.isSortedByNameZToA();
                break;
            default:
                throw new IllegalArgumentException("Unsupported filter: " + filterName);
        }

        assertTrue("Produk tidak terurut sesuai filter: " + filterName, isSorted);
        driver.quit();
    }

    private void delay() { //setting delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //
            e.printStackTrace();
        }
    }

}
