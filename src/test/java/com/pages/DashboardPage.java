package com.pages;

import com.core.BasePage;
import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy (css = "#user-info strong")
    private WebElement userName;

    public void checkTheDashboardPageIsLoadedSuccessfully() {
        waitForElementVisibility(userName, 30);
    }

    public boolean checkTheUserNameIsAsExpected(String expectedUserName) {
        Gauge.writeMessage("Username Actual  : " + userName.getText());
        Gauge.writeMessage("Username Expected: " + expectedUserName);
        return userName.getText().equalsIgnoreCase(expectedUserName);
    }

    public boolean checkTheUserUrlIsAsExpected(String urlExpected) {
        return getCurrentUrl().contains(urlExpected);
    }
}
