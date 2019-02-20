package com.core;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private String browserName;
    WebDriver driver = null;

    @BeforeScenario
    public void setUp() {
        browserName = System.getenv("BROWSER");

        switch (browserName) {
            case "CHROME":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        WebDriverPool.setWebDriver(driver);
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null) {
            WebDriver driver = WebDriverPool.getWebDriver();
            driver.quit();
        }
    }

}
