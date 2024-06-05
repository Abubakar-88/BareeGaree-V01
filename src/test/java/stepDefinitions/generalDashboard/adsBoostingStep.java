package stepDefinitions.generalDashboard;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.generalUserDash.AdsBoosting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class adsBoostingStep extends Base {
    AdsBoosting adsBoosting = new AdsBoosting(driver);


    @Given("I click on the total active Ads")
    public void iClickOnTheTotalActiveAds() {
        adsBoosting.clickOnTotalActiveAds();
    }

    @When("I should be navigated to the active post page")
    public void iShouldBeNavigatedToTheActivePostPage() {
        adsBoosting.isActive();
    }

    @Then("I click on Boost your Ad")
    public void iClickOnBoostYourAd() {
        delayOfElement(3);
        // Execute the JavaScript function directly
        adsBoosting.clickFirstBoostButtonWithJS();
    }

    @And("I select Show Up statement")
    public void iSelectShowUpStatement() {
        adsBoosting.clickOnShowUp();
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Show Up", hList)) {
        }
        delayOfElement(4);
        adsBoosting.clickOn7Days();
        delayOfElement(2);
        adsBoosting.clickOnbtnContinue();
    }

    @And("I select Between promotion")
    public void iSelectBetweenPromotion() {
        delayOfElement(2);
        adsBoosting.clickOnBetween();
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Between", hList)) {
        }
        delayOfElement(4);

        adsBoosting.clickOn5Days();
        delayOfElement(2);
        adsBoosting.clickOnbtnContinue();
    }


    @And("I select Payment By Bundle")
    public void iSelectPaymentByBundle() {
        delayOfElement(3);
        adsBoosting.clickOnPaymentBundle();

    }


    @Then("I click on Make payement btn")
    public void iClickOnMakePayementBtn() {
        delayOfElement(2);
        adsBoosting.clickOnmakePayment();
    }

    @And("I should see promotion amount {string} is added correctly")
    public void iShouldSeePromotionAmountIsAddedCorrectly(String amount) {
        delayOfElement(4);
        String usernameText = adsBoosting.getPromotionAmountText();

        // Perform assertion
        Assert.assertEquals("Username text doesn't match",usernameText, amount  );
    }

    @Then("I click on all jobs")
    public void iClickOnAllJobs() {
        delayOfElement(3);
        adsBoosting.clickOnAllJobs();
    }

    @Then("the ad title should be {string}")
    public void theAdTitleShouldBe(String expectedTitle) {
        delayOfElement(2);
        String actualTitle = adsBoosting.getActiveCarouselItemTitle();
        Assert.assertEquals("dose not match!", actualTitle, expectedTitle);
    }

    @Then("the ad price should be {string}")
    public void theAdPriceShouldBe(String expectedPrice) {
        delayOfElement(2);
        String actualPrice = adsBoosting.getActiveCarouselItemPrice();
        Assert.assertEquals("dose not match!",actualPrice, expectedPrice );
    }


    @Then("I click on the edit")
    public void iClickOnTheEdit() {
        adsBoosting.clickOnEditAds();
    }
}
