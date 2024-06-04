package pages.generalUserDash;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class JobsCatPageOfG_dashboard extends Base {

    @FindBy(xpath = "//a[text()='Jobs']")
    private WebElement jobsClick;

    @FindBy(xpath = "//a[text()='Accountant']")
    private WebElement accountantClick;

    @FindBy(id = "jobTypeId")
    private WebElement jobTypeId;
    @FindBy(id = "descriptionOrRequirement")
    private WebElement descriptionOrRequirement;

    @FindBy(id = "contactPhoneNo1")
    private WebElement contactPhoneNo;

    @FindBy(id = "contactEmail")
    private WebElement contactEmail;

    @FindBy(id = "salaryFrom")
    private WebElement salaryFrom;

    @FindBy(id = "salaryTo")
    private WebElement salaryTo;


    @FindBy(id = "employerOrCompanyName")
    private WebElement employerOrCompanyName;
    @FindBy(id = "companyLogo")
    private WebElement companyLogo;

    @FindBy(id = "applicationDeadline")
    private WebElement applicationDeadline;

    @FindBy(xpath = "//span[@class='k-icon k-i-calendar']")
    private WebElement calendarIcon;

    @FindBy(className = "k-animation-container")
    private WebElement calendarContainer;

    public JobsCatPageOfG_dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void openDatePicker() {
        fluentWaitClick(calendarIcon);
    }
    public void selectDate(String date) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calendarContainer);
        openDatePicker();
        By dateLocator = By.xpath("//td[@role='gridcell']//a[text()='" + date + "']");
        selectDate(calendarContainer, dateLocator, date);
    }
    public void clickOnJobs(){
        fluentWaitClick(jobsClick);
    }

    public void clickOnAccountant(){
        fluentWaitClick(accountantClick);

    }

    public void selectJobType(String keyword){
        WebElement jobTypeElement = fluentWait(jobTypeId);
        dropDownvalue(jobTypeElement, keyword);

    }
    public void enterDescriptionOrRequirement(String description){
        descriptionOrRequirement.sendKeys(description);
    }

    public void enterContactPhoneNo(String phone){
        contactPhoneNo.clear();
        contactPhoneNo.sendKeys(phone);
    }
    public void enterContactEmail(String email){
        contactEmail.clear();
        contactEmail.sendKeys(email);
    }

    public void enterSalaryFrom(String salaryF){
        salaryFrom.sendKeys(salaryF);
    }

    public void enterSalaryTo(String salaryT){
        salaryTo.sendKeys(salaryT);
    }

    public void enterEmployerOrCompanyName(String cName){
        employerOrCompanyName.sendKeys(cName);
    }
    public void companyLogo(String imagePath) {
        File file = new File(imagePath);
        if(file.exists()){
            companyLogo.sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + imagePath);
        }

    }





}
