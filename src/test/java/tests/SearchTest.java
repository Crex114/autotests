package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleCom(String text) throws InterruptedException {

        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainCorrectText("The Selenium Browser")
                .verifyThatTopResultContainsProperAttributeText("LC20lb MBeuO DKV0Md");
    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.openTooltip()
                .verifyThatTooltipContainsProperText("Голосовой поиск");
    }
}
