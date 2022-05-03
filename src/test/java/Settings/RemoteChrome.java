package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteChrome {
    public WebDriver driver;

    /** docker run -d -p 4444:4444 --shm-size=2g selenium/standalone-chrome:3.141.59-20210929 */
    //public WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());

    public RemoteChrome() throws MalformedURLException {
    }

    @BeforeClass
    public void setupDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(500);
    }

    @AfterClass
    public void CloseBrowser() {
        //driver.quit();
    }
}
