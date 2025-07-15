package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToChart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void clickChartButton() {
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
        driver.findElement (By.id ("postal-code")).sendKeys (postalCode);
    }

    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }
}

 