import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SearchResultsPage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TakealotSearchTest {

    private static final String SEARCH_PHRASE = "iphone";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void checkTakealotSearch() {
        // Navigate to Takealot
        driver.get("https://takealot.com");

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.performSearch(SEARCH_PHRASE);

        // Wait for the search results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.product-anchor")));

        List<String> actualItems = searchResultsPage.searchResultsItemsText();
        List<String> expectedItems = searchResultsPage.searchResultsItemsWithText(SEARCH_PHRASE);

        Assertions.assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
