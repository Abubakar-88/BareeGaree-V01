package pages.generalUserDash;

import base.Base;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleCategoryPageOfGdashbord extends Base {

    @FindBy(xpath = "//a[text()='Vehicles']")
    private WebElement vehicleClick;

    @FindBy(xpath = "//a[text()='Bicycle']")
    private WebElement bicycleClick;

    @FindBy(id = "condition")
    private WebElement conditionSelect;
    @FindBy(id = "brand")
    private WebElement brandSelect;

    //Motorbike
    @FindBy(xpath = "//a[text()='Motorbike']")
    private WebElement motorbikeClick;

    @FindBy(id = "model")
    private WebElement modelSelect;

    @FindBy(id = "bikeType")
    private WebElement bikeTypeSelect;

    @FindBy(id = "edition")
    private WebElement editionFill;
    @FindBy(id = "engineCapacity")
    private WebElement engineCapacityFill;

    @FindBy(id = "manufectureYear")
    private WebElement manufectureYearFill;

    @FindBy(id = "mileage")
    private WebElement mileageFill;

    // Car
    @FindBy(xpath = "//a[text()='Car']")
    private WebElement carClick;
    @FindBy(id = "transmission")
    private WebElement transmissionSelect;

    @FindBy(id = "registrationYear")
    private WebElement registrationYear;

    @FindBy(id = "bodyType")
    private WebElement bodyType;

    @FindBy(id = "432")
    private WebElement fuelType;

    @FindBy(xpath = "//a[text()='Rentals']")
    private WebElement rentalsClick;


    @FindBy(id = "rentalsTypeId")
    private WebElement rentalsTypeId;

    public VehicleCategoryPageOfGdashbord(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Method bicycle of Vehicle
    public void clickOnVehicle(){
        fluentWaitClick(vehicleClick);
    }
    public void clickOnBicycle(){
        fluentWaitClick(bicycleClick);
    }

    public void selectCondition(String condition){
        WebElement conditionElement = fluentWait(conditionSelect);
        dropDownvalue(conditionElement, condition);
    }
    public void selectBrand(String brand){
        WebElement brandElement = fluentWait(brandSelect);
        dropDownvalue(brandElement, brand);
    }

    //Method motorbike of Vehicle
    public void clickOnMotorbike(){
        fluentWaitClick(motorbikeClick);
    }

    public void selectModel(String model){
        WebElement modelElement = fluentWait(modelSelect);
        dropDownvalue(modelElement, model);
    }
    public void selectBiketype(String type){
        WebElement typeElement = fluentWait(bikeTypeSelect);
        dropDownvalue(typeElement, type);
    }

    public void enterEdition(String edition){
        editionFill.sendKeys(edition);
    }
    public void enterEngineCapacity(String capacity){
        engineCapacityFill.sendKeys(capacity);
    }
    public void enterManufactureYear(String year){
        manufectureYearFill.sendKeys(year);
    }
    public void enterMileage(String mile){
        mileageFill.sendKeys(mile);
    }

    //Method Car of vehicle category
    public void clickOnCar(){
        fluentWaitClick(carClick);
    }
    public void selectTransmission(String transmission){
        WebElement transmissionElement = fluentWait(transmissionSelect);
        dropDownvalue(transmissionElement, transmission);
    }

    public void enterRegistrationYear(String year){
        registrationYear.sendKeys(year);
    }

    public void selectBodyType(String type){
        WebElement bodyTypeElement = fluentWait(bodyType);
        dropDownvalue(bodyTypeElement, type);
    }
    public void clickOnFuelType(){
        fluentWaitClick(fuelType);
    }
    public void clickOnrentals(){
        fluentWaitClick(rentalsClick);
    }

    public void selectRentalsType(String type){
        WebElement rentalsTypeElement = fluentWait(rentalsTypeId);
        dropDownvalue(rentalsTypeElement, type);
    }



}
