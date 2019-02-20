package com.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    public static WebDriver getWebDriver() {
        return WebDriverPool.getWebDriver();
    }

    public static String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    public void goToUrl(String url) {
        getWebDriver().get(url);
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectDropDownByIndexRandomly(WebElement dropdown) {
        Select selectElement = new Select(dropdown);
        int noOfOptions = selectElement.getOptions().size();
        selectElement.selectByIndex(Utils.getARandomNumberBetween(1, noOfOptions));
    }

    public void selectDropdownByIndex(WebElement dropdown, int index) {
        Select selectElement = new Select(dropdown);
        selectElement.selectByIndex(index);
    }

    public void selectDropdownByText(WebElement dropdown, String text) {
        Select selectElement = new Select(dropdown);
        selectElement.selectByVisibleText(text);
    }

    public void clearAndEnterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElementAndClick(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);arguments[0].click();", element);
    }

    public static void waitForElementVisibility(WebElement element, int waitTime) {
        getWebDriver().manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
        try {
            (new WebDriverWait(getWebDriver(), waitTime, 1000L)).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException | StaleElementReferenceException e) {
            throw e;
        }

        getWebDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static void waitForElementClickability(WebElement element, int waitTime) {
        getWebDriver().manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
        try {
            (new WebDriverWait(getWebDriver(), waitTime, 1000L)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | StaleElementReferenceException e) {
            throw e;
        }

        getWebDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public void scrollElementIntoView(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }
}
