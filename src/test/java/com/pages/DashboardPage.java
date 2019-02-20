package com.pages;

import com.core.BasePage;
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
        System.out.println("Username : " + userName.getText());
        System.out.println("Username : " + expectedUserName);
        return userName.getText().equalsIgnoreCase(expectedUserName);
    }

    public boolean checkTheUserUrlIsAsExpected(String urlExpected) {
        return getCurrentUrl().contains(urlExpected);
    }
}
