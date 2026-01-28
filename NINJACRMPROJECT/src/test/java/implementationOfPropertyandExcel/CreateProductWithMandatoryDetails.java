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
import pom.AddProductPage;
import pom.HomePage;
import pom.LoginPage;

public class CreateProductWithMandatoryDetails {

	public static void main(String[] args) throws IOException {
		
		PropertyUtility plib=new PropertyUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String URL = plib.toReadDataFromPropertyFile("url");
		String BROWSER = plib.toReadDataFromPropertyFile("browser");
		String USERNAME = plib.toReadDataFromPropertyFile("username");
		String PASSWORD = plib.toReadDataFromPropertyFile("password");
		
		
		String PRODUCT = elib.toReadDataFromExcelFile("Product", 1, 0);
		String CATEGORY = elib.toReadDataFromExcelFile("Product", 1, 1);
		String QUANTITY = elib.toReadDataFromExcelFile("Product", 1, 2);
		String PRICE = elib.toReadDataFromExcelFile("Product", 1, 3);
		String VENDOR = elib.toReadDataFromExcelFile("Product", 1, 4);
		
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
			HomePage hp=new HomePage(driver);
		//Create product with mandatory details
		AddProductPage adp=new AddProductPage(driver);
		hp.getPRODUCTWE().click();
		adp.getADDPRODUCTWE().click();
		WebElement ts = adp.getQUANTITYWE();
		ts.clear();
		ts.sendKeys(QUANTITY);
		adp.getPRODUCTNAMEWE().sendKeys(PRODUCT+jlib.randomCount());
		WebElement price = adp.getPRICEWE();
		price.clear();
		price.sendKeys(PRICE);
		
		WebElement categoryDropdown = adp.getPRODUCTCATEGORYWE();
		wlib.selectByVisibleText(CATEGORY,categoryDropdown);
		WebElement vendorDropdown = adp.getVENDORWE();
		wlib.selectByVisibleText(VENDOR,vendorDropdown);
		adp.getADDPRODUCTBUTTONWE().click();
		
		//Validation of create Product
				WebElement toastmsg=hp.getTOASTMSGWE();
				wlib.waitForElementToBeVisible(driver,toastmsg);
				String msg = toastmsg.getText();
				if(msg.contains(PRODUCT)) {
					System.out.println("Product created successfully");
				}
				else {
					System.out.println("Product is not created");
				}
				WebElement toastclose = hp.getTOASTCLOSE();
				wlib.waitForElementToBeInvisible(driver, toastclose);
		
		//Logout
				WebElement usericon = hp.getUSERICONWE();
				wlib.mouseHover(driver,usericon);
				hp.getLOGOUTWE().click();
				driver.close();
		
	}

}
