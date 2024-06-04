package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Base {
    @FindBy(xpath = "//h6[text()='Toyota Axio']")
    private WebElement toyotaAxioCarName;

    @FindBy(xpath = "//h6[text()='New readymade flat for sale']")
    private WebElement readymadeFlatNameClick;

    @FindBy(xpath = "//h6[text()='Oppo Reno 6 Used']")
    private WebElement oppoMobileClick;
    @FindBy(xpath = "//h6[text()='Mans Bags']")
    private WebElement mensBagClick;

    @FindBy(xpath = "//h6[text()='Senior Project Accountant']")
    private WebElement projectAccountantClick;

    @FindBy(id = "district_Layout")
    private WebElement districtSelect;
    @FindBy(id = "thana_Layout")
    private WebElement areaSelect;

    @FindBy(className = "fa-angle-right")
    private WebElement submitLocation;

    @FindBy(partialLinkText = "Properties")
    private WebElement propertiesClick;



    @FindBy(partialLinkText = "Vehicles")
    private WebElement vehiclesClick;

    @FindBy(xpath = "//h4[text()='Car']")
    private WebElement carClick;
    @FindBy(partialLinkText = "Electronics")
    private WebElement electronicsClick;

    @FindBy(xpath = "//h4[text()='Mobile']")
    private WebElement mobileClick;

    @FindBy(partialLinkText = "Lifestyle")
    private WebElement lifestyleClick;

    @FindBy(xpath = "//h4[text()='Mens Bags Or Wallets']")
    private WebElement bagsWalletClick;

    @FindBy(partialLinkText = "Jobs")
    private WebElement jobsClick;

    @FindBy(xpath = "//h4[text()='Accountant']")
    private WebElement accountantClick;


    @FindBy(xpath = "//h4[text()='Flat for Sale']")
    private WebElement flatForSaleCardClick;

    @FindBy(xpath = "/html/body/div[12]/div/div/div[@class='modal-body']")
    private WebElement modalDialogProperty;
    @FindBy(xpath = "/html/body/div[13]/div/div/div[@class='modal-body']")
    private WebElement modalDialogVehicle;

    @FindBy(xpath = "/html/body/div[14]/div/div/div[@class='modal-body']")
    private WebElement modalDialogElectronics;

    @FindBy(xpath = "/html/body/div[15]/div/div/div[@class='modal-body']")
    private WebElement modalDialogLifeStyle;

    @FindBy(xpath = "/html/body/div[16]/div/div/div[@class='modal-body']")
    private WebElement modalDialogJobs;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnJobs() {
        fluentWaitClick(jobsClick);
    }

    public void clickOnLifestyle() {
        fluentWaitClick(lifestyleClick);
    }
    public void clickOnBagsWallet(){
        fluentWaitClick(bagsWalletClick);

    }
    public void clickOnMensBag(){
        fluentWaitClick(mensBagClick);

    }
    public boolean isModalDialogOfPropertyDisplayed() {
        return modalDialogProperty.isDisplayed();
    }

    public boolean isModalDialogOfVehicleDisplayed() {
        return modalDialogVehicle.isDisplayed();
    }
    public boolean isModalDialogOfElectronicsDisplayed() {
        return modalDialogElectronics.isDisplayed();
    }
    public boolean isModalDialogOfLifeStyleDisplayed() {
        return modalDialogLifeStyle.isDisplayed();
    }
    public boolean isModalDialogOfJobsDisplayed() {
        return modalDialogJobs.isDisplayed();
    }


    public void clickFlatForSaleCard() {
      fluentWaitClick(flatForSaleCardClick);
    }
    public void clickOnVehicles(){
        fluentWaitClick(vehiclesClick);
    }
    public void clickOnCar(){
        fluentWaitClick(carClick);
    }

    public void clickOnElectronics(){
        fluentWaitClick(electronicsClick);
    }
    public void clickOnMobile(){
        fluentWaitClick(mobileClick);
    }



    public void clickOnProperties(){
        fluentWaitClick(propertiesClick);
    }

      public void clickOnReadymadeFlat(){
        fluentWaitClick(readymadeFlatNameClick);
          //  readymadeFlatNameClick.click();
      }
    public void clickOnOppoMobile(){
        fluentWaitClick(oppoMobileClick);

    }

    public void clickOnAccountant(){
        fluentWaitClick(accountantClick);
    }
    public void clickOnProjectAccountant(){
        fluentWaitClick(projectAccountantClick);

    }

    public void selectDistrict(String district){
        WebElement districtElement = fluentWait(districtSelect);
        dropDownvalue(districtElement, district);
    }

    public void selectArea(String area){
        WebElement districtElement = fluentWait(areaSelect);
        dropDownvalue(districtElement, area);
    }

    public void locationSubmit(){
        submitLocation.click();
    }
    public void clickToyotaAxioCarName() {
        fluentWaitClick(toyotaAxioCarName);
    }
    public boolean isOnSearchResultsPage( String keyword) {
        String expectedUrl = "https://initial.bareegaree.com/Ads/Dhaka/All";
        String searchText = "searchText=" + keyword;

        // Wait for the URL to contain the expected URL
        fluentWaitForUrl(expectedUrl);

        String currentUrl = driver.getCurrentUrl().toLowerCase();

        // Check if the current URL contains the expected URL and search text
        boolean isUrlCorrect = currentUrl.startsWith(expectedUrl.toLowerCase());
        boolean isSearchTextPresent = currentUrl.contains(searchText.toLowerCase());

        // Return true only if both conditions are met
        return isUrlCorrect && isSearchTextPresent;
    }

    public boolean isOnSubCategoryResultsPage( String keyword) {
        String expectedUrl = "https://initial.bareegaree.com/Ads/";
        String subCategoryText = "subCategory=" + keyword;

        // Wait for the URL to contain the expected URL
        fluentWaitForUrl(expectedUrl);

        String currentUrl = driver.getCurrentUrl().toLowerCase();
           currentUrl = currentUrl.replace("%20", " ");
           System.out.println("url: "+currentUrl);
        // Check if the current URL contains the expected URL and search text
        boolean isUrlCorrect = currentUrl.startsWith(expectedUrl.toLowerCase());
        boolean isSearchTextPresent = currentUrl.contains(subCategoryText.toLowerCase());

        // Return true only if both conditions are met
        return isUrlCorrect && isSearchTextPresent;
    }



}
