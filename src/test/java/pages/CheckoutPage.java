package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void clickCartButton() {
        driver.findElement(By.xpath ("//*[@id=\"shopping_cart_container\"]/a")).click ();
    }

    public void ClickCheckoutButton(){
        driver.findElement(By.id("checkout")).click();
    }

    public void InputFirstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    public void InputLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    public void InputZipCode(String postalCode) {
        driver.findElement (By.xpath ("//*[@id=\"postal-code\"]")).sendKeys (postalCode);
    }

    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }
}

 