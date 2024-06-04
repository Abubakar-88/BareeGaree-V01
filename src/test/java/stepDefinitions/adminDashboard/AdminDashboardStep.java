package stepDefinitions.adminDashboard;

import base.Base;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.adminDashboard.ActivePost;
import pages.adminDashboard.GeneralUser;
import pages.adminDashboard.PendingPost;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class AdminDashboardStep extends Base {

    ActivePost acPElectronics = new ActivePost(driver);
   GeneralUser generalUser = new GeneralUser(driver);
   PendingPost pendingPost = new PendingPost(driver);

    @Given("I hover on Active post")
    public void iHoverOnActivePost() {
        delayOfElement(10);
        acPElectronics.hoverOnActivePost();
    }

    @When("I click on active Electronics")
    public void iClickOnActiveElectronics() {
        delayOfElement(10);
        acPElectronics.clickOnActiveEelectronics();
    }

    @When("I search with {string}")
    public void iSearchWith(String searchValue) {
        acPElectronics.search(searchValue);
    }

    @Then("I should see {string} search results that match the {string}")
    public void iShouldSeeSearchResultsThatMatch(String headerName, String expectedValue) {
//        Assert.assertTrue("Expected value: " + expectedValue + " not found in search results.",
//                acPElectronics.validateSearchResults(expectedValue));
        delayOfElement(4);
        List<String> columnValues = acPElectronics.getColumnValues(headerName);
        System.out.println("column value: " + columnValues);

        boolean found = false;
        for (String value : columnValues) {
            if (value.contains(expectedValue)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue("Expected value: " + expectedValue + " not found in column values: " + columnValues, found);

    }


    @Given("I am on the admin login page")
    public void iAmOnTheAdminLoginPage() {
        navigateURL(adminHost);
    }

    @Given("I download the Excel file")
    public void iDownloadTheExcelFile() {
        delayOfElement(2);
        acPElectronics.downloadExcel();

    }


    @Then("I check the Excel file {string} contains the correct column headers")
    public void iCheckTheExcelFileContainsTheCorrectColumnHeaders(String filePath, DataTable dataTable) throws IOException, CsvValidationException {
        delayOfElement(3);
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        List<String> expectedHeaders = dataTable.asList(String.class);

        // Define the downloaded file path
        File file = new File(downloadPath + filePath); // specify your downloaded file name

        // Read the CSV file
        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReader(fileReader);

        // Read the first row (headers)
        String[] actualHeaders = csvReader.readNext();

        for (String expectedHeader : expectedHeaders) {
            boolean headerFound = false;
            for (String actualHeader : actualHeaders) {
                if (actualHeader.trim().equalsIgnoreCase(expectedHeader.trim())) {
                    headerFound = true;
                    break;
                }
            }
            Assert.assertTrue("Header not found: " + expectedHeader, headerFound);
        }

        csvReader.close();
        fileReader.close();
    }

    @Then("I check the values in the Excel file {string} match the website values")
    public void iCheckTheValuesInTheExcelFileMatchTheWebsiteValuesForColumn( String fileName, DataTable dataTable) throws Exception {
        delayOfElement(3);
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        File file = new File(downloadPath + fileName); // specify your downloaded file name

        // Read the CSV file
        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReader(fileReader);

        // Read headers and all rows
        String[] headers = csvReader.readNext();
        List<String[]> csvRows = csvReader.readAll();
        // Expected headers from the DataTable
        List<Map<String, String>> expectedHeadersMap = dataTable.asMaps(String.class, String.class);
        List<String> expectedHeaders = expectedHeadersMap.stream()
                .map(map -> map.values().iterator().next().trim())
                .collect(Collectors.toList());

        // Verify column by column
        for (String expectedHeader : expectedHeaders) {
            String trimmedExpectedHeader = expectedHeader.trim();
            int columnIndex = getColumnIndex(headers, trimmedExpectedHeader);

            List<String> csvColumnValues = csvRows.stream()
                    .map(row -> row[columnIndex])
                    .collect(Collectors.toList());

            List<String> websiteColumnValues = acPElectronics.getColumnValues(trimmedExpectedHeader);
// Log sizes for debugging
            System.out.println("CSV column size: " + csvColumnValues.size());
            System.out.println("Website column size: " + websiteColumnValues.size());

            // Compare the values
          //  Assert.assertTrue("The number of values in the CSV file and the website do not match for column: " + trimmedExpectedHeader, csvColumnValues.size(), websiteColumnValues.size());
//        if(websiteColumnValues.size() >csvColumnValues.size()){
//            Assert.assertFalse("The number of values in the CSV file and the website do not match for column: " +  csvColumnValues.size(), websiteColumnValues.size());
//
//        }


            for (int i = 0; i < websiteColumnValues.size(); i++) {
                Assert.assertTrue("Value at row " + (i + 1) + " for column " + trimmedExpectedHeader + " does not match. Expected: " +websiteColumnValues.get(i)  + " but found: " + csvColumnValues.get(i),
                        websiteColumnValues.get(i).contains(csvColumnValues.get(i).trim()));
            }


        }


        csvReader.close();
        fileReader.close();
    }

    private int getColumnIndex(String[] headers, String headerName) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(headerName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Header not found: " + headerName);
    }



    @Then("I should see the following column headers")
    public void iShouldSeeTheFollowingColumnHeaders(List<String> expectedHeaders) {
        delayOfElement(2);
        List<String> actualHeaders = acPElectronics.getColumnHeaders();
        for (String expectedHeader : expectedHeaders) {
            Assert.assertTrue("Expected header not found: " + expectedHeader, actualHeaders.contains(expectedHeader));
        }
    }

    @When("I click on the {string} column header")
    public void iClickOnTheColumnHeader(String headerName) {
        delayOfElement(3);
        acPElectronics.clickColumnHeader(headerName);
    }

    @Then("I should see the table sorted by {string} in {string} order")
    public void iShouldSeeTheTableSortedByInOrder(String headerName, String order) {
        List<String> columnValues = acPElectronics.getColumnValues(headerName);

        List<String> sortedValues = new ArrayList<>(columnValues);
        if (order.equals("ascending")) {
            sortedValues.sort(String.CASE_INSENSITIVE_ORDER);
        } else if (order.equals("descending")) {
            sortedValues.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER.reversed()));
        }

        Assert.assertEquals(sortedValues, columnValues);
    }

    @Given("I filter the {string} column with condition {string} and value {string}")
    public void iFilterTheColumnWithConditionAndValue(String headerName, String condition, String value) {
        delayOfElement(4);
        acPElectronics.openFilterMenu(headerName);
        delayOfElement(2);
        acPElectronics.setFirstFilterCondition(condition, value);
    }

    @When("I select or logical {string}")
    public void iSelectOrLogical(String logical) {
        delayOfElement(2);
        acPElectronics.setLogicalOperator(logical);
    }

    @Then("I filter the column with Or logical {string} and value {string}")
    public void iFilterTheColumnWithOrLogicalAndValue(String condition, String value) {
        delayOfElement(2);
        acPElectronics.setSecondFilterCondition(condition, value);


    }
    @Then("the {string} column should contain the value {string}")
    public void theColumnShouldContainTheValue(String headerName, String expectedValue) {

        delayOfElement(4);
        List<String> columnValues = acPElectronics.getColumnValues(headerName);
        System.out.println("column value: " + columnValues);

        boolean found = false;
        for (String value : columnValues) {
            if (value.contains(expectedValue)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue("Expected value: " + expectedValue + " not found in column values: " + columnValues, found);
    }
    @Then("the {string} column should not contain the value {string}")
    public void theColumnShouldNotContainTheValue(String headerName, String expectedValue) {

        delayOfElement(4);
        List<String> columnValues = acPElectronics.getColumnValues(headerName);
        System.out.println("column value: " + columnValues);

        boolean found = false;
        for (String value : columnValues) {
            if (value.contains(expectedValue)) {
                found = true;
                break;
            }
        }

        Assert.assertFalse("Expected value: " + expectedValue + " was found in column values: " + columnValues, found);
    }

    @Then("I clear the filter")
    public void iClearTheFilter() {
        delayOfElement(2);
        acPElectronics.clearFilter();
    }

    @Then("I filter the Date column with Or logical {string} and value {string}")
    public void iFilterTheDateColumnWithOrLogicalAndValue(String condition, String value) {
        delayOfElement(3);
        acPElectronics.setSecondFilterConditionOfSubCategoryHeader(condition, value);
      //  delayOfElement(2);
       // acPElectronics.applyFilter();
    }

    @And("I apply the filter")
    public void iApplyTheFilter() {
        delayOfElement(2);
        acPElectronics.applyFilter();
    }

    @Given("I filter the {string} column with Total active condition {string} and value {string}")
    public void iFilterTheColumnWithTotalActiveConditionAndValue(String headerName, String condition, String value) {

        delayOfElement(4);
        acPElectronics.openFilterMenu(headerName);
        delayOfElement(2);
        acPElectronics.setActivePostFilterCondition(condition, value);
    }

    @And("I want to see pagination is perfectly work so i select page number {int}")
    public void iWantToSeePaginationIsPerfectlyWorkSoISelctPageNumber(int itemsPerPage) {
        delayOfElement(3);
        acPElectronics.selectItemsPerPage(itemsPerPage);
    }
    @When("I navigate to the next page")
    public void iNavigateToTheNextPage() {
        delayOfElement(2);
        acPElectronics.navigateToNextPage();
    }

    @When("I navigate to the previous page")
    public void iNavigateToThePreviousPage() {
        delayOfElement(2);
        acPElectronics.navigateToPreviousPage();
    }

    @When("I navigate to the first page")
    public void iNavigateToTheFirstPage() {
        delayOfElement(2);
        acPElectronics.navigateToFirstPage();
    }
    @When("I navigate to the last page")
    public void iNavigateToTheLastPage() {
        delayOfElement(2);
        acPElectronics.navigateToLastPage();
    }

    @Then("the pagination info should be {string}")
    public void thePaginationInfoShouldBe(String expectedInfo) {
        String actualInfo = acPElectronics.getPaginationInfo();
        Assert.assertEquals("Pagination info does not match", expectedInfo, actualInfo);
    }

    @Given("I click on All active post")
    public void iClickOnAllActivePost() {
        delayOfElement(4);
        acPElectronics.clickOnAllActivePost();
    }

    @And("I download {string} in my computer with pdf file")
    public void iDownloadInMyComputerWithPdfFile(String fileName) {

        delayOfElement(4);
        generalUser.downloadExportPdf();

        String filePath = System.getProperty("user.home") + "/Downloads/" + fileName;

        // Verify if the file exists using assertion
        File file = new File(filePath);
        assertTrue("File download failed or not found.", file.exists());
    }

    @Then("I filter the Email column with Or logical {string} and value {string}")
    public void iFilterTheEmailColumnWithOrLogicalAndValue(String condition, String value) throws InterruptedException {
        generalUser.selectDropdownValue(condition, value);
    }

    @And("I hover on General User")
    public void iHoverOnGeneralUser() {
        delayOfElement(6);
        generalUser.hoverOnGeneralUser();
    }

    @Given("I click on all active general user")
    public void iClickOnAllActiveGeneralUser() {
        delayOfElement(5);
        generalUser.clickOnActiveAllGenUser();
    }


    @Given("I click on all pending general user")
    public void iClickOnAllPendingGeneralUser() {
        delayOfElement(3);
        generalUser.clickOnPendingAllGenUser();
    }

    @When("I click on the Preview link for update {string}")
    public void I_click_on_the_Preview_link_for_update(String email) {
        delayOfElement(3);
        generalUser.clickPreviewLinkForUser(email);
    }

    @Then("I should be navigated to the user's preview page")
    public void i_should_be_navigated_to_the_user_s_preview_page() {
        assertTrue(generalUser.isAt());
    }

    @And("I want to select status {string}")
    public void iWantToSelectStatus(String status) {
        delayOfElement(2);
        generalUser.selectStatus(status);
    }

    @Then("I click on update btn")
    public void iClickOnUpdateBtn() {

     generalUser.clickOnUpdateBtn();
    }

    @And("I hover on Pending Post")
    public void iHoverOnPendingPost() {
        delayOfElement(5);
        pendingPost.hoverOnThePendingPost();
    }

    @Given("I Click on Pending All post")
    public void iClickOnPendingAllPost() {
        delayOfElement(3);
        pendingPost.clickOnPendingAllPost();
    }

    @And("I select subCategory {string}")
    public void iSelectSubCategory(String subCat) {
        pendingPost.selectsubCategory(subCat);
    }

    @Then("I should be navigated to the post preview page")
    public void iShouldBeNavigatedToThePostPreviewPage() {
        delayOfElement(2);
        pendingPost.isPendingPreview();
    }

    @When("I click on the Preview link for update post {string}")
    public void iClickOnThePreviewLinkForUpdatePost(String title) {
        delayOfElement(5);
        pendingPost.clickPreviewLinkForPost(title);
    }

    @And("I click on Edit btn")
    public void iClickOnEditBtn() {
        delayOfElement(2);
        pendingPost.clickOnEditBtn();
    }

    @And("I want to select post status {string}")
    public void iWantToSelectPostStatus(String status) {
        delayOfElement(5);
        pendingPost.selectPostStatus(status);
    }

    @Then("I click on pending post update btn")
    public void iClickOnPendingPostUpdateBtn() {
        delayOfElement(4);
        pendingPost.clickOnUpdateBtnPost();
    }

    @Then("I select or logical of user name filter {string}")
    public void iSelectOrLogicalOfUserNameFilter(String condition) {
        acPElectronics.setLogicalOperatorOfAeList(condition);
    }

    @Then("I select logical condition of date filter {string}")
    public void iSelectLogicalConditionOfDateFilter(String condition) {
        acPElectronics.setSecondLogicalConditionOfDate(condition);
    }

    @And("I click on all rejected general user")
    public void iClickOnAllRejectedGeneralUser() {
        generalUser.clickOnRejectedAllGenUser();
    }


    @And("I write the remark {string}")
    public void iWriteTheRemark(String remark) {
        generalUser.remarkesWrite(remark);
    }

    @And("I click on all Inactive general user")
    public void iClickOnAllInactiveGeneralUser() {
        generalUser.clickOnInactiveAllGenUser();
    }

    @Then("I should be navigated to the user's active preview page")
    public void iShouldBeNavigatedToTheUserSActivePreviewPage() {
        generalUser.isAactive();
    }

}
