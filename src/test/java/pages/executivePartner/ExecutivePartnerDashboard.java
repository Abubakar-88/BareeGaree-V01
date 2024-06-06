package pages.executivePartner;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class ExecutivePartnerDashboard extends Base {

    @FindBy(xpath = "//a[contains(@href, '/executive-partner/logIn/')]")
    private WebElement executiveParterLogin;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div")
    private WebElement inputContainer;

    @FindBy(id = "day109")
    private WebElement clickon5Day;
    @FindBy(id = "day111")
    private WebElement clickon7Day;

    @FindBy(id = "description")
    private WebElement description;
    @FindBy(css = "//*[@id='locationModal']/div/div/div[1]/i")
    WebElement closeModalTrigger;

    @FindBy(id = "icon3")
    private WebElement topPostIcon;
    @FindBy(id = "fileInput")
    private WebElement fileInput;
    @FindBy(xpath = "//button[@class='btn post_subhmit']")
    private WebElement postSubmitClick;


    @FindBy(xpath = "(//div[@class='view_div_social_icon' and contains(@onclick, 'CommentShow')]/button)[1]")
    private WebElement commentClick;

    @FindBy(id = "socialComment-39")
    private WebElement writeComment;

    @FindBy(className = "download_container")
    private WebElement downloadContainer;


    @FindBy(id = "StudentPartnerList")
    private WebElement partnerList;
    @FindBy(className = "post_top_post")
    WebElement topPostsContainer;

    @FindBy(xpath = "//div[@class='post_top_post']//div[@class='post_item_title']/h6")
    List<WebElement> postTitles;
    @FindBy(id = "downloadfile")
    private WebElement downloadPdf;
    @FindBy(xpath = "//div[@class='user_info']/p")
    List<WebElement> userInfoElements;

    @FindBy(xpath = "//div[@class='new_partner_profile_tk']/div/p[contains(text(), 'Active User')]")
    private WebElement ativeUser;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div[4]/div[1]/div[6]/div/div[1]/div[2]/div/div/div")
    private WebElement clickOnCsubmit;

    @FindBy(xpath = "//h6[text()='Rentals']")
    private WebElement appleiPhone15;

    @FindBy(id = "post_details_boost")
    private WebElement postDetailsBoost;

    @FindBy(partialLinkText = "All Ads")
    private WebElement clickAllAds;
    @FindBy(id = "day83")
    private WebElement day83Click;



    public ExecutivePartnerDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnExecutivePartnerLogin(){
        fluentWaitClick(executiveParterLogin);

    }
    public void closeModal() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(100, 100).click();");
    }
    public void clickOnTopPostIcon(){
        topPostIcon.click();
    }
public void clickOnActiveUser(){
        ativeUser.click();
}

    public void select7Day(){
        clickon7Day.click();

    }
    public void select5Day(){
        clickon5Day.click();

    }
    public void clickPreviewLinkForAd(String email) {
        WebElement emailCell = partnerList.findElement(By.xpath("//td[text()='" + email + "']"));
        WebElement row = emailCell.findElement(By.xpath("./ancestor::tr"));
        WebElement viewAdLink = row.findElement(By.linkText("ViewAd"));
        viewAdLink.click();
    }

    public String getName() {
        return userInfoElements.get(0).getText();
    }

    public String getUserName() {
        return userInfoElements.get(1).getText();
    }

    public String getEmail() {
        return userInfoElements.get(2).getText();
    }

    public String getPhoneNumber() {
        return userInfoElements.get(3).getText();
    }

    public String getWhatsappNumber() {
        return userInfoElements.get(4).getText();
    }

    public String getReferenceCode() {
        return userInfoElements.get(5).getText();
    }

    public String getDistrict() {
        return userInfoElements.get(6).getText();
    }

    public String getArea() {
        return userInfoElements.get(7).getText();
    }

//    public void clickOnImageButton(){
//        fluentWaitClick(addImageButton);
//
//    }
//
//    public void uploadImage(String imagePath) {
//        addImageButton.sendKeys(imagePath);
//    }
    public String getInputContainerText() {
        return inputContainer.getText();
    }

    public void clickOnInputContainer(){
        fluentWaitClick(inputContainer);

    }

    public void clickOnCommentSubmit(){
        clickOnCsubmit.click();

    }
    public boolean isAactiveUserPostList() {
        return driver.getCurrentUrl().contains("/ExecutivePartner/Home/ActiveUserPostList");
    }
    public boolean isNavigatedAllPost() {
        return driver.getCurrentUrl().contains("/Ads/Bangladesh/All");
    }

    public boolean isNavigatedBoostPage() {
        return driver.getCurrentUrl().contains("Home/Home/Promotion");
    }

    public void addImage(String imagePath){
        System.out.println("Uploading image: " + imagePath);
        File file = new File(imagePath);
        if(file.exists()){
            fileInput.sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + imagePath);
        }

    }

    public void clickOnPostSubmitClick(){
        fluentWaitClick(postSubmitClick);

    }

    public void clickOnCommentIcon(){
      //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commentClick);
        fluentWaitClick(commentClick);

    }
    public void enterCommentArticle( String comment){
        writeComment.sendKeys(comment);

    }
    public void enterPostArticle( String article){
        description.sendKeys(article);

    }
    public void clickOndownloadCbtn(){
        fluentWaitClick(downloadContainer);
    }
    public void clickOndownloadLink(){
        fluentWaitClick(downloadPdf);
    }



    public boolean isProductTopListed(String productName) {
        for (WebElement title : postTitles) {
            if (title.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void clickOnAppleiPhone15(){
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rentalCar);
        closeModal();
        fluentWaitClick(appleiPhone15);
//        scrollToElement(appleiPhone15);
//        delayOfElement(2);
//           closeModal();
//        delayOfElement(3);
//        scrollToElement(appleiPhone15);
//        delayOfElement(2);
//        appleiPhone15.click();
    }

    public void clickOnPostDetailsBoost(){

        postDetailsBoost.click();
    }

    public void select5daysAmount(){
        day83Click.click();
    }
    public void clickOnAllAds(){
        clickAllAds.click();
    }

}
