package pages;

import org.openqa.selenium.By;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        button.click();
    }

    public void clickCartButton() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shopping_cart_container a")));
        cart.click();
    }

    public void ClickCheckoutButton() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
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
}
