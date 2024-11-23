package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;
import utilities.Driver;

import java.time.Duration;

import java.util.List;

public class NavbarAndSearchSteps {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Given("the user is on the 2NHABER homepage")
    public void the_user_is_on_the_2nhaber_homepage() {
        driver.get("https://2nhaber.com/");
    }


    @When("the user clicks on each navbar element")
    public void the_user_clicks_on_each_navbar_element() {
        List<WebElement> navbarElements = homePage.getNavbarElements();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        for (WebElement element : navbarElements) {
            String linkText = element.getText();
            jsExecutor.executeScript("arguments[0].click();", element);
            Assert.assertTrue(driver.getCurrentUrl().contains("2nhaber"), "Sayfa doğru şekilde açılmadı: " + linkText);
            driver.navigate().back();
            navbarElements = homePage.getNavbarElements();
        }
    }






    @When("the user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        homePage.clickSearchButton();
    }

    @When("the user searches for \"(.*)\"")
    public void the_user_searches_for(String query) {
        searchPage.enterSearchQuery(query);
    }

    @Then("the user should navigate to the {int}th news detail page")
    public void the_user_should_navigate_to_the_th_news_detail_page(int index) {
        WebElement newsLink = searchPage.getSearchResultByIndex(index);
        newsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("haber"), "Haber detayı sayfasına gidilemedi");
    }
}

