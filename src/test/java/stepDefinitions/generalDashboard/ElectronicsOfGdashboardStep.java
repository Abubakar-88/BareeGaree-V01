package stepDefinitions.generalDashboard;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.generalUserDash.ElectronicsCatPageOfGdashboard;

public class ElectronicsOfGdashboardStep extends Base {

    ElectronicsCatPageOfGdashboard eleDashboard = new ElectronicsCatPageOfGdashboard(driver);


    @Then("I Click on the Electronics Category")
    public void iClickOnTheElectronicsCategory() {
        eleDashboard.clickOnElectronics();
    }

    @Given("I click on Mobile")
    public void iClickOnMobile() {

         eleDashboard.clickOnMobile();
    }


    @And("I fill display size\\(inch) {string}")
    public void iFillDisplaySizeInch(String size) {
       eleDashboard.enterDisplaySize(size);
    }


    @And("I fill ram {string}")
    public void iFillRam(String size) {
        eleDashboard.enterRam(size);
    }

    @And("I fill Processor {string}")
    public void iFillProcessor(String processor) {
        eleDashboard.enterProcessor(processor);
    }

    @And("I fill of Model {string}")
    public void iFillOfModel(String model) {
        eleDashboard.enterModel(model);
    }

    @Given("I click on Laptops")
    public void iClickOnLaptops() {
       eleDashboard.clickOnLaptop();
    }

    @And("I fill HDD\\(Hard Drive) {string}")
    public void iFillHDDHardDrive(String size) {
        eleDashboard.enterHDD(size);
    }

    @Given("I click on Computer And Laptop Accessories")
    public void iClickOnComputerAndLaptopAccessories() {
        eleDashboard.clickOnAccessories();
    }

    @And("I select of Item type {string}")
    public void iSelectOfItemType(String item) {
        eleDashboard.selectItem(item);
    }

}