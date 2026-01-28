package hardcoding;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignWithStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions settings = new ChromeOptions(); 
		Map<String, Object> prefs = new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); 
		
		//Launching the chrome browser
		Random rand = new Random();
		char upper = (char) ('A' + rand.nextInt(26));
		char lower = (char)(upper+32);
		String alphabet = ""+upper+lower;
		
		WebDriver driver = new ChromeDriver(settings); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		//Login into the application
		
		driver.get("http://49.249.28.218:8098/"); 
		driver.findElement(By.id("username")).sendKeys("rmgyantra"); 
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999"); 
		driver.findElement(By.xpath("//button[text()='Sign In']")).click(); 
		
		//Create campaign with status
		
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click(); 
	    driver.findElement(By.name("campaignName")).sendKeys("vra"+alphabet); 
	    driver.findElement(By.name("campaignStatus")).sendKeys("Active");
		WebElement ts = driver.findElement(By.name("targetSize")); 
		ts.clear(); 
	    ts.sendKeys("7"); 
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//Validation of create campaign
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toastmsg = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']"))
		);

		String msg = toastmsg.getText();

		if(msg.contains("vra" + alphabet)) {
		    System.out.println("Campaign created successfully");
		} else {
		    System.out.println("Campaign is not created");
		}

		
		//Logout
				WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				Actions act = new Actions(driver); 
				act.moveToElement(usericon).click().perform(); 
				driver.findElement(By.xpath("//div[text()='Logout ']")).click(); 
				driver.close();


	}

}
