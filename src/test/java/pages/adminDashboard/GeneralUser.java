package pages.adminDashboard;

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GeneralUser extends Base {
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsExecutor;
//    @FindBy(xpath = "//th/a")
//    List<WebElement> headers;


    @FindBy(xpath = "//a[text()='General user']")
    private WebElement hoverOnGenUser;
    @FindBy(xpath = "//a[text()='Export to PDF']")
    private WebElement exportPdf;

    @FindBy(linkText = "All Active General User")
    private WebElement activeGenUser;

    @FindBy(linkText = "All Rejected General User")
    private WebElement rejectedGenUser;

    @FindBy(linkText = "All Inactive General User")
    private WebElement inactiveGenUser;
    @FindBy(id = "remarks")
    private WebElement remarksWrite;

    @FindBy(linkText = "All Pending General User")
    private WebElement pendingGenUser;
    @FindBy(xpath = "//input[@data-bind='value: filters[1].value']")
    private WebElement secondFilterInput;

    @FindBy(id = "userStatus")
    WebElement selectStatus;
    @FindBy(id = "status")
    WebElement postStatus;
    @FindBy(xpath = "//div[@id='UserList']")
    WebElement userTable;
    @FindBy(xpath = "//ul[@class='k-list k-reset']")
    WebElement dropdownList;

    @FindBy(xpath = "//ul[@class='k-list k-reset']/li")
    List<WebElement> dropdownOptions;

    @FindBy(xpath = "//button[contains(text(),'Update')]")
    WebElement clickUpdatBtn;
    @FindBy(xpath = "//form[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']/div/span[3]")
    private WebElement dropdownContainer;
    public GeneralUser(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        PageFactory.initElements(driver, this);
    }
    public boolean isAt() {
        return driver.getCurrentUrl().contains("/Admin/AdminUser/PreviewPendingUser");
    }

    public boolean isAactive() {
        return driver.getCurrentUrl().contains("/Admin/AdminUser/PreviewActiveGeneralUser");
    }
    public void clickPreviewLinkForUser(String email) {
        WebElement emailCell = userTable.findElement(By.xpath("//td[text()='" + email + "']"));
        WebElement row = emailCell.findElement(By.xpath("./ancestor::tr"));
        WebElement previewLink = row.findElement(By.linkText("Preview"));
        previewLink.click();
    }

    Logger logger = Logger.getLogger(GeneralUser.class.getName());

    public void selectStatus(String status) {
        WebElement statusElement = fluentWait(selectStatus);
        dropDownvalue(statusElement, status);
    }
    public void selectPostStatus(String status) {
        WebElement statusElement = fluentWait(postStatus);
        dropDownvalue(statusElement, status);
    }
    public void remarkesWrite(String remark){
        remarksWrite.sendKeys(remark);
    }

    public void selectDropdownValue(String condition, String value) throws InterruptedException {
        // Open the dropdown (assuming it's the first filter)
        delayOfElement(3);

      //  dropdownContainer.click();
        selectOptionByText(dropdownContainer, condition);

        // Enter value in the second filter input (if applicable)
        if (secondFilterInput != null) {
            secondFilterInput.clear();
            delayOfElement(2);
            secondFilterInput.sendKeys(value);
        }

    }
    private void selectOptionByText(WebElement dropdown, String value) throws InterruptedException {
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", dropdown);
        delayOfElement(2);
        dropdown.click();
        WebElement dropdownList = driver.findElement(By.xpath("//form[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']/div[4]/div/ul"));

        // Locate all options within the dropdown list
        List<WebElement> options = dropdownList.findElements(By.cssSelector(".k-item"));
        boolean optionFound = false;
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                Thread.sleep(3000); // Delay before clicking, if necessary
                option.click();
                optionFound = true;
                break;
            }
        }
        if (!optionFound) {
            throw new NoSuchElementException("Dropdown option with text"  + value + " not found");
        }
       // throw new NoSuchElementException("Dropdown option with text '" + value + "' not found");
    }

    public void hoverOnGeneralUser() {
        mouseHover(hoverOnGenUser);
    }
    public void clickOnUpdateBtn(){
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickUpdatBtn);
//        clickUpdatBtn.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickUpdatBtn);
        //scrollAndClick(clickUpdatBtn);
        delayOfElement(10);
        clickUpdatBtn.click();
    }

    public void clickOnActiveAllGenUser(){
        activeGenUser.click();
    }
    public void clickOnRejectedAllGenUser(){
        rejectedGenUser.click();
    }
    public void clickOnInactiveAllGenUser(){
        inactiveGenUser.click();
    }
    public void clickOnPendingAllGenUser(){
        pendingGenUser.click();
    }

    public void downloadExportPdf() {
        fluentWaitClick(exportPdf);

    }




}
