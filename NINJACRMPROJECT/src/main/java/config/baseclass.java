package config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebDriverUtility;
import pom.HomePage;
import pom.LoginPage;

public class baseclass {
	public WebDriver driver=null;
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public PropertyUtility plib=new PropertyUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite(groups = "smoke")
	public void beforesuite() {
		Reporter.log("Datebase connectivity--beforesuite",true);
	}
	@AfterSuite(groups = "smoke")
	public void aftersuite() {
		Reporter.log("closing Datebase connectivity--beforesuite",true);
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = "smoke")
	public void beforeclass() throws IOException {
		String BROWSER = plib.toReadDataFromPropertyFile("browser");
		 //String BROWSER=browser;
	     if(BROWSER.equals("chrome")){
	    	 ChromeOptions settings = new ChromeOptions(); 
	 		Map<String, Object> prefs = new HashMap<>(); 
	 		prefs.put("profile.password_manager_leak_detection", false); 
	 		settings.setExperimentalOption("prefs", prefs); 
	 		driver=new ChromeDriver(settings);
	     }else if(BROWSER.equals("firefox")) {
	    	 driver=new FirefoxDriver();
	     }
		
	     wlib.maximize(driver);
			wlib.implicitWait(driver); 
	}
	@AfterClass(groups = "smoke")
	public void afterclass() {
		driver.quit();
		
		}
	@BeforeMethod(groups = "smoke")
	public void beforemethod() throws IOException {
		String URL = plib.toReadDataFromPropertyFile("url");
		String USERNAME = plib.toReadDataFromPropertyFile("username");
		String PASSWORD = plib.toReadDataFromPropertyFile("password");
		driver.get(URL);
	    wlib.ApplicationUrl(driver, URL);  
		LoginPage lp=new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPWD().sendKeys(PASSWORD);
		lp.getLOGIN().click();
	}
	@AfterMethod(groups = "smoke")
	
	public void aftermethod() {
	    try {
	        HomePage hp = new HomePage(driver);
	        WebElement usericon = hp.getUSERICONWE();
	        wlib.mouseHover(driver, usericon);

	        WebElement logout = hp.getLOGOUTWE();
	        wlib.waitForElementToBeVisible(driver, logout);
	        logout.click();
	    } catch (Exception e) {
	        System.out.println("Logout skipped (already logged out / browser closed)");
	    }
	}

	@BeforeTest(groups = "smoke")
	public void beforetest() {
		Reporter.log("Parallel--beforetest",true);
	}
	@AfterTest(groups = "smoke")
	public void aftertest() {
		Reporter.log("Parallel--aftertest",true);
	}
}
