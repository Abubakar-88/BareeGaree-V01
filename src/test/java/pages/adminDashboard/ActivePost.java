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

public class ActivePost extends Base {
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsExecutor;
//    @FindBy(xpath = "//th/a")  // Adjust the locator as per your actual header elements
//    List<WebElement> headers;

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(id = "btnSearch")
    WebElement searchButton;

    @FindBy(css = ".search-results")
    WebElement searchResults;



    @FindBy(xpath = "//th//a[@class='k-link']")
    List<WebElement> headers;
    @FindBy(xpath = " //*[@id='navid']/li[1]/a")  // Adjust the locator as per your actual header elements
    private WebElement activePost;

    @FindBy(linkText = "Active Electronic")
    private WebElement activeEelectronics;
    @FindBy(linkText = "All Active Post List")
    private WebElement allActivePost;
    @FindBy(xpath = "//div[@class='k-grid-header']//th[@role='columnheader']/a[@class='k-link']")
    private List<WebElement> columnHeaders;

    @FindBy(xpath = "//tbody/tr")
    List<WebElement> rows;
    @FindBy(css = "form.k-filter-menu")
    WebElement filterMenu;

    @FindBy(xpath = "/html/body/div[6]/form/div[1]/span[1]")
    private WebElement firstFilterConditionDropdown;


    @FindBy(xpath = "//input[@data-bind='value:filters[0].value']")
    private WebElement firstFilterInput;

    @FindBy(xpath = "/html/body/div[6]/form/div[1]/span[2]")
    private WebElement lgclOperatorDOfUserName;

    @FindBy(xpath = "/html/body/div[6]/form/div[1]/span[3]")
    private WebElement secondFilterConditionDropdown;

    @FindBy(xpath = "/html/body/div[6]/form/div[1]/span[4]")
    private WebElement secondFilterConditionDate;

