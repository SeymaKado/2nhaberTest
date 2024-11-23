package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By navbarElements = By.cssSelector("nav a");
    private final By searchButton = By.cssSelector(".search-button-selector");

    public List<WebElement> getNavbarElements() {
        return driver.findElements(navbarElements);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}