package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Base{
	 @FindBy(id = "searchText")
	 private WebElement searchBox;


	 @FindBy(xpath = "//i[@class='fa-solid fa-magnifying-glass']")
	 private WebElement searchButton;

	 @FindBy(xpath = "//button[@type='button']")
	 private WebElement microphoneButton;

	@FindBy(xpath = "//h6[contains(text(),'Category')]")
	private WebElement hoverCategory;

	@FindBy(xpath = "//h6[contains(text(),'Members')]")
	private WebElement hoverMembers;


	@FindBy(xpath = "//*[@id='dynamic']/div[1]/div[2]/div/div/ul/li[4]/div/span")
	private WebElement plutinumClick;
	@FindBy(xpath = "//span[text()='Properties']")
	private WebElement hoverProperty;

	@FindBy(xpath = "//span[text()='Vehicles']")
	private WebElement hoverVehicles;

	@FindBy(xpath = "//span[text()='Electronics']")
	private WebElement hoverElectronics;

	@FindBy(xpath = "//span[text()='Lifestyles']")
	private WebElement hoverLifeStyle;
	@FindBy(xpath = "//span[text()='Jobs']")
	private WebElement hoverJobs;
	@FindBy(xpath = "//[@id='dynamic']/div[1]/div[1]/div/div/ul/li[1]/div[2]/ul/li[7]")
	private WebElement clickOnMenuFlatForSale;

	@FindBy(xpath = "/html/body/nav/div/div/ul/li[1]/div/div/div/div[1]/div[1]/div/div/ul/li[5]/div[2]/ul/li[text()='Accountant']")
	private WebElement clickOnMenuAccountant;
	@FindBy(xpath = "/html/body/nav/div[2]/div/ul/li[1]/div/div/div/div[1]/div[1]/div/div/ul/li[3]/div[2]/ul/li[text()='Mobile']")
	private WebElement clickOnMenuMobile;

	@FindBy(xpath = "/html/body/nav/div[2]/div/ul/li[1]/div/div/div/div[1]/div[1]/div/div/ul/li[2]/div[2]/ul/li[text()='Car']")
	private WebElement clickOnMenuCar;
	@FindBy(xpath = "/html/body/nav/div[2]/div/ul/li[1]/div/div/div/div[1]/div[1]/div/div/ul/li[4]/div[2]/ul/li[text()='Mens Bags Or Wallets']")
	private WebElement clickOnMenuMensBags;
	@FindBy(className = "post_brand_name")
	private List<WebElement> postBrandNames;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getPostBrandNames() {
		return postBrandNames;
	}
	public void mensBagsMenuClick() {
		fluentWaitClick(clickOnMenuMensBags);
	}
	public void accountantMenuClick() {
		fluentWaitClick(clickOnMenuAccountant);
	}
	public void mobileMenuClick() {
		fluentWaitClick(clickOnMenuMobile);
	}
	public void flatForSaleMenuClick() {
		fluentWaitClick(clickOnMenuFlatForSale);
	}

	public void hoverOnLifeStyle() {
		mouseHover(hoverLifeStyle);
	}

	public void hoverOnJobs() {
		mouseHover(hoverJobs);
	}
	public void hoverOnElectronics() {
		mouseHover(hoverElectronics);
	}
	public void hoverOnMember() {
		mouseHover(hoverMembers);
	}
	public void clickOnPlatinum(){
		fluentWaitClick(plutinumClick);

	}
	public void hoverOnCategory() {
		mouseHover(hoverCategory);
	}
public void clickOnMenuOfCar(){
		fluentWaitClick(clickOnMenuCar);

}
	public void hoverOnProperty() {
		mouseHover(hoverProperty);
	}
	public void hoverOnVehicles() {
		mouseHover(hoverVehicles);
	}
	public void navigateUrl(String url) {
		navigateURL(url);
	}

    public String getPageTitle() {
    	return driver.getTitle();
    }

    
    public void enterSearchKeyword(String keyword) {
        searchBox.sendKeys(keyword);
    }
    
    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickMicrophoneButton() {
        microphoneButton.click();
    }
    
    
}
