package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;


    public SortingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickFilter() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.className("product_sort_container")));
        button.click();
    }

    public boolean verifySorting(String filterType) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
        List<WebElement> productElements;
        List<String> names = new ArrayList<>();
        List<Double> prices = new ArrayList<>();

        switch (filterType) {
            case "az":
            case "za":
                productElements = driver.findElements(By.className("inventory_item_name"));
                for (WebElement el : productElements) {
                    names.add(el.getText());
                }
                List<String> sortedNames = new ArrayList<>(names);
                if (filterType.equals("az")) {
                    Collections.sort(sortedNames);
                } else {
                    Collections.sort(sortedNames, Collections.reverseOrder());
                }
                return names.equals(sortedNames);

            case "lohi":
            case "hilo":
                productElements = driver.findElements(By.className("inventory_item_price"));
                for (WebElement el : productElements) {
                    String priceText = el.getText().replace("$", "");
                    prices.add(Double.parseDouble(priceText));
                }
                List<Double> sortedPrices = new ArrayList<>(prices);
                if (filterType.equals("lohi")) {
                    Collections.sort(sortedPrices);
                } else {
                    Collections.sort(sortedPrices, Collections.reverseOrder());
                }
                return prices.equals(sortedPrices);
        }
        return false;
    }

    public void SelectFilterType(String filterType) {
        By filterLocator;
        switch (filterType) {
            case "az":
                filterLocator = By.cssSelector("option[value='az']");
                break;
            case "za":
                filterLocator = By.cssSelector("option[value='za']");
                break;
            case "lohi":
                filterLocator = By.cssSelector("option[value='lohi']");
                break;
            case "hilo":
                filterLocator = By.cssSelector("option[value='hilo']");
                break;
            default:
                throw new IllegalArgumentException("Unknown filter: " + filterType);
        }
        wait.until(ExpectedConditions.elementToBeClickable(filterLocator));
        driver.findElement(filterLocator).click();
    }



}