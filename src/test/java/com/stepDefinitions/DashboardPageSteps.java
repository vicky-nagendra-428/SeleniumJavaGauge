package com.stepDefinitions;

import com.pages.DashboardPage;
import com.pages.SignupPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import static org.testng.Assert.assertTrue;

public class DashboardPageSteps {

    DashboardPage dashboardPage = new DashboardPage();

    @Step ("Then I check the logged in dashboard Page is loaded successfully")
    public void checkTheUserIsLoggedInSuccessfully() {
        dashboardPage.checkTheDashboardPageIsLoadedSuccessfully();
    }

    @Step ("And I check the username is as expected")
    public void validateTheUserName() {
        String expectedUserName = InslySignupSteps.ds.get("currentUserName").toString();
        assertTrue(dashboardPage.checkTheUserNameIsAsExpected(expectedUserName), "Expected userName : " + expectedUserName);
    }

    @Step ("And url of the user is as expected")
    public void validateTheUrlOfTheUser() {
        String expectedUserUrl = InslySignupSteps.ds.get("currentUserUrl").toString();
        assertTrue(dashboardPage.checkTheUserUrlIsAsExpected(expectedUserUrl), "Expected Url : " + expectedUserUrl);
    }
}
