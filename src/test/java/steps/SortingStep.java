//package steps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import pages.CheckoutPage;
//import pages.LoginPage;
//
//public class SortingStep {
//
//    WebDriver driver;
//    LoginPage loginPage;
//    CheckoutPage checkoutPage;
//
//    @Given("user is already on homepage")
//    public void userIsAlreadyOnHomepage() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        System.out.println("ChromeDriver has been set up");
//        options.addArguments("--headless=new");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//
//
//        driver = new ChromeDriver(options);
//        loginPage = new LoginPage(driver);
//        checkoutPage = new CheckoutPage(driver);
//
//        loginPage.openLoginPage();
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickLogin();
//        delay();
//    }
//
//    @When("I click filter by {string}")
//    public void iClickFilterBy(String arg0) {
//    }
//
//    @Then("Product filtered by {string}")
//    public void productFilteredBy(String arg0) {
//    }
//
//    private void delay() { //setting delay
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//        }
//    }
//
//}
