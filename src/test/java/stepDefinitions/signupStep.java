package stepDefinitions;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SignupPage;
import utilities.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class signupStep extends Base {
    SignupPage signUpPage = new SignupPage(driver);
    HomePage homePage = new HomePage(driver);
//    String email;
//    String password;
//    String confirmPassword;
//    String userName;
//    String firstName;
//    String lastName;
//    String mobileNumber;
//    String whatsappNumber;
//    String district;
//    String thana;
//    String referenceCode;



    //Signup page
    @And("I click on the Signup Menu")
    public void clickOnTheSignupMenu() throws InterruptedException {
        Thread.sleep(3000);
        signUpPage.clickSignUpDropdown();
    }

    @Then("I click on the General User of dropdown menu")
    public void clickOnTheGeneralUserOfDropdownMenu()  {

        signUpPage.clickGeneralUserLink();
    }

    @Then("I should see the {string} title on the signup page")
    public void shouldSeeTheTitleOnTheSignupPage(String expectedTitle) {
        WebElement titleElement = signUpPage.getSignUpTitleElement();
        String actualTitle = titleElement.getText();
        assertEquals(expectedTitle, actualTitle);
    }


//    @And("I fill out the signup form with data from {string} and {int}")
//    public void iFillOutTheSignupFormWithDataFromAndRowNumber(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
//        reader = new ExcelReader();
//        List<Map<String,String>> readData =
//                reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\AutoData.xlsx", sheetName);
//        firstName = readData.get(rowNumber).get("First name");
//        lastName = readData.get(rowNumber).get("Last name");
//        email = readData.get(rowNumber).get("Email");
//        userName = readData.get(rowNumber).get("UserName");
//        district = readData.get(rowNumber).get("District");
//        thana = readData.get(rowNumber).get("Thana");
//        password = readData.get(rowNumber).get("Password");
//        confirmPassword = readData.get(rowNumber).get("Confirm Password");
//        mobileNumber = readData.get(rowNumber).get("Mobile Number");
//        whatsappNumber = readData.get(rowNumber).get("Whatsapp Number");
//        referenceCode = readData.get(rowNumber).get("ReferenceCode");
//    }

    @And("I fill first name {string}")
    public void iFillFirstName( String fName) {
        signUpPage.enterFirstName(fName);
    }
    @And("I fill last name {string}")
    public void iFillLastName(String lName) {
        signUpPage.enterLastName(lName);

    }

    @Then("I fill userName {string}")
    public void iFillUserName(String userName) {
        signUpPage.enterUserName(userName);
    }

    @And("I fill email {string}")
    public void iFillEmail(String email) {
        signUpPage.enterEmail(email);
    }

    @And("I fill password {string}")
    public void iFillPassword(String password) {
        signUpPage.enterPassword(password);
    }

    @And("I fill confirm password {string}")
    public void iFillConfirmPassword(String confirmPassword) {
        signUpPage.enterConfirmPassword(confirmPassword);
    }
    @And("I select district name {string}")
    public void iSelectDistrictName(String district)  {
        signUpPage.selectDistrict(district);
    }

    @And("I select thana name {string}")
    public void iSelectThanaName(String thana) {
        delayOfElement(2);
        signUpPage.selectThana(thana);
    }

    @And("I fill mobile number {string}")
    public void iFillMobileNumber(String mobileNumber) {
        signUpPage.enterPhone(mobileNumber);
    }

    @And("I fill whatsapp number {string}")
    public void iFillWhatsappNumber(String whatsappNumber) {
        signUpPage.enterWhatsappNumber(whatsappNumber);
    }

    @Then("And I click on the Sign Up button")
    public void andIClickOnTheSignUpButton() {
    }

    @And("I agree with the terms and conditions")
    public void iAgreeWithTheTermsAndConditions() {
        signUpPage.agreeWithTermsAndConditions();
    }

    @Then("I click on the Sign Up button")
    public void iClickOnTheSignUpButton()  {
        signUpPage.clickSignUpButton();
    }

    @Given("I open the Browser and Navigate to the URL {string}")
    public void i_open_the_Browser_and_Navigate_to_the_URL(String string) {

        WebDriver driver = new ChromeDriver();
        driver.get(string);
        //scenario.log("Opened the Browser with URL: " + string);

    }




    @Then("I hover on Member menu")
    public void iHoverOnMemberMenu() {
        homePage.hoverOnMember();
    }

    @And("I click on Platinum")
    public void iClickOnPlatinum() {
        homePage.clickOnPlatinum();
    }


    @And("I should see member position name filter by Platinum")
    public void iShouldSeeMemberPositionNameFilterByPlatinum() {
        List<WebElement> postBrandNames = homePage.getPostBrandNames();

        // Iterate through the list of elements and print their text
        for (WebElement postBrandName : postBrandNames) {
            System.out.println(postBrandName.getText());
        }
    }

    @And("I fill reference code {string}")
    public void iFillReferenceCode(String referenceCode) {
        signUpPage.enterReferenceCode(referenceCode);
    }
}
