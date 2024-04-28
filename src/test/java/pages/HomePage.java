package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebPage {
    /**
     * // Find the search element and perform a search
     */
    @FindBy(css = "[name='search']")
    private WebElement searchInput;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void performSearch(String searchPhrase){
        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);
    }
}
