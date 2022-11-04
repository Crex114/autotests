package steps;

import pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();

    public SearhResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        //searchPage.fillSearchField(keyword);
        searchPage.pasteToSearchField(keyword);
        //searchPage.pressEnter();
        searchPage.clickSearchButtonOrPressEnter();
        //Thread.sleep(3000);
        return new SearhResultsSteps();
    }

    public SearchSteps openTooltip() {
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text) {
        searchPage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }

}
