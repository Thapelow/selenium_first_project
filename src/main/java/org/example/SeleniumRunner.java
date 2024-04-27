package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumRunner {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to Takealot
        driver.get("https://takealot.com");

        // Find the search element and perform a search
        WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
        String searchPhrase = "iPhone";
        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);

        // Wait for the search results to load
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // List off items
        List<WebElement> itemElements = driver.findElements(By.cssSelector("a.product-anchor"));
        List<String> actualItems = itemElements.stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());

        // Verify that the search results contain the expected items
        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(searchPhrase.toLowerCase()))
                .collect(Collectors.toList());

        for (int i = 0; i < actualItems.size() && i < expectedItems.size(); i++) {
            System.out.println(actualItems.get(i) + " => " + expectedItems.get(i));
        }

        Assertions.assertEquals(expectedItems, actualItems);

        driver.quit();
    }
}