package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class DriverFactory {
    private final static String DRIVER_PATH = "src/test/resources/";
    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {
        File file;
        switch (browser) {
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case EDGE:
                file = new File(DRIVER_PATH + "msedgedriver.exe");
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();

        return driver;
    }
}
