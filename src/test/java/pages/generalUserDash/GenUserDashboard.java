package pages.generalUserDash;

import base.Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class GenUserDashboard extends Base {

    @FindBy(xpath = "//div[@id='navbarSupportedContent']/ul/li[4]/a")
    private WebElement loginMenuClick;

    @FindBy(xpath = "//a[contains(@href, '/general-user/logIn/')]")
    private WebElement generalUserLogin;


    @FindBy(id = "emailId")
    private WebElement emailId;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//form[@id='loginForm']/div[5]/button")
    private WebElement btnLogin;

    @FindBy(className = "partner_username")
    private WebElement usernameElement;

   @FindBy(xpath = "//*[@id='navbarSupportedContent']/ul/div[2]/li/button")
   private WebElement postAddClick;

    //*[@id="post_ad_body"]/form/div/div/button
    @FindBy(xpath = "//button[@class='btn ']/p")
    private WebElement postAddBody;

    @FindBy(xpath = "//a[text()='Properties']")
    private WebElement propertiesClick;

    @FindBy(xpath = "//a[text()='Bedroom Furniture']")
    private WebElement bedroomFurnitureClick;
    @FindBy(xpath = "//a[text()='Flat For Rent']")
    private WebElement flatForRent;
    @FindBy(id = "title")
    private WebElement titleOfFurniture;

    @FindBy(id = "address")
    private WebElement addressOfFurniture;
    @FindBy(id = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "price")
    private WebElement priceFill;
    @FindBy(id = "description")
    private WebElement descriptionFill;

    @FindBy(id = "isNegotiable")
    private WebElement isNegotiableClick;

    @FindBy(id = "fileInput")
    private WebElement fileInputElement;

    @FindBy(xpath = "//button[text()=' Submit']")
    private WebElement addPostSubmit;
    @FindBy(id = "district")
    private WebElement districtSelect;
    @FindBy(id = "thana")
    private WebElement areaSelect;

// flat for rent
    @FindBy(id = "noOfBedroom")
    private WebElement noOfBedroom;


    @FindBy(id = "noOfBathroom")
    private WebElement noOfBathroom;
    @FindBy(id = "size")
    private WebElement sizeSqft;
    @FindBy(id = "carParkingId")
    private WebElement carParkingId;
    @FindBy(id = "apartmentFeature")
    private WebElement apartmentFeature;

    @FindBy(id = "completionStatus")
    private WebElement completionStatus;

    @FindBy(id = "facingDirection")
    private WebElement facingDirection;

    @FindBy(id = "rentPerMonth")
    private WebElement rentPerMonth;

    // @land for sale
    @FindBy(xpath = "//a[text()='Land For Sale']")
    private WebElement landForSale;
    @FindBy(id = "458")
    private WebElement landType;

    @FindBy(id = "propertySizeUnitId")
    private WebElement propertySizeUnitId;
    @FindBy(id = "landSize")
    private WebElement landSize;
    @FindBy(id = "priceUnitTypeId")
    private WebElement priceUnitTypeId;

    //Property For Rent
    @FindBy(xpath = "//a[text()='Property For Rent']")
    private WebElement propertyForRent;

    @FindBy(id = "propertyType")
    private WebElement propertyType;
    @FindBy(id = "rentPerYear")
    private WebElement rentPerYear;


    public GenUserDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void uploadImage(String imagePath) {
        System.out.println("Uploading image: " + imagePath);
        File file = new File(imagePath);
        if(file.exists()){
            fileInputElement.sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + imagePath);
        }

    }
    public void enterTitleOfProduct(String title){
        titleOfFurniture.clear();
        titleOfFurniture.sendKeys(title);
    }
    public void enterAddress(String address){
        addressOfFurniture.clear();
        addressOfFurniture.sendKeys(address);
    }
    public void enterPhoneNumber(String phone){
        phoneNumber.sendKeys(phone);
    }
    public void enterDescription(String description){
       descriptionFill.sendKeys(description);
    }

    public void enterPrice(String price){
        priceFill.sendKeys(price);
    }
    public void selectDistrict(String district){
        WebElement districtElement = fluentWait(districtSelect);
        dropDownvalue(districtElement, district);
    }

    public void selectArea(String area){
        WebElement districtElement = fluentWait(areaSelect);
        dropDownvalue(districtElement, area);
    }

    public void clickOnBedroomFurniture(){
        fluentWaitClick(bedroomFurnitureClick);
    }
    public void clickOnFlatForRent(){
        fluentWaitClick(flatForRent);
    }

    public void clickOnIsNogotiable(){
        fluentWaitClick(isNegotiableClick);
    }
    public void clickOnProperties(){
        fluentWaitClick(propertiesClick);
    }

    public void clickOnAddPostSubmitBtn(){
        fluentWaitClick(addPostSubmit);
    }
    public void clickOnPostAddBody(){
        fluentWaitClick(postAddBody);
    }
    public void clickOnPostAdd(){
        fluentWaitClick(postAddClick);
    }

    public String getUsernameText() {
        return usernameElement.getText();
    }

    public void clickLoginMenu(){
        fluentWaitClick(loginMenuClick);


    }
    public void clickGeneralUser(){
        fluentWaitClick(generalUserLogin);
    }

    public void enterEmailId( String email){
        emailId.sendKeys(email);

    }

    public void enterPassword( String pass){
        password.sendKeys(pass);
    }

    public void clickLoginSubmit(){
      //  fluentWaitClick(btnLogin);
        btnLogin.click();
    }

// METHOD FLAT FOR RENT
public void fillNoOfBedroom(String number){
    noOfBedroom.sendKeys(number);
}
    public void fillNoOfBathroom(String number){
        noOfBathroom.sendKeys(number);
    }

    public void fillSizeSqft(String number){
        sizeSqft.sendKeys(number);
    }

    public void selectCarParkingId(String keyword){
        WebElement districtElement = fluentWait(carParkingId);
        dropDownvalue(districtElement, keyword);

    }

    public void selectApartmentFeature(String keyword){
        WebElement districtElement = fluentWait(apartmentFeature);
        dropDownvalue(districtElement, keyword);

    }
    public void selectCompletionStatus(String keyword){
        WebElement districtElement = fluentWait(completionStatus);
        dropDownvalue(districtElement, keyword);
    }
    public void selectFacingDirection(String keyword){
        WebElement districtElement = fluentWait(facingDirection);
        dropDownvalue(districtElement, keyword);
    }

    public void fillRentPerMonth(String number){
        rentPerMonth.sendKeys(number);
    }

    // Method of land for sale subcategory

    public void clickLandForSale(){
        fluentWaitClick(landForSale);
    }
    public void clickLandType(){
        fluentWaitClick(landType);
    }

    public void fillLandSize(String size){
        landSize.sendKeys(size);
    }
    public void selectPropertySizeUnit(String size){
        WebElement propertySize = fluentWait(propertySizeUnitId);
        dropDownvalue(propertySize, size);
    }

    public void selectPriceUnit(String unit){
        WebElement priceUnit = fluentWait(priceUnitTypeId);
        dropDownvalue(priceUnit, unit);
    }
// Mehtod of Property for Rent
    public void selectPropertyType(String unit){
        WebElement priceUnit = fluentWait(propertyType);
        dropDownvalue(priceUnit, unit);
    }
    public void clickPropertyForRent(){
        fluentWaitClick(propertyForRent);
    }

    public void fillRentPerYear(String size){
        rentPerYear.sendKeys(size);
    }




}
