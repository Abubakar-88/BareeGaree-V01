package stepDefinitions;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.generalUserDash.GenUserDashboard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GeneralUserStep extends Base {


    GenUserDashboard genUserDashboard = new GenUserDashboard(driver);
    public static boolean switchtoRightWindow(String windowTitle, List<String> hList) {
        for(String e : hList) {
            String title = driver.switchTo().window(e).getTitle();
            if(title.contains(windowTitle)) {
                System.out.println("found the right window");
                return true;
            }
        }
        return false;
    }

    @Given("I click on login menu")
    public void iClickOnLoginMenu(){
        genUserDashboard.clickLoginMenu();
    }

    @When("I click on General user of login menu")
    public void iClickOnGeneralUserOfLoginMenu() {
        genUserDashboard.clickGeneralUser();
    }
//    @Then("I fill userName {string}")
//    public void iFillUserName(String userName) {
//        genUserDashboard.enterEmailId(userName);
//    }

//    @And("I fill password {string}")
//    public void iFillPassword(String pass) {
//        genUserDashboard.enterPassword(pass);
//    }
    @And("I click on login submit btn")
    public void iClickOnLoginSubmitBtn() {
        delayOfElement(5);
        genUserDashboard.clickLoginSubmit();
    }


    @And("I should see my profile name {string} in the dashboard")
    public void iShouldSeeMyProfileNameInTheDashboard(String name) {
        delayOfElement(10);
        String usernameText = genUserDashboard.getUsernameText();

        // Perform assertion
        Assert.assertEquals("Username text doesn't match",usernameText, name  );
    }


    @Given("I click on post add")
    public void iClickOnPostAdd() {
        genUserDashboard.clickOnPostAdd();
    }


    @When("I click on post add body")
    public void iClickOnPostAddBody() {
        genUserDashboard.clickOnPostAddBody();
    }

    @Then("I click on Properties Category")
    public void iClickOnPropertiesCategory() {
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Select Category", hList)) {
        }

        genUserDashboard.clickOnProperties();
    }

    @And("I click on Bedroom Furniture")
    public void iClickOnBedroomFurniture() {
        genUserDashboard.clickOnBedroomFurniture();
    }

    @And("I fill Title")
    public void iFillTitle() {

    }

    @And("I fill Title {string}")
    public void iFillTitle(String title) {
        delayOfElement(2);
        genUserDashboard.enterTitleOfProduct(title);
    }
    @And("I fill address {string}")
    public void iFillAddress(String address) {
        delayOfElement(2);
         genUserDashboard.enterAddress(address);
    }

    @And("I fill Description {string}")
    public void iFillDescription(String description) {
   genUserDashboard.enterDescription(description);
    }

    @And("I fill price {string}")
    public void iFillPrice(String price) {
      genUserDashboard.enterPrice(price);
    }

    @And("I click on Negotiable check btn")
    public void iClickOnNegotiableCheckBtn() {
        genUserDashboard.clickOnIsNogotiable();
    }

    @And("I fill phone number {string}")
    public void iFillPhoneNumber( String phone) {
        genUserDashboard.enterPhoneNumber(phone);
    }

    @When("the user uploads the following images:")
    public void theUserUploadsTheFollowingImages(DataTable dataTable) {
        delayOfElement(2);


        List<String> imagePaths = dataTable.asList(String.class);
        for (String imagePath : imagePaths) {
            System.out.println("Attempting to upload: " + imagePath);
            File file = new File(imagePath);
            if (file.exists()) {
                genUserDashboard.uploadImage(imagePath);
            } else {
                System.out.println("File not found: " + imagePath);
            }
        }


    }
    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        genUserDashboard.clickOnAddPostSubmitBtn();
    }


    @And("I select the district {string}")
    public void iSelectTheDistrict(String district) {
        genUserDashboard.selectDistrict(district);
    }

    @And("I select the area of Dhaka {string}")
    public void iSelectTheAreaOfDhaka(String area) {
        delayOfElement(2);
        genUserDashboard.selectArea(area);
    }

    @And("I click on Flat For Rent")
    public void iClickOnFlatForRent() {
        genUserDashboard.clickOnFlatForRent();
    }


    @And("I fill No of Bedrooms {string}")
    public void iFillNoOfBedrooms(String number) {
        genUserDashboard.fillNoOfBedroom(number);
    }

    @And("I fill No of Bathrooms {string}")
    public void iFillNoOfBathrooms(String number) {
        genUserDashboard.fillNoOfBathroom(number);
    }

    @And("I fill Size {string}")
    public void iFillSize(String number) {
        genUserDashboard.fillSizeSqft(number);
    }

    @And("I select Car Parking {string}")
    public void iSelectCarParking(String keyword) {

        genUserDashboard.selectCarParkingId(keyword);
    }

    @And("I select Apartment Features {string}")
    public void iSelectApartmentFeatures(String keyword) {
        genUserDashboard.selectApartmentFeature(keyword);
    }

    @And("I select Facing Direction {string}")
    public void iSelectFacingDirection(String keyword) {
        genUserDashboard.selectFacingDirection(keyword);
    }

    @And("I select Completion Status {string}")
    public void iSelectCompletionStatus(String keyword) {
        genUserDashboard.selectCompletionStatus(keyword);
    }

    @And("I fill Rent {string}")
    public void iFillRent(String number) {
        genUserDashboard.fillRentPerMonth(number);
    }
    
   // land for sale stepDef
    @Given("I click on Land for Sale")
    public void iClickOnLandForSale() {
        genUserDashboard.clickLandForSale();
    }

    @Then("I select Land type")
    public void iSelectLandType() {
        genUserDashboard.clickLandType();
    }

    @And("I fill land Size {string}")
    public void iFillLandSize(String size) {
        genUserDashboard.fillLandSize(size);
    }

    @And("I select land size unit {string}")
    public void iSelectLandSizeUnit(String size) {
        delayOfElement(2);
        genUserDashboard.selectPropertySizeUnit(size);
    }

    @And("I select price unit {string}")
    public void iSelectPriceUnit(String unit) {
        delayOfElement(2);
        genUserDashboard.selectPriceUnit(unit);
    }

    //Property for rent stepDef
    @Given("I click on Property For Rent")
    public void iClickOnPropertyForRent() {
         genUserDashboard.clickPropertyForRent();
    }

    @Then("I select Property type {string}")
    public void iSelectPropertyType(String type) {
        genUserDashboard.selectPropertyType(type);
    }

    @And("I fill Rent perYear {string}")
    public void iFillRentPerYear(String rent) {
        genUserDashboard.fillRentPerYear(rent);
    }
}
