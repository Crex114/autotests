package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='Z26q7c UK95Uc jGGQ5e']//div[@class='yuRUbf']//h3")
    private WebElement resultRow;

    @FindBy(xpath = "//div[@class='Z26q7c UK95Uc jGGQ5e']//div[@class='yuRUbf']//h3")
    private List<WebElement> resultRows;

    public SearchResultsPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        wait.until(ExpectedConditions.visibilityOfAllElements(resultRows));
        //assertThat(resultRow.isDisplayed()).as("Element has not been displayed").isTrue();
        assertThat(resultRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString()).as("Wrong text " +
                "has been displayed!").contains(expected);
    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {
        assertThat(resultRow.getAttribute("class")).as("wrong attibute text").contains(expected);
    }
}
