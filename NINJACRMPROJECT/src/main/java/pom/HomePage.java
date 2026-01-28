package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
	@FindBy(linkText = "Products")
	private WebElement PRODUCTWE;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement CREATECAMPAIGNWE;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement TOASTMSGWE;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement USERICONWE;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement TOASTCLOSE;
	
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement LOGOUTWE;

	public WebElement getPRODUCTWE() {
		return PRODUCTWE;
	}

	public WebElement getCREATECAMPAIGNWE() {
		return CREATECAMPAIGNWE;
	}

	public WebElement getTOASTMSGWE() {
		return TOASTMSGWE;
	}

	public WebElement getUSERICONWE() {
		return USERICONWE;
	}

	public WebElement getTOASTCLOSE() {
		return TOASTCLOSE;
	}

	public WebElement getLOGOUTWE() {
		return LOGOUTWE;
	}
	
}