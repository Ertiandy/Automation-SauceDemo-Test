package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickAddToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        button.click();
    }

    public void clickAddToCartEachItems() {
        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        button1.click();
        WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bike-light")));
        button2.click();
        WebElement button3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bolt-t-shirt")));
        button3.click();
        WebElement button4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-fleece-jacket")));
        button4.click();
        WebElement button5 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-onesie")));
        button5.click();
        WebElement button6 = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
        button6.click();
    }

    public void clickCartButton() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shopping_cart_container\"]/a")));
        cart.click();
    }

    public void ClickCheckoutButton() {
        WebElement checkoutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id ("checkout")
                )
        );
        checkoutBtn.click();
    }

    public void InputFirstName(String firstName) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        input.sendKeys(firstName);
    }

    public void InputLastName(String lastName) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        input.sendKeys(lastName);
    }

    public void InputZipCode(String postalCode) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
        input.sendKeys(postalCode);
    }

    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueBtn.click();
    }

    public void clickFinish() {
        WebElement finishBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        finishBtn.click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }
}
