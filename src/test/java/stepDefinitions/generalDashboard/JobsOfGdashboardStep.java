package stepDefinitions.generalDashboard;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.generalUserDash.JobsCatPageOfG_dashboard;

import java.io.File;
import java.util.List;

public class JobsOfGdashboardStep extends Base {

    JobsCatPageOfG_dashboard jobGdashboard = new JobsCatPageOfG_dashboard(driver);

    @Then("I Click on the Jobs Category")
    public void iClickOnTheJobsCategory() {
        jobGdashboard.clickOnJobs();
    }



    @Given("I click on Accountant")
    public void iClickOnAccountant() {
        jobGdashboard.clickOnAccountant();
    }


    @Then("I select of Job type {string}")
    public void iSelectOfJobType(String type) {
        jobGdashboard.selectJobType(type);
    }

    @And("I fill contact email {string}")
    public void iFillContactEmail(String email) {
        jobGdashboard.enterContactEmail(email);
    }

    @And("I fill salary from {string}")
    public void iFillSalaryFrom(String salaryF) {
        jobGdashboard.enterSalaryFrom(salaryF);
    }

    @And("I fill salary to {string}")
    public void iFillSalaryTo(String salaryT) {
        jobGdashboard.enterSalaryTo(salaryT);
    }

    @And("I fill company name {string}")
    public void iFillCompanyName(String name) {
        jobGdashboard.enterEmployerOrCompanyName(name);
    }

    @And("I choose company logo")
    public void iChooseCompanyLogo(DataTable dataTable) {
        delayOfElement(2);
        List<String> imagePaths = dataTable.asList(String.class);
        for (String imagePath : imagePaths) {
            System.out.println("Attempting to upload: " + imagePath);
            File file = new File(imagePath);
            if (file.exists()) {
                jobGdashboard.companyLogo(imagePath);
            } else {
                System.out.println("File not found: " + imagePath);
            }
        }
    }

    @And("I pick application deadline {string}")
    public void iPickApplicationDeadline(String date) {
        delayOfElement(5);
        jobGdashboard.selectDate(date);
    }

    @And("I fill contact phone number {string}")
    public void iFillContactPhoneNumber(String phone) {
        jobGdashboard.enterContactPhoneNo(phone);
    }

    @And("I fill Description Requirement {string}")
    public void iFillDescriptionRequirement(String description) {
        delayOfElement(2);
        jobGdashboard.enterDescriptionOrRequirement(description);
    }
}
