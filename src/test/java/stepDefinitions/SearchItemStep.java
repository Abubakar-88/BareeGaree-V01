package stepDefinitions;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchItemStep extends Base {

    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

    private static final Logger logger = LogManager.getLogger(SearchItemStep.class);

    public static boolean switchtoRightWindow(String windowTitle, List<String> hList) {
        for(String e : hList) {
            String title = driver.switchTo().window(e).getTitle();
            if(title.contains(windowTitle)) {
                System.out.println("found the right window");
                return true;
            }
        }
        return false;
    }



    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        homePage.navigateUrl(host);
    }

    @When("Satisfy that homepage is visible")
    public void verify_that_homepage_is_visible() {
        String expectedTitle = "Partners - Connecting Buyers and Sellers";
        String actualTitle = homePage.getPageTitle();
        assertEquals("Homepage title doesn't match", expectedTitle, actualTitle);
    }

    @Then("I search for {string} in Search bar")
    public void i_add_products_to_the_cart(String keyword)  {
        homePage.enterSearchKeyword(keyword);
    }

    @And("I click the search button")
    public void i_click_the_Cart_button() {

        homePage.clickSearchButton();

    }

    @Then("I should see search results for {string} in the search page")
    public void iShouldSeeSearchResultsRelatedTo( String keyword) {
        assertTrue(productPage.isOnSearchResultsPage(keyword));
    }


    @When("I click on Toyota Axio car name")
    public void iClickOnToyotaAxioCarName() {
        productPage.clickToyotaAxioCarName();
    }

    @Then("I should see the following information in the details of this product")
    public void iShouldSeeTheFollowingInformationInTheCarDetails(DataTable dataTable) {
        List<Map<String, String>> expectedCarDetailsList = dataTable.asMaps(String.class, String.class);

        List<Map<String, String>> actualCarDetailsList = productDetailsPage.getAllProductDetailsList();
        Map<String, String> actualCarDetails = actualCarDetailsList.get(0);

        for (Map<String, String> expectedDetails : expectedCarDetailsList) {
            String name = expectedDetails.get("name");
            String expectedValue = expectedDetails.get("value");
            if (actualCarDetails.containsKey(name)) {
                String actualValue = actualCarDetails.get(name);
                assertEquals(expectedValue, actualValue);
            } else {
                System.out.println("Expected key '" + name + "' not found in actualCarDetails.");
            }



        }
    }


    @And("I select district {string}")
    public void iSelectDistrict(String district) {
     productPage.selectDistrict(district);

    }

    @And("I select area of Dhaka {string}")
    public void iSelectAreaOfDhaka(String area) {
        productPage.selectArea(area);
    }

    @And("I click on submit location")
    public void iClickOnSubmitLocation() {
     productPage.locationSubmit();

    }

    @And("I click on New readymade flat for sale  property name")
    public void iClickOnNewReadymadeFlatForSalePropertyName() {
      productPage.clickOnReadymadeFlat();
    }

    @And("I click on Oppo Reno {int} Used mobile name")
    public void iClickOnOppoRenoUsedMobileName(int arg0) {
      productPage.clickOnOppoMobile();
    }

    @And("I click on Mans Bags name")
    public void iClickOnMansBagsName() {
        productPage.clickOnMensBag();
    }

    @And("I click on Senior Project Accountant name")
    public void iClickOnSeniorProjectAccountantName() {
        productPage.clickOnProjectAccountant();
    }

    @Given("I Click on Property Category")
    public void iClickOnPropertyCategory() {
     productPage.clickOnProperties();
    }

    @Then("I click on the Flat for Sale product in this category")
    public void iClickOnTheFlatForSaleProductInThisCategory() {
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if (switchtoRightWindow("Properties", hList)) {
        }

     productPage.clickFlatForSaleCard();


    }

    @Then("I should see search results for {string} in the Sub-Category page")
    public void iShouldSeeSearchResultsForInTheSubCategoryPage(String keyword) {
        productPage.isOnSubCategoryResultsPage(keyword);
    }

    @Given("I Click on Vehicle Category")
    public void iClickOnVehicleCategory() {
        productPage.clickOnVehicles();
    }

    @Then("I click on the Car product in this category")
    public void iClickOnTheCarProductInThisCategory() {
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if(switchtoRightWindow("Vehicles", hList)) {
        }

        productPage.clickOnCar();
    }

    @Given("I Click on Electronics Category")
    public void iClickOnElectronicsCategory() {
        productPage.clickOnElectronics();
    }

    @Then("I click on the Mobile product in this category")
    public void iClickOnTheMobileProductInThisCategory() {
        productPage.clickOnMobile();
    }

    @Given("I Click on LifeStyle Category")
    public void iClickOnLifeStyleCategory() {
        productPage.clickOnLifestyle();
    }

    @Then("I click on the Mens Bags or wallets product in this category")
    public void iClickOnTheMensBagsOrWalletsProductInThisCategory() {
       productPage.clickOnBagsWallet();
    }

    @When("I should see the category window page of LifeStyle product")
    public void iShouldSeeTheCategoryWindowPageOfLifeStyleProduct() {
        boolean isModalDisplayed = productPage.isModalDialogOfLifeStyleDisplayed();
        if (isModalDisplayed) {
            logger.info("Category window page of related products is displayed.");

        } else {
            logger.error("Category window page is not displayed.");
        }

    }

    @When("I should see the category window page of Electronics product")
    public void iShouldSeeTheCategoryWindowPageOfElectronicsProduct() {
        boolean isModalDisplayed = productPage.isModalDialogOfElectronicsDisplayed();
        if (isModalDisplayed) {
            logger.info("Category window page of related products is displayed.");

        } else {
            logger.error("Category window page is not displayed.");
        }


    }

    @When("I should see the category window page of Vehicle product")
    public void iShouldSeeTheCategoryWindowPageOfVehicleProduct() {
        boolean isModalDisplayed = productPage.isModalDialogOfVehicleDisplayed();
        if (isModalDisplayed) {
            logger.info("Category window page of related products is displayed.");

        } else {
            logger.error("Category window page is not displayed.");
        }


    }


    @When("I should see the category window page of Property product")
    public void iShouldSeeTheCategoryWindowPageOfPropertyProduct() {
        boolean isModalDisplayed = productPage.isModalDialogOfPropertyDisplayed();
        if (isModalDisplayed) {
            logger.info("Category window page of related products is displayed.");

        } else {
            logger.error("Category window page is not displayed.");
        }


    }

    @Given("I Click on Jobs Category")
    public void iClickOnJobsCategory() {
        productPage.clickOnJobs();
    }

    @When("I should see the category window page of Jobs product")
    public void iShouldSeeTheCategoryWindowPageOfJobsProduct() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isModalDisplayed = productPage.isModalDialogOfJobsDisplayed();
        if (isModalDisplayed) {
            logger.info("Category window page of related products is displayed.");

        } else {
            logger.error("Category window page is not displayed.");
        }

    }

    @Then("I click on the Accountant product in this category")
    public void iClickOnTheAccountantProductInThisCategory() {
        productPage.clickOnAccountant();
    }


    @Then("I hover on category menu")
    public void iHoverOnCategoryMenu() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.hoverOnCategory();
    }

    @Given("I hover on the Property category")
    public void iHoverOnThePropertyCategory() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.hoverOnProperty();
    }

    @When("I click on the Flat for Sale product in menu category")
    public void iClickOnTheFlatForSaleProductInMenuCategory() {
        homePage.flatForSaleMenuClick();
    }


    @Given("I hover on the Vehicle category")
    public void iHoverOnTheVehicleCategory() {
        homePage.hoverOnVehicles();
    }

    @When("I click on the Car product in this menu category")
    public void iClickOnTheCarProductInThisMenuCategory() {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        homePage.clickOnMenuOfCar();
    }

    @Given("I hover on the Electronics category")
    public void iHoverOnTheElectronicsCategory() {
        homePage.hoverOnElectronics();
    }

    @When("I click on the Mobile product in this menu category")
    public void iClickOnTheMobileProductInThisMenuCategory() {
    homePage.mobileMenuClick();
    }

    @Given("I hover on the LifeStyle category")
    public void iHoverOnTheLifeStyleCategory() {
        homePage.hoverOnLifeStyle();
    }

    @When("I click on the Mens Bags or wallets product in this menu category")
    public void iClickOnTheMensBagsOrWalletsProductInThisMenuCategory() {
        homePage.mensBagsMenuClick();
    }

    @Given("I hover on the Jobs category")
    public void iHoverOnTheJobsCategory() {
        homePage.hoverOnJobs();
    }

    @Then("I click on the Accountant product in this menu category")
    public void iClickOnTheAccountantProductInThisMenuCategory() {
        homePage.accountantMenuClick();
    }
}
