package steps;

import pages.SearchResultsPage;

public class SearhResultsSteps {
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearhResultsSteps verifyThatTopResultContainCorrectText(String text) {
        searchResultsPage.assertThatTopResultContainsCorrectText(text);
        return this;

    }

    public SearhResultsSteps verifyThatTopResultContainsProperAttributeText(String text) {
        searchResultsPage.assertThatTopResultContainsProperAttributeText(text);
        return this;

    }

}



