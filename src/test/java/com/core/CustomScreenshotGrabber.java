package com.core;


import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CustomScreenshotGrabber implements ICustomScreenshotGrabber {
    @Override
    public byte[] takeScreenshot() {

        WebDriver driver = BasePage.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
