package pages.generalUserDash;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsCatPageOfGdashboard extends Base {
    @FindBy(xpath = "//a[text()='Electronics']")
    private WebElement electronicsClick;

    @FindBy(id = "modelName")
    private WebElement modelName;

    @FindBy(xpath = "//a[text()='Mobile']")
    private WebElement mobileClick;
    @FindBy(xpath = "//a[text()='Computer And Laptop Accessories']")
    private WebElement accessoriesClick;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopClick;
    @FindBy(id = "itemType")
    private WebElement itemType;
    @FindBy(id = "displaySize")
    private WebElement displaySize;
    @FindBy(id = "ram")
    private WebElement ram;
    @FindBy(id = "hDD")
    private WebElement hdd;
    @FindBy(id = "processor")
    private WebElement processor;
    public ElectronicsCatPageOfGdashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method mobile of Electronics
    public void clickOnElectronics(){
        fluentWaitClick(electronicsClick);
    }
    public void clickOnMobile(){
        fluentWaitClick(mobileClick);

    }
    public void clickOnLaptop(){
        fluentWaitClick(laptopClick);

    }
    public void enterModel(String model){
        modelName.sendKeys(model);
    }
    public void enterDisplaySize(String size){
        displaySize.sendKeys(size);
    }
    public void enterRam(String size){
        ram.sendKeys(size);
    }
    public void enterHDD(String size){
        hdd.sendKeys(size);
    }
    public void enterProcessor(String size){
        processor.sendKeys(size);
    }
    public void clickOnAccessories(){
        fluentWaitClick(accessoriesClick);

    }
    public void selectItem(String item){
        WebElement itemElement = fluentWait(itemType);
        dropDownvalue(itemElement, item);
    }


}
