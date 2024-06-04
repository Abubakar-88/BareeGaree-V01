package pages.executivePartner;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ExecutivePartnerDashboard extends Base {

    @FindBy(xpath = "//a[contains(@href, '/executive-partner/logIn/')]")
    private WebElement executiveParterLogin;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div")
    private WebElement inputContainer;


    @FindBy(id = "description")
    private WebElement description;

    @FindBy(id = "fileInput")
    private WebElement fileInput;
    @FindBy(xpath = "//button[@class='btn post_subhmit']")
    private WebElement postSubmitClick;


    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div[4]/div[2]/div[5]/div/div[3]/button/i")
    private WebElement commentClick;

    @FindBy(id = "socialComment-38")
    private WebElement writeComment;

    @FindBy(className = "download_container")
    private WebElement downloadContainer;

    @FindBy(id = "downloadfile")
    private WebElement downloadPdf;


    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div[4]/div[1]/div[6]/div/div[1]/div[2]/div/div/div")
    private WebElement clickOnCsubmit;

    public ExecutivePartnerDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnExecutivePartnerLogin(){
        fluentWaitClick(executiveParterLogin);

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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commentClick);
         delayOfElement(2);
        commentClick.click();
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

}
