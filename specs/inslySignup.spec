# Specification : Insly SignUp Feature

Tags : SignupFlow

## Validation : Insly Signup

* Given I load the insly signup page "https://signup.insly.com/signup"
* When the signup page loaded successfully with title "Sign up and start using"
* Then I verify the form for correctness

* When I enter the company name "RANDOM"
* And I choose the country "Thailand"
* And I select the company profile ""
* And I selec the number of employees ""
* And I choose the value "" from how would you describe your self
* Then I verify that insly address filed is auto filled with the company name given
* When I enter the work email "RANDOM"
* And I enter account manager name "RANDOM"
* And I click on suggest a secure password button
* Then I capture the password
* And I enter the phone number "+66612345665"

* When I check all terms and conditions checkboxes
* And I click on terms and conditions link
* And I click on I agree
* And I click on privacy policy
* And I close the popup
* Then I check Sign up button is enabled
* And I click on sign up button

* Then I check the logged in dashboard Page is loaded successfully
* And I check the username is as expected
* And url of the user is as expected





