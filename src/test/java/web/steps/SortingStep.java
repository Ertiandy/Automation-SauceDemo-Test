package web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import web.pages.LoginPage;
import web.pages.SortingPage;
import static org.junit.Assert.*;


public class SortingStep {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    SortingPage sortingPage = new SortingPage(driver);

    @Before
    public void initPages() {
        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
    }


    @And("user click filter {string}")
    public void userClickFilter(String filter) {
        sortingPage.clickFilter();
        sortingPage.SelectFilterType(filter);
    }

    @Then("then product filtered {string}")
    public void thenProductFiltered(String filterType) {
        boolean isSorted = sortingPage.verifySorting(filterType);
        assertTrue("Products are not sorted correctly by: " + filterType, isSorted);
    }
}
