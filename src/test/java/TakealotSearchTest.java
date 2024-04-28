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

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TakealotSearchTest {

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

        // Find the search element and perform a search
        WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
        String searchPhrase = "iPhone";
        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);

        // Wait for the search results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.product-anchor")));

        // List off items
        List<WebElement> itemElements = driver.findElements(By.cssSelector("a.product-anchor"));
        List<String> actualItems = itemElements.stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());

        // Verify that the search results contain the expected items
        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(searchPhrase.toLowerCase()))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
