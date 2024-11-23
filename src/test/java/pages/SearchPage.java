package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInput = By.cssSelector(".search-input-selector");
    private By searchResultLinks = By.cssSelector(".search-result-link-selector");

    public void enterSearchQuery(String query) {
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchInput).submit();
    }

    public WebElement getSearchResultByIndex(int index) {
        return driver.findElements(searchResultLinks).get(index - 1);
    }
}