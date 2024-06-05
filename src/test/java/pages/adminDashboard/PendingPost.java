package pages.adminDashboard;

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.yaml.snakeyaml.events.Event;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class PendingPost extends Base {
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsExecutor;
//    @FindBy(xpath = "//th/a")  // Adjust the locator as per your actual header elements
//    List<WebElement> headers;
//div[@id='dashboard_footer_back_btn']/button[text()=' Edit']
    @FindBy(xpath = "//div[@id='dashboard_footer_back_btn']/button[text()=' Edit']")
    private WebElement editBtn;
    @FindBy(xpath = "//a[text()='Pending Post']")
    private WebElement hoverOnPendingPost;

    @FindBy(xpath = "//a[text()='RePending Post']")
    private WebElement hoverOnRePendingPost;
    @FindBy(xpath = "//a[text()='Export to PDF']")
    private WebElement exportPdf;
    @FindBy(linkText = "RePending Job")
    private WebElement rependingJob;
    @FindBy(linkText = "All Pending Post List")
    private WebElement pendingAllPost;
    @FindBy(xpath = "//input[@data-bind='value: filters[1].value']")
    private WebElement secondFilterInput;



    @FindBy(id = "status")
    WebElement selectPostStatus;
    @FindBy(xpath = "//div[@id='PendingAllList']")
    WebElement PendingPostTable;



    @FindBy(id = "rePendingJobList")
    WebElement rePendingJobTable;
    @FindBy(xpath = "//ul[@class='k-list k-reset']")
    WebElement dropdownList;

    @FindBy(xpath = "//ul[@class='k-list k-reset']/li")
    List<WebElement> dropdownOptions;
    @FindBy(xpath = "//div[@id='dashboard_footer_back_btn']//button[@onclick='updateJobInformation()']")
    WebElement clickUpdatBtnp;

    @FindBy(xpath = "//form[@class='k-filter-menu k-popup k-group k-reset k-state-border-up']/div/span[3]") // Replace with a more specific selector if needed
    private WebElement dropdownContainer;

    @FindBy(id = "subCategory")
    WebElement selectSubCat;

    public PendingPost(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  // Increase timeout to 30 seconds
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        PageFactory.initElements(driver, this);
    }
    public void selectsubCategory(String subCategory) {
        WebElement subCategoryElement = fluentWait(selectSubCat);
        dropDownvalue(subCategoryElement, subCategory);
    }
    public boolean isPendingPreview() {
        return driver.getCurrentUrl().contains("/OurServices/AllList/PreviewJobAd");
    }

    public void clickPreviewLinkForPost(String title) {
        WebElement titleCell = PendingPostTable.findElement(By.xpath("//td[text()='" + title + "']"));
        WebElement row = titleCell.findElement(By.xpath("./ancestor::tr"));
        WebElement previewLink = row.findElement(By.linkText("Preview Ad"));
        previewLink.click();
    }

    public void clickPreviewLinkRependingPost(String title) {
        WebElement titleCell = rePendingJobTable.findElement(By.xpath("//td[text()='" + title + "']"));
        WebElement row = titleCell.findElement(By.xpath("./ancestor::tr"));
        WebElement previewLink = row.findElement(By.linkText("Preview Ad"));
        previewLink.click();
    }

    public void selectPostStatus(String status) {

        dropDownvalue(selectPostStatus,status);
    }


    public void hoverOnTheRePendingPost() {
        mouseHover(hoverOnRePendingPost);
    }
    public void hoverOnThePendingPost() {
        mouseHover(hoverOnPendingPost);
    }
    public void clickOnUpdateBtnPost(){
        clickUpdatBtnp.click();
    }

    public void clickOnEditBtn(){
        editBtn.click();
    }

    public void clickOnPendingAllPost(){
        pendingAllPost.click();
    }

    public void clickOnRePendingJob(){
        rependingJob.click();
    }





}
