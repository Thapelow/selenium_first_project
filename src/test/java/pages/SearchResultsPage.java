package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {
    /**
     * Lists searched results
     * <p>
     * Verify that the search results contain the expected items
     * <p>
     * return them as Strings for comparison
     */
    @FindBy(css = "a.product-anchor")
    private List<WebElement> searchResultItems;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public List<String> searchResultsItemsText(){
        return searchResultItems.stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchText){
        return searchResultsItemsText().stream()
                .filter(item -> item.contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
}
