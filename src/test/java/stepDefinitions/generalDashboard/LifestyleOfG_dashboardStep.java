package stepDefinitions.generalDashboard;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.generalUserDash.LifestyleCatPageOfG_dashboard;

import java.util.List;
import java.util.Map;

public class LifestyleOfG_dashboardStep extends Base {

    LifestyleCatPageOfG_dashboard lgDashboard = new LifestyleCatPageOfG_dashboard(driver);

    @Then("I Click on the Lifestyle Category")
    public void iClickOnTheLifestyleCategory() {
        lgDashboard.clickOnLifestyle();
    }

    @Given("I click on Health And Beauty")
    public void iClickOnHealthAndBeauty() {
        lgDashboard.clickOnHelth();
    }

    @Then("I click on the dashboard menu")
    public void iClickOnTheDashboardMenu() {

    }

    @And("I click on the Total pending ads")
    public void iClickOnTheTotalPendingAds() {
    lgDashboard.clickOnPendingPostCount();
    }

    @And("I click on the preview button")
    public void iClickOnThePreviewButton() {
  lgDashboard.clickOnPreviewAdd();
    }

    @And("I should see the following information in preview table with skin and Body care")
    public void iShouldSeeTheFollowingInformationInPreviewTableWithSkinAndBodyCare(DataTable dataTable) {
        List<Map<String, String>> tableData = dataTable.asMaps(String.class, String.class);

        // Verify each field in the preview table
        for (Map<String, String> row : tableData) {
            Assert.assertEquals(lgDashboard.getCondition(), row.get("Condition"));
            Assert.assertEquals(lgDashboard.getItemType(), row.get("Item Type"));
            Assert.assertEquals(lgDashboard.getTitle(), row.get("title"));
            Assert.assertEquals(lgDashboard.getDescription(), row.get("Description"));
            Assert.assertEquals(lgDashboard.getAddress(), row.get("Address"));
            Assert.assertEquals(lgDashboard.getPrice(), row.get("Price"));
            Assert.assertEquals(lgDashboard.getDistrict(), row.get("district"));
            Assert.assertEquals(lgDashboard.getArea(), row.get("area"));
            Assert.assertEquals(lgDashboard.getPhoneNumber(), row.get("Phone number"));
            Assert.assertEquals(lgDashboard.getStatus(), row.get("status"));
        }
    }
}