    @FindBy(xpath = "//input[@data-bind='value: filters[1].value']")
    private WebElement secondFilterInput;

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'k-button k-primary')]")
    private WebElement filterButton;
    @FindBy(css = "form.k-filter-menu .k-button[type='reset']")
    WebElement clearButton;
    @FindBy(xpath = " //span/input[@class='k-formatted-value k-input']")
    WebElement totalActiveInputFilter;

    @FindBy(xpath = " //*[@id='ActiveElectronicList']/div[4]/span[2]/span")
    WebElement pageItemPerpage;

    @FindBy(xpath = "//a[@title='Go to the first page']")
    WebElement firstPageButton;

    @FindBy(xpath = "//a[@title='Go to the previous page']")
    WebElement prevPageButton;

    @FindBy(xpath = "//a[@title='Go to the next page']")
    WebElement nextPageButton;

    @FindBy(xpath = "//a[@title='Go to the last page']")
    WebElement lastPageButton;
    @FindBy(xpath = "//span[@class='k-pager-info k-label']")
    WebElement pagerInfo;

    @FindBy(css = "span.k-widget.k-dropdown.k-header")
    WebElement perPageDropdown;

    @FindBy(xpath = "//span[@class='k-dropdown-wrap k-state-default']")
    WebElement dropdownWrapper;

    @FindBy(xpath = "//span[@class='k-input']")
    WebElement perPageValue;

    @FindBy(xpath = "//ul[@class='k-list k-reset']")
    WebElement dropdownList;

    @FindBy(xpath = "//ul[@class='k-list k-reset']/li")
    List<WebElement> dropdownOptions;
    @FindBy(css = ".k-grid-excel")
    private WebElement exportToExcelButton;

    public ActivePost(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  // Increase timeout to 30 seconds
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        PageFactory.initElements(driver, this);
    }
    Logger logger = Logger.getLogger(ActivePost.class.getName());
    public void hoverOnActivePost() {
        mouseHover(activePost);
    }
    public void clickOnActiveEelectronics(){
        fluentWaitClick(activeEelectronics);
    }
    public void clickOnAllActivePost(){
        fluentWaitClick(allActivePost);
    }
    public void downloadExcel() {
        exportToExcelButton.click();
    }
    public void search(String searchParameter) {
        searchBox.clear();
        delayOfElement(2);
        searchBox.sendKeys(searchParameter);
        delayOfElement(2);
        searchButton.click();
    }

    public boolean validateSearchResults(String expectedValue) {
        return searchResults.getText().contains(expectedValue);
    }




 //Method of Pagination

    public void selectItemsPerPage(int itemsPerPage) {

        // Scroll into view and click using JavaScript to avoid interception
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", dropdownWrapper);
        jsExecutor.executeScript("arguments[0].click();", dropdownWrapper);

        wait.until(ExpectedConditions.visibilityOf(dropdownList));
        for (WebElement option : dropdownOptions) {
            if (option.getText().equals(String.valueOf(itemsPerPage))) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);
                jsExecutor.executeScript("arguments[0].click();", option);
                break;
            }
        }
        wait.until(ExpectedConditions.textToBePresentInElement(perPageValue, String.valueOf(itemsPerPage)));
    }


 public void navigateToNextPage() {
     nextPageButton.click();

 }

    public void navigateToPreviousPage() {
        prevPageButton.click();

    }

    public void navigateToFirstPage() {
        firstPageButton.click();

    }

    public void navigateToLastPage() {
        lastPageButton.click();

    }
    public String getPaginationInfo() {
        return pagerInfo.getText();
    }


    public void clickColumnHeader(String headerName) {
        for (WebElement header : headers) {
            if (header.getText().equals(headerName)) {
                header.click();
                break;
            }
        }
    }

    public int getColumnIndexByHeaderName(String headerName) {
        for (int i = 0; i < headers.size(); i++) {
            System.out.println("Checking header: " + headers.get(i).getText());
            if (headers.get(i).getText().trim().equals(headerName)) {
                System.out.println("Found header: " + headerName + " at index: " + i);
                return i;
            }
        }
        throw new IllegalArgumentException("Header not found: " + headerName);
    }

    public List<String> getColumnHeaders() {
        return headers.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(header -> !header.isEmpty()) // Filter out empty strings
                .collect(Collectors.toList());
    }
    public List<String> getColumnValues(String headerName) {
        int columnIndex = getColumnIndexByHeaderName(headerName);
        return rows.stream()
                .map(row -> row.findElements(By.tagName("td")).get(columnIndex).getText())
                .collect(Collectors.toList());
    }

    public void openFilterMenu(String headerName) {
        for (WebElement header : headers) {
            if (header.getText().trim().equals(headerName)) {
                WebElement filterIcon = header.findElement(By.xpath("..")).findElement(By.className("k-grid-filter"));
                filterIcon.click();
                wait.until(ExpectedConditions.visibilityOf(filterMenu));
                break;
            }
        }
    }


    public void setActivePostFilterCondition(String condition, String value) {

        try {
            // Scroll to the first operator dropdown and wait for visibility
            logger.info("Waiting for the first operator dropdown to be visible");
             clickDropdownAndSelectValue(firstFilterConditionDropdown, condition);
          //  delayOfElement(2);
            totalActiveInputFilter.clear();
            delayOfElement(5);
            totalActiveInputFilter.sendKeys(value);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }


    }
    public void setFirstFilterCondition(String condition, String value) {

        try {
            // Scroll to the first operator dropdown and wait for visibility
            logger.info("Waiting for the first operator dropdown to be visible");
       clickDropdownAndSelectValue(firstFilterConditionDropdown, condition);
        firstFilterInput.clear();
        firstFilterInput.sendKeys(value);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }


    }

    public void setLogicalOperatorOfAeList(String logic) {
        try {
            // Scroll to the first operator dropdown and wait for visibility
            logger.info("Waiting for the first operator dropdown to be visible");
            // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logicalOperatorDropdown);
            clickLogicalOfTitleOfAe(lgclOperatorDOfUserName, logic);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }
    }



    public void setLogicalOperator(String logic) {
        try {
        clickDropdownAndSelectValue(lgclOperatorDOfUserName, logic);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }
    }

    public void setSecondFilterCondition(String condition, String value) {
        try {
            logger.info("Waiting for the first operator dropdown to be visible");

            clickLogicalSecondFilter(secondFilterConditionDropdown, condition);

        secondFilterInput.clear();
        secondFilterInput.sendKeys(value);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }
    }
    public void setSecondLogicalConditionOfDate(String condition) {
        try {
            // Scroll to the first operator dropdown and wait for visibility
            logger.info("Waiting for the first operator dropdown to be visible");


            clickLogicalSecondFilter(secondFilterConditionDropdown, condition);

        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }
    }
    public void setSecondFilterConditionOfSubCategoryHeader(String condition, String value) {
        try {
            // Scroll to the first operator dropdown and wait for visibility
            logger.info("Waiting for the first operator dropdown to be visible");


            clickLogicalAndSelectValue1(secondFilterConditionDate, condition);
            secondFilterInput.clear();
            delayOfElement(2);
            secondFilterInput.sendKeys(value);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }
    }


    public void setSecondFilterConditionOfDate(String condition, String value) {
        try {
            // Scroll to the first operator dropdown and wait for visibility
            logger.info("Waiting for the first operator dropdown to be visible");


            clickLogicalAndSelectValue1(secondFilterConditionDate, condition);
            secondFilterInput.clear();
            secondFilterInput.sendKeys(value);
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            throw e;
        }
    }
    public void applyFilter() {
        filterButton.click();
        wait.until(ExpectedConditions.invisibilityOf(filterMenu));
    }

    public void clearFilter() {
        clearButton.click();
        wait.until(ExpectedConditions.invisibilityOf(filterMenu));
    }






    private void clickLogicalOfTitleOfAe(WebElement dropdown, String value) {
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[6]/form/div[3]/div/ul/li[text()='" +value +"']")));
        delayOfElement(3);
        option.click();
    }


    private void clickDropdownAndSelectValue(WebElement dropdown, String value) {
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + value + "')]")));
delayOfElement(3);
        option.click();
    }
    private void clickLogicalAndSelectValue1(WebElement dropdown, String value) {
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/form/div[5]/div/ul/li[text()='" +value +"']")));
        delayOfElement(3);
        option.click();
    }

    private void clickLogicalSecondFilter(WebElement dropdown, String value) {
        delayOfElement(2);
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/form/div[4]/div/ul/li[text()='" +value +"']")));
        delayOfElement(3);
        option.click();
    }

}
