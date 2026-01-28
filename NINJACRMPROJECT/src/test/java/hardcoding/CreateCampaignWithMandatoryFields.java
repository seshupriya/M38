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

public class CreateCampaignWithMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
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
		
		//Create campaign with manadatory details
		
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click(); 
		driver.findElement(By.name("campaignName")).sendKeys("Seshupriya"+alphabet); 
		WebElement ts = driver.findElement(By.name("targetSize")); 
		ts.clear(); 
		ts.sendKeys("7"); 
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//Validation of create campaign
		WebElement toastmsg=driver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(2000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if(msg.contains("Seshupriya"+alphabet)) {
			System.out.println("Campaign created successfully");
		}
		else {
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
