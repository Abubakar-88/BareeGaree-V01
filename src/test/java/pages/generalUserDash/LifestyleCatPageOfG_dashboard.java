package pages.generalUserDash;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LifestyleCatPageOfG_dashboard extends Base {

    @FindBy(xpath = "//a[text()='Lifestyles']")
    private WebElement lifestylesClick;

    @FindBy(xpath = "//a[text()='Health And Beauty']")
    private WebElement healthClick;
    @FindBy(xpath = "//a[contains(@href, '/Home/User/UserDashboard')]")
    private WebElement dashboardMenuClick;


    @FindBy(id = "pendingPostCount")
    private WebElement pendingPostCount;

    @FindBy(xpath = "//*[@id='active_post']/div/div[2]/div/div[1]/div[2]/button")
    private WebElement previewAdd;


    @FindBy(id = "condition")
    private WebElement condition;

    @FindBy(id = "itemType")
    private WebElement itemType;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(id = "district")
    private WebElement district;

    @FindBy(id = "thana")
    private WebElement area;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "status")
    private WebElement status;




    public LifestyleCatPageOfG_dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnDashboardMenu(){
        fluentWaitClick(dashboardMenuClick);

    }

    public void clickOnPendingPostCount(){
        fluentWaitClick(pendingPostCount);

    }
    public void clickOnPreviewAdd(){
        fluentWaitClick(previewAdd);

    }

    public void clickOnLifestyle(){
        fluentWaitClick(lifestylesClick);

    }
    public void clickOnHelth(){
        fluentWaitClick(healthClick);

    }
    public String getCondition() {
        return condition.getText();
    }

    public String getItemType() {
        return itemType.getText();
    }

    public String getTitle() {
        return title.getText();
    }



    public String getDescription() {
        return description.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getDistrict() {
        return district.getText();
    }

    public String getArea() {
        return area.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getStatus() {
        return status.getText();
    }
}
