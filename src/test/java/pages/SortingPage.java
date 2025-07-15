package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingPage {
    WebDriver driver;

    public SortingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Pilih filter
    public void selectFilterBy(String filter) {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + filter + "']")).click();
    }

    // Sorting High - Low
    public boolean isSortedByLowToHighPrice() {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceValues = prices.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
        return isAscending(priceValues);
    }

    // Sorting High - Low
    public boolean isSortedByHighToLowPrice() {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceValues = prices.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
        return isDescending(priceValues);
    }

    // Sorting A - Z
    public boolean isSortedByNameAToZ() {
        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        List<String> nameValues = names.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return isAscending(nameValues);
    }

    // Sorting dari Z - A
    public boolean isSortedByNameZToA() {
        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        List<String> nameValues = names.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return isDescending(nameValues);
    }

    // Utility methods untuk cek ascending
    private <T extends Comparable<T>> boolean isAscending(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    // Utility methods untuk cek descending
    private <T extends Comparable<T>> boolean isDescending(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
