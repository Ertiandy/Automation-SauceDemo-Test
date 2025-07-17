package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CheckoutStep {

    WebDriver driver;
    LoginPage loginPage;
    CheckoutPage checkout;

    @Given("user is already on homepage")
    public void userIsAlreadyOnHomepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        checkout = new CheckoutPage(driver);

        loginPage.openLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        checkout.clickAddToCart();
    }

    @When("user click cart icon")
    public void userClickCartIcon() {
        checkout.clickCartButton();
    }

    @Then("user is on checkout page")
    public void userIsOnCheckoutPage() {
        assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
    delay();
    }


    @And("user click checkout button")
    public void userClickCheckoutButton() {
        checkout.ClickCheckoutButton();
        delay();
    }

    @And("user input firstName with {string}")
    public void userInputFirstNameWith(String firstname) {
        checkout.InputFirstName(firstname);
    }

    @And("user input lastName with {string}")
    public void userInputLastNameWith(String lastname) {
        checkout.InputLastName(lastname);
    }

    @And("user input ZipCode with {string}")
    public void userInputZipCodeWith(String postalcode) {
        checkout.InputZipCode(postalcode);
        delay();
    }

    @When("user click continue button")
    public void userClickContinueButton() {
        checkout.clickContinue();
    }

    @Then("user is on checkout overview page")
    public void userIsOnCheckoutOverviewPage() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
    }

    @And("user click finish button")
    public void userClickFinishButton() {
        checkout.clickFinish();
        delay();
    }

    @Then("user is on checkout finish page")
    public void userIsOnCheckoutFinishPage() {
        assertTrue(driver.getPageSource().contains("Thank you for your order"));
        driver.quit();
    }

    private void delay() { //setting delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}