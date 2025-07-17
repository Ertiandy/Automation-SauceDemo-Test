package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.LoginPage;

import static org.junit.Assert.*;

public class CheckoutStep {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    CheckoutPage checkout = new CheckoutPage(driver);

    @Given("user is already on homepage")
    public void userIsAlreadyOnHomepage() {
        loginPage.openLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Verifikasi login berhasil
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        checkout.clickAddToCart();
    }

    @When("user click cart icon")
    public void userClickCartIcon() {
        checkout.clickCartButton();
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        checkout.ClickCheckoutButton();
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
    }

    @Then("user is on checkout finish page")
    public void userIsOnCheckoutFinishPage() {
        assertTrue(driver.getPageSource().contains("Thank you for your order"));
    }
}
