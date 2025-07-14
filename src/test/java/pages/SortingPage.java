package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SortingPage {
    WebDriver driver;

    public SortingPage (WebDriver driver){
        this.driver = driver;
    }

    public void selectFilterBy(String filterName) {
        Select filterDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        filterDropdown.selectByVisibleText(filterName);
    }
}
