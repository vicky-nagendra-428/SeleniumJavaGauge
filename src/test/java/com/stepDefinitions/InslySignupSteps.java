package com.stepDefinitions;

import com.pages.SignupPage;
import com.thoughtworks.gauge.datastore.*;
import com.thoughtworks.gauge.Step;

import static org.testng.Assert.assertTrue;

public class InslySignupSteps {

    static DataStore ds = DataStoreFactory.getScenarioDataStore();
    SignupPage signupPage = new SignupPage();

    @Step ("Then I verify the form for correctness")
    public void verifyTheLoadedFormCorrectness() {
        assertTrue(signupPage.checkThePageForSubSections("Company,Add user,Administrator account details,Terms and conditions"), "Form is not as expected");
        assertTrue(signupPage.getSignUpButtonStatus() == false, "Sign up button should not be enabled");
    }

    @Step ("Given I load the insly signup page <signUpUrl>")
    public void implementation1(String signUpUrl) {
        signupPage.loadTheSignUpPage(signUpUrl);
    }

    @Step ("When the signup page loaded successfully with title <Sign up and start using>")
    public void checkTheSignupPageLoadedSuccessfully(String signUpPageTitle) {
        signupPage.checkSignUpPageIsLoaded(signUpPageTitle);
    }

    @Step ("And I choose the country <THAILAND>")
    public void chooseTheCountry(String country) {
        signupPage.selectCountry(country);
    }

    @Step ("When I enter the company name <RANDOM>")
    public void enterTheCompanyName(String companyName) {
        signupPage.enterCompanyName(companyName);
    }

    @Step ("And I select the company profile <>")
    public void selectCompanyProfile(String companyProfile) {
        signupPage.selectCompanyProfile(companyProfile);
    }

    @Step ("And I selec the number of employees <>")
    public void selectTheNoOfEmployees(String noOfEmployees) {
        signupPage.selectNoOfEmployees(noOfEmployees);
    }

    @Step ("And I choose the value <> from how would you describe your self")
    public void describeYourself(String description) {
        signupPage.selectDescription(description);
    }

    @Step ("When I enter the work email <>")
    public void enterTheWorkEmail(String email) {
        signupPage.enterWorkEmail(email);
    }

    @Step ("And I enter account manager name <RANDOM>")
    public void enterTheAccountManager(String accountManager) {
        ds.put("currentUserName", signupPage.enterAccountManagerName(accountManager));
    }

    @Step ("And I click on suggest a secure password button")
    public void clickOnSuggestSecurePassword() {
        signupPage.clickOnSuggestASecurePasswordLink();
        assertTrue(signupPage.checkTheAlertIsPresent(), "Password alert is not present");
    }

    @Step ("Then I capture the password")
    public void captureThePassword() {
        signupPage.getThePasswordEntered();
    }

    @Step ("And I enter the phone number <PhoneNumber>")
    public void enterThePhoneNumber(String phNo) {
        signupPage.enterPhoneNumber(phNo);
    }

    @Step ("When I check all terms and conditions checkboxes")
    public void checkAllTermsAndConditions() {
        signupPage.clickTermsAndConditionsCheckBox();
        signupPage.clickPrivacyPolicyCheckBox();
        signupPage.clickProcessingDataCheckBox();
    }

    @Step ("And I click on terms and conditions link")
    public void clickOnTermsAndConditionsLink() {
        signupPage.clickOnTermsAndConditionsLink();
    }

    @Step ("And I click on I agree")
    public void clickOnIAgreeOnPopup() {
        signupPage.acceptTermsAndConditions();
    }

    @Step ("And I click on privacy policy")
    public void clickOnPrivacyPolicy() {
        signupPage.clickOnPrivacyPolicyLink();
    }

    @Step ("And I close the popup")
    public void closeTheTermsPopup() {
        signupPage.closeThePrivacyPolicy();
    }

    @Step ("Then I check Sign up button is enabled")
    public void checkSignUpButtonIsEnabled() {
        assertTrue(signupPage.checkSignUpButtonIsEnabled(), "SignUp is not enabled");
    }

    @Step ("And I click on sign up button")
    public void clickOnSignUp() {
        ds.put("currentUserUrl", signupPage.clickOnSignUpButton());
    }

    @Step ("Then I verify that insly address filed is auto filled with the company name given")
    public void checkTheAddressFieldIsAutofilled() {
        assertTrue(signupPage.checkInslyAddressIsAsPerCompanyNameEntered());
    }

}
