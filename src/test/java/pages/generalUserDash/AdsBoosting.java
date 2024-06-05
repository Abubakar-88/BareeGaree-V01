package pages.generalUserDash;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdsBoosting extends Base {

    @FindBy(xpath = "//p[text()='Total Active Ads']")
    WebElement totalActiveAds;


    @FindBy(xpath = "(//div[@class='new_card_bottom']/button[contains(text(), 'Boost Your Ad')])[1]")
    WebElement boostAds;
    @FindBy(xpath = "(//div[@class='new_card_btn']/button[contains(text(), 'Edit')])[1]")
    WebElement boostAdsEdit;
    @FindBy(id = "icon1")
    WebElement addShowUp;
    @FindBy(id = "icon7")
    WebElement addBetween;
    @FindBy(id = "day127")
    WebElement select7Days;
    @FindBy(id = "day16")
    WebElement select5Days;
    @FindBy(id = "totalAmount")
    WebElement totalAmount;
    @FindBy(xpath = "//input[@value='CouponPayment']")
    WebElement paymentBundle;

    @FindBy(id = "promotionAmount")
    WebElement promotionAmount;

    @FindBy(id = "remainingBalance")
    WebElement  remainingBalance;

    @FindBy(xpath = " //button[text()='Make Payment']")
    WebElement makePayment;

    @FindBy(xpath = " //button[text()='Continue']")
    WebElement btnContinue;


    @FindBy(xpath = "//*[@id='carouselExampleCaptions']/div[2]/div/div/h5")
    private WebElement activeCarouselItemTitle;

    @FindBy(xpath = "//*[@id='carouselExampleCaptions']/div[2]/div/div/p")
    private WebElement activeCarouselItemPrice;

    @FindBy(xpath = "//h4[text()='All Jobs']")
    private WebElement allJobsClick;


    public AdsBoosting(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public boolean isActive() {
        return driver.getCurrentUrl().contains("Home/User/ActivePost");
    }
   public void clickOnTotalActiveAds(){
        totalActiveAds.click();
   }

    public void clickOnAllJobs(){
        allJobsClick.click();
    }

    public void clickOnEditAds(){
        boostAdsEdit.click();
    }

    public String getFirstBoostButtonOnclick() {
        return boostAds.getAttribute("onclick");
    }

    // Method to click the first "Boost Your Ad" button using JavaScript
    public void clickFirstBoostButtonWithJS() {
        String onClickValue = getFirstBoostButtonOnclick();
        if (onClickValue != null) {
            ((JavascriptExecutor) driver).executeScript(onClickValue);
        } else {
            throw new IllegalStateException("OnClick attribute is not available for the Boost button");
        }
    }





    public void clickOnShowUp(){
        addShowUp.click();
    }

    public void clickOnBetween(){
        addBetween.click();
    }
    public void clickOn7Days(){
        select7Days.click();
    }
    public void clickOn5Days(){
        select5Days.click();
    }
    public void clickOnbtnContinue(){
        btnContinue.click();
    }
    public void clickOnPaymentBundle(){
        paymentBundle.click();
    }
    public String getPromotionAmountText() {
        return promotionAmount.getText();
    }
    public void clickOnmakePayment(){
        makePayment.click();
    }

    public String getActiveCarouselItemTitle() {
        return activeCarouselItemTitle.getText();
    }

    public String getActiveCarouselItemPrice() {
        return activeCarouselItemPrice.getText();
    }

}
