package com.core;

import org.openqa.selenium.WebDriver;

public class WebDriverPool {

    private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return browser.get();
    }

    public static void setWebDriver(WebDriver driver) {
        browser.set(driver);
    }
}
