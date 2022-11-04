package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;
import utils.PropertyReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver driver;
    SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {

        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(PropertyReader.getUrl());
        //driver = DriverFactory.getDriver(Browser.CHROME);
        //driver.get("https://google.com");
        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvidetMethod() {
        return new Object[][]{
                {"selenium java"}}
                ; //, {"selenium javascript"}};
    }
}
