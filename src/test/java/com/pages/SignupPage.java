package com.pages;

import com.core.BasePage;
import com.core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignupPage extends BasePage {

    public SignupPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy (css = "h1")
    private WebElement h1;

    @FindBy (id = "broker_name")
    private WebElement companyName;

    @FindBy (id = "broker_address_country")
    private WebElement country;

    @FindBy (css = "#field_broker_tag span.icon-ok")
    private WebElement inslyAddressAutoFillOk;

    @FindBy (id = "prop_company_profile")
    private WebElement companyProfile;

    @FindBy (id = "prop_company_no_employees")
    private WebElement noOfEmployees;

    @FindBy (id = "prop_company_person_description")
    private WebElement yourDescription;

    @FindBy (id = "broker_admin_email")
    private WebElement workEmail;

    @FindBy (id = "broker_admin_name")
    private WebElement managerName;

    @FindBy (css = "#field_broker_person_password a")
    private WebElement suggestSecurePasswordLink;

    @FindBy (id = "broker_person_password")
    private WebElement password;

    @FindBy (id = "broker_person_password_repeat")
    private WebElement reEnterPassword;

    @FindBy (id = "broker_admin_phone")
    private WebElement phoneNumber;

    @FindBy (id = "agree_termsandconditions")
    private WebElement agreeTermsAndConditionsCheckBox;

    @FindBy (id = "agree_privacypolicy")
    private WebElement privacyPolicyCheckBox;

    @FindBy (id = "agree_data_processing")
    private WebElement dataProcessingCheckBox;

    @FindBy (id = "submit_save")
    private WebElement signUpButton;

    @FindBy (css = "div.checklist a")
    private List<WebElement> termsAndCondtionsLinks;

    @FindBy (css = "#insly_alert b")
    private WebElement inslyPasswordAlertText;

    @FindBy (css = ".ui-dialog-buttonset button.primary")
    private WebElement popupOk;

    @FindBy (css = ".ui-dialog-titlebar>span")
    private List<WebElement> dialogTitles;

    @FindBy (css = ".ui-dialog[style*='block'] span.icon-close")
    private WebElement closeButton;

    @FindBy (css = ".ui-dialog[style*='block'] span.ui-dialog-title")
    private List<WebElement> popupTitles;

    @FindBy (css = ".ui-dialog.ui-widget-content[style*='block']")
    private WebElement openedPopupContent;

    @FindBy (css = "div[style*='padding-top']")
    private WebElement revisionInfo;

    @FindBy (css = ".subtitle")
    private List<WebElement> subSections;

    private String companyNameEntered = "";
    private String passwordEntered = "";
    public String urlOfTheCurrentUser = "";

    public void loadTheSignUpPage(String url) {
        goToUrl(url);
    }

    public boolean checkSignUpPageIsLoaded(String h1Expected) {
        return h1.getText().equalsIgnoreCase(h1Expected);
    }

    public boolean checkThePageForSubSections(String subsectionsExpected){

        int counter = 0;
        for (WebElement subsection : subSections) {

            if(!subsection.getText().isEmpty() && subsectionsExpected.contains(subsection.getText())) {
                counter++;
            }
        }
        return counter == subsectionsExpected.split(",").length;
    }

    public boolean getSignUpButtonStatus() {
        return isElementDisplayed(signUpButton);
    }

    public void enterCompanyName(String companyNameText) {
        if (companyNameText.equalsIgnoreCase("RANDOM")) {
            String ramdomText = "random" + System.currentTimeMillis();
            companyNameEntered = ramdomText;
            urlOfTheCurrentUser = companyNameEntered + ".insly.com";
            clearAndEnterText(companyName, ramdomText);
        } else {
            clearAndEnterText(companyName, companyNameText);
        }
    }

    public void selectCountry(String countryText) {
        selectDropdownByText(country, countryText);
    }

    public void selectCompanyProfile(String companyProfileText) {
        if (companyProfileText.equalsIgnoreCase("RANDOM") || companyProfileText.isEmpty()) {
            selectDropDownByIndexRandomly(companyProfile);
        } else {
            selectDropdownByText(companyProfile, companyProfileText);
        }
    }

    public void selectNoOfEmployees(String noOfEmployeesText) {
        if (noOfEmployeesText.equalsIgnoreCase("RANDOM") || noOfEmployeesText.isEmpty()) {
            selectDropDownByIndexRandomly(noOfEmployees);
        } else {
            selectDropdownByText(noOfEmployees, noOfEmployeesText);
        }
    }

    public void selectDescription(String description) {
        if (description.equalsIgnoreCase("RANDOM") || description.isEmpty()) {
            selectDropDownByIndexRandomly(yourDescription);
        } else {
            selectDropdownByText(yourDescription, description);
        }
    }

    public boolean checkInslyAddressIsAsPerCompanyNameEntered() {

        int counter = 0;
        while ((!isElementDisplayed(inslyAddressAutoFillOk)) && counter<=10) {
            Utils.waitForSeconds(1);
            counter++;
        }
        return isElementDisplayed(inslyAddressAutoFillOk);
    }

    public void enterWorkEmail(String emailText) {
        if (emailText.equalsIgnoreCase("RANDOM") || emailText.isEmpty()) {
            clearAndEnterText(workEmail, companyNameEntered + "@mail.com");
        } else {
            clearAndEnterText(workEmail, emailText);
        }
    }

    public String enterAccountManagerName(String nameText) {
        if (nameText.equalsIgnoreCase("RANDOM") || nameText.isEmpty()) {
            clearAndEnterText(managerName, companyNameEntered + " Name");
            return companyNameEntered + " Name";
        } else {
            clearAndEnterText(managerName, nameText);
            return nameText;
        }
    }

    public void enterPhoneNumber(String phoneNumberText) {
        clearAndEnterText(phoneNumber, phoneNumberText);
    }

    public void clickOnSuggestASecurePasswordLink() {
        scrollToElementAndClick(suggestSecurePasswordLink);
    }

    public boolean checkTheAlertIsPresent() {

        waitForElementVisibility(inslyPasswordAlertText, 5);
        return isElementDisplayed(inslyPasswordAlertText);
    }

    public void getThePasswordEntered() {

        if (checkTheAlertIsPresent()) {
            passwordEntered = inslyPasswordAlertText.getText();
        }
        System.out.println("Got the pwd : " + passwordEntered);
        acceptPasswordPopup();
    }

    private void clickOnPopUpAccept(String text) {

        waitForElementVisibility(popupOk, 5);
        if (popupOk.getText().equalsIgnoreCase(text)) {
            popupOk.click();
        }

    }

    public void clickTermsAndConditionsCheckBox() {
        scrollToElementAndClick(agreeTermsAndConditionsCheckBox);
    }

    public void clickPrivacyPolicyCheckBox() {
        scrollToElementAndClick(privacyPolicyCheckBox);
    }

    public void clickProcessingDataCheckBox() {
        scrollToElementAndClick(dataProcessingCheckBox);
    }

    public void clickOnTermsAndConditionsLink() {

        for (WebElement link : termsAndCondtionsLinks) {
            if (link.getText().equalsIgnoreCase("terms and conditions")) {
                link.click();
                break;
            }
        }
        waitForElementVisibility(openedPopupContent, 5);
        scrollElementIntoView(revisionInfo);
    }

    public void acceptPasswordPopup() {
        clickOnPopUpAccept("ok");
    }

    public void acceptTermsAndConditions() {
        clickOnPopUpAccept("I AGREE");
    }

    public void clickOnPrivacyPolicyLink() {
        for (WebElement link : termsAndCondtionsLinks) {
            if (link.getText().equalsIgnoreCase("privacy policy")) {
                link.click();
                break;
            }
        }
    }

    public void closeThePrivacyPolicy() {

        boolean clicked = false;
        int counter = 0;

        while ((!clicked) && (counter <= 5)) {

            if (isElementDisplayed(closeButton)) {
                closeButton.click();
                clicked = true;
                break;
            }
            counter++;

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            closeButton = getWebDriver().findElement(By.cssSelector(".ui-dialog[style*='block'] span.icon-close"));
        }
    }

    public boolean checkSignUpButtonIsEnabled() {
        return isElementEnabled(signUpButton);
    }

    public String clickOnSignUpButton() {
        waitForElementClickability(signUpButton, 5);
        scrollToElementAndClick(signUpButton);
        return urlOfTheCurrentUser;
    }

}
