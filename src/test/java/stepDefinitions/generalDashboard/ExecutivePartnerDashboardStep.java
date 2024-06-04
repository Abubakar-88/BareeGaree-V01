package stepDefinitions.generalDashboard;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        delayOfElement(5);
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
}
