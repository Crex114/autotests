package Home;

import Settings.ConfProperties;
import Settings.RemoteChrome;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;

public class Search extends RemoteChrome {
    SoftAssert softAssert = new SoftAssert();

    public Search() throws MalformedURLException {
    }

    @Test (priority = 1)
    public void Go() {
        driver.get(ConfProperties.getProperty("homepage"));
    }

    @Test (priority = 2)
    public void search() {

        driver.findElement(By.xpath("//*[contains(text(), 'Другие документы')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Главная')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Название документа']")).sendKeys(ConfProperties.getProperty("testtext"));

        var expectedtitlesearch = "Нет подходящих результатов";
        var actualtitlesearch = driver.findElement(By.xpath("//*[contains(text(), 'Нет подходящих результатов')]")).getText();
        softAssert.assertTrue(expectedtitlesearch.equals(actualtitlesearch), "\n Поиск: не работает");

        softAssert.assertAll();
        driver.findElement(By.xpath("//*[contains(text(), 'Перейти в каталог')]")).click();
    }

}