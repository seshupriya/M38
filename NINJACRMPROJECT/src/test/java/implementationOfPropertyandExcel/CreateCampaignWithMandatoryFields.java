package implementationOfPropertyandExcel;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebDriverUtility;
import pom.CreateCampaignPage;
import pom.HomePage;
import pom.LoginPage;

public class CreateCampaignWithMandatoryFields {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		PropertyUtility plib=new PropertyUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String URL = plib.toReadDataFromPropertyFile("url");
		String BROWSER = plib.toReadDataFromPropertyFile("browser");
		String USERNAME = plib.toReadDataFromPropertyFile("username");
		String PASSWORD = plib.toReadDataFromPropertyFile("password");
		
		String CAMPAIGNNAME = elib.toReadDataFromExcelFile("Campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcelFile("Campaign", 1, 1);
		
		
		
		//Launching the chrome browser
		
		
		WebDriver driver=null;
	     if(BROWSER.equals("chrome")){
	    	 ChromeOptions settings = new ChromeOptions(); 
	 		Map<String, Object> prefs = new HashMap<>(); 
	 		prefs.put("profile.password_manager_leak_detection", false); 
	 		settings.setExperimentalOption("prefs", prefs); 
	 		driver=new ChromeDriver(settings);
	     }else if(BROWSER.equals("edge")) {
	    	 driver=new EdgeDriver();
	     }
		wlib.maximize(driver);
		wlib.implicitWait(driver); 
		
		//Login into the application
		
		wlib.ApplicationUrl(driver, URL); 
		LoginPage lp=new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPWD().sendKeys(PASSWORD);
		lp.getLOGIN().click();
		
		//Create campaign with manadatory details
		
		
		//homepage
		HomePage hp=new HomePage(driver);
		hp.getCREATECAMPAIGNWE().click();
        
        //CreateCampaignPage
        CreateCampaignPage ccp=new CreateCampaignPage(driver);
		String campaignNameWithRandom = CAMPAIGNNAME + jlib.RandomAlphabet();
		ccp.getCAMPAIGNNAMEWE().sendKeys(campaignNameWithRandom); 
		WebElement ts = ccp.getTARGETSIZEWE(); 
		ts.clear(); 
		ts.sendKeys(TARGETSIZE); 
		ccp.getCREATECAMPAIGNBUTTONWE().click();
		
		//Validation of create campaign
		WebElement toastmsg=hp.getTOASTMSGWE();
		wlib.waitForElementToBeVisible(driver,toastmsg);
		String msg = toastmsg.getText();
		if(msg.contains(campaignNameWithRandom)) {
			System.out.println("Campaign created successfully");
		}
		else {
			System.out.println("Campaign is not created");
		}
		WebElement toastclose =hp.getTOASTCLOSE();
		wlib.waitForElementToBeInvisible(driver, toastclose);
		
		//Logout
				WebElement usericon = hp.getUSERICONWE();
				wlib.mouseHover(driver,usericon);
			hp.getLOGOUTWE().click(); 
				driver.close();
		
		

	}

}
