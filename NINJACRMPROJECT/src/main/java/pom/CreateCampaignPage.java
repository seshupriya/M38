package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
public CreateCampaignPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
	@FindBy(name="campaignName")
	private WebElement CAMPAIGNNAMEWE;
	
	@FindBy(name="campaignStatus")
	private WebElement STATUSWE;
	
	@FindBy(name="expectedCloseDate")
	private WebElement EXPECTEDCLOSEDATEWE;
	
	@FindBy(name="targetSize")
	private WebElement TARGETSIZEWE;
	
	public WebElement getCAMPAIGNNAMEWE() {
		return CAMPAIGNNAMEWE;
	}

	public WebElement getSTATUSWE() {
		return STATUSWE;
	}

	public WebElement getEXPECTEDCLOSEDATEWE() {
		return EXPECTEDCLOSEDATEWE;
	}

	public WebElement getTARGETSIZEWE() {
		return TARGETSIZEWE;
	}

	public WebElement getCREATECAMPAIGNBUTTONWE() {
		return CREATECAMPAIGNBUTTONWE;
	}

	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement CREATECAMPAIGNBUTTONWE;
}
