package stepDefinitions.generalDashboard;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.generalUserDash.VehicleCategoryPageOfGdashbord;

public class VehicleOfGdashboardStep extends Base {

     VehicleCategoryPageOfGdashbord vehicleOfGdashbord = new VehicleCategoryPageOfGdashbord(driver);


    @Then("I Click on the Vehicle Category")
    public void iClickOnTheVehicleCategory() {
        vehicleOfGdashbord.clickOnVehicle();
    }

    @Given("I click on Bicycle")
    public void iClickOnBicycle() {
        vehicleOfGdashbord.clickOnBicycle();
    }


    @Then("I select of Condition {string}")
    public void iSelectOfCondition(String condition) {
        vehicleOfGdashbord.selectCondition(condition);
    }

    @And("I select of Brand {string}")
    public void iSelectOfBrand(String brand) {
        vehicleOfGdashbord.selectBrand(brand);
    }

    @Given("I click on Motorbike")
    public void iClickOnMotorbike() {
        vehicleOfGdashbord.clickOnMotorbike();
    }

    @And("I select of Model {string}")
    public void iSelectOfModel(String model) {
        delayOfElement(2);
        vehicleOfGdashbord.selectModel(model);
    }

    @And("I select of Bike type {string}")
    public void iSelectOfBikeType(String type) {
        vehicleOfGdashbord.selectBiketype(type);
    }

    @And("I fill Edition {string}")
    public void iFillEdition(String edition) {
        vehicleOfGdashbord.enterEdition(edition);
    }

    @And("I fill Engine Capacity\\(CC) {string}")
    public void iFillEngineCapacityCC(String capacity) {
        vehicleOfGdashbord.enterEngineCapacity(capacity);
    }

    @And("I fill Mileage\\(KM) {string}")
    public void iFillMileageKM(String mile) {
        vehicleOfGdashbord.enterMileage(mile);
    }

    @And("I fill Manufacture Year {string}")
    public void iFillManufactureYear(String year) {
        vehicleOfGdashbord.enterManufactureYear(year);
    }
// Car StepDef
    @Given("I click on Car")
    public void iClickOnCar() {
        vehicleOfGdashbord.clickOnCar();
    }

    @And("I select Transmission {string}")
    public void iSelectTransmission(String transmission) {
        vehicleOfGdashbord.selectTransmission(transmission);
    }


    @And("I fill Registration Year {string}")
    public void iFillRegistrationYear(String year) {
        vehicleOfGdashbord.enterRegistrationYear(year);
    }

    @And("I select of Body type {string}")
    public void iSelectOfBodyType(String type) {
        vehicleOfGdashbord.selectBodyType(type);
    }

    @And("I select Fuel Type")
    public void iSelectFuelType() {
        vehicleOfGdashbord.clickOnFuelType();
    }

    @Given("I click on Rentals")
    public void iClickOnRentals() {
        vehicleOfGdashbord.clickOnrentals();
    }

    @And("I select of Rentals type {string}")
    public void iSelectOfRentalsType(String type) {
        vehicleOfGdashbord.selectRentalsType(type);
    }
}
