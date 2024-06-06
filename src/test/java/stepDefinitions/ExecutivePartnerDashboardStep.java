package stepDefinitions;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.exec.DaemonExecutor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.executivePartner.ExecutivePartnerDashboard;
import utilities.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ExecutivePartnerDashboardStep extends Base {
    ExecutivePartnerDashboard exPartnerDash = new ExecutivePartnerDashboard(driver);


    @When("I click on Executive partner of login menu")
    public void iClickOnExecutivePartnerOfLoginMenu() {
        exPartnerDash.clickOnExecutivePartnerLogin();
    }
    @Given("I should see {string} title in place holder")
    public void iShouldSeeTitleInPlaceHolder(String title) {
        delayOfElement(3);
        String usernameText = exPartnerDash.getInputContainerText();

        // Perform assertion
        Assert.assertEquals("Place holder text doesn't match",usernameText, title  );
    }

    @And("the user information should be displayed correctly")
    public void theUserInformationShouldBeDisplayedCorrectly(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        Assert.assertEquals(data.get("Name"), exPartnerDash.getName());
        Assert.assertEquals(data.get("User Name"), exPartnerDash.getUserName());
        Assert.assertEquals(data.get("Email"), exPartnerDash.getEmail());
        Assert.assertEquals(data.get("Phone Number"), exPartnerDash.getPhoneNumber());
        Assert.assertEquals(data.get("WhatsApp Number"), exPartnerDash.getWhatsappNumber());
        Assert.assertEquals(data.get("Reference Code"), exPartnerDash.getReferenceCode());
        Assert.assertEquals(data.get("District"), exPartnerDash.getDistrict());
        Assert.assertEquals(data.get("Area"), exPartnerDash.getArea());
    }





//    @And("I am taking data from {string} and {int}")
//    public void iAmTakingDataFromAndRowNumber(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
//        reader = new ExcelReader();
//        List<Map<String,String>> readData =
//                reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\AutoData.xlsx", sheetName);
//        postArticle = readData.get(rowNumber).get("Post Article");
//        comment = readData.get(rowNumber).get("Comment");
//    }

    @When("I click on write post")
    public void iClickOnWritePost() {
        exPartnerDash.clickOnInputContainer();
    }

//    @Then("I want write a article")
//    public void iWantWriteAArticle() {
//        Set<String> handles = driver.getWindowHandles();
//        List<String> hList = new ArrayList<String>(handles);
//        if(switchtoRightWindow("Abu Bakar Siddique", hList)) {
//        }
//        delayOfElement(4);
//
//     exPartnerDash.enterPostArticle(postArticle);
//    }

    @And("I choose about article image")
    public void iChooseAboutArticleImage(DataTable dataTable) {

        delayOfElement(3);
        List<String> imagePaths = dataTable.asList(String.class);
        for (String imagePath : imagePaths) {
            System.out.println("Attempting to upload: " + imagePath);
            File file = new File(imagePath);
            if (file.exists()) {
                exPartnerDash.addImage(imagePath);
            } else {
                System.out.println("File not found: " + imagePath);
            }
        }


    }

    @And("I click on post submit btn")
    public void iClickOnPostSubmitBtn() {
        exPartnerDash.clickOnPostSubmitClick();
    }

//    @And("I write the comment in the post")
//    public void iWriteTheCommentInThePost() {
//        delayOfElement(4);
//        exPartnerDash.enterCommentArticle(comment);
//    }

    @And("I click on download pdf btn")
    public void iClickOnDownloadPdfBtn() {
        delayOfElement(5);
        exPartnerDash.clickOndownloadCbtn();
    }

    @And("I download {string} in my computer with pdf")
    public void iDownloadInMyComputerWithPdf(String fileName) {
      delayOfElement(5);
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("English", hList)) {
        }
        delayOfElement(4);
        exPartnerDash.clickOndownloadLink();
        String filePath = System.getProperty("user.home") + "/Downloads/" + fileName;

        // Verify if the file exists using assertion
        File file = new File(filePath);
        assertTrue("File download failed or not found.", file.exists());

    }

    @And("I click on comment icon")
    public void iClickOnCommentIcon() {
        exPartnerDash.clickOnCommentIcon();
    }


    @And("I click comment submit btn")
    public void iClickCommentSubmitBtn() {
        exPartnerDash.clickOnCommentSubmit();
    }

    @Then("I write the comment in the post {string}")
    public void iWriteTheCommentInThePost(String comment) {

        delayOfElement(4);
        exPartnerDash.enterCommentArticle(comment);
    }

    @Then("I want to write a article {string}")
    public void iWantToWriteAArticle(String postArticle) {
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Abu Bakar Siddique", hList)) {
        }
        delayOfElement(4);

        exPartnerDash.enterPostArticle(postArticle);
    }

    @And("I select of Between promotion for 7 Day")
    public void iSelectOfBetweenPromotionForDay() {
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Between", hList)) {
        }
        delayOfElement(3);
        exPartnerDash.select7Day();
    }

    @And("I select Top post")
    public void iSelectTopPost() {
        delayOfElement(2);
        exPartnerDash.clickOnTopPostIcon();
    }

    @And("I select of Top post for 5 Day")
    public void iSelectOfTopPostForDay() {
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Top Post", hList)) {
        }
        delayOfElement(3);
        exPartnerDash.select5Day();
    }

    @Given("I click on the active user")
    public void iClickOnTheActiveUser() {
        delayOfElement(2);
        exPartnerDash.clickOnActiveUser();
    }

    @When("I click on the ViewAd link {string}")
    public void iClickOnTheViewAdLink(String email) {
        delayOfElement(2);
        exPartnerDash.clickPreviewLinkForAd(email);
    }

    @Then("I should be navigated to the user's active postList page")
    public void iShouldBeNavigatedToTheUserSActivePostListPage() {
        exPartnerDash.isAactiveUserPostList();
    }


    @Then("the top post should have the title {string}")
    public void theTopPostShouldHaveTheTitle(String expectedTitle) {
        delayOfElement(4);

        boolean isProductTopListed = exPartnerDash.isProductTopListed(expectedTitle);

        // Print the result
        if (isProductTopListed) {
            System.out.println("The product 'Mens Hands Begs2' is top listed.");
        } else {
            System.out.println("The product 'Mens Hands Begs2' is not top listed.");
        }

    }

    @And("I navigated to the all post of bangladesh")
    public void iNavigatedToTheAllPostOfBangladesh() {

     exPartnerDash.isNavigatedAllPost();
//        Set<String> handles = driver.getWindowHandles();
//        List<String> hList = new ArrayList<String>(handles);
//        if(switchtoRightWindow("SELECT YOUR LOCATION", hList)) {
//        }


        delayOfElement(3);
        exPartnerDash.closeModal();
    }

    @Given("I click on All ads")
    public void iClickOnAllAds() {
        delayOfElement(2);
        exPartnerDash.clickOnAllAds();
    }
    @When("I click on Rentals car")
    public void iClickOnRentalcar() {

      //  delayOfElement(3);
        exPartnerDash.clickOnAppleiPhone15();

    }


    @Then("I click on the post details boost")
    public void iClickOnThePostDetailsBoost() {
        delayOfElement(2);
        exPartnerDash.clickOnPostDetailsBoost();
    }

    @And("I navigated to the boost page of this post")
    public void iNavigatedToTheBoostPageOfThisPost() {
        exPartnerDash.isNavigatedBoostPage();
    }

    @And("I select of Between promotion for 5 Day amount")
    public void iSelectOfBetweenPromotionForDayAmount() {
        delayOfElement(2);
        exPartnerDash.select5daysAmount();
    }


}
