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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProductWithMandatoryDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions settings = new ChromeOptions(); 
		Map<String, Object> prefs = new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); 
		
		//Launching the chrome browser
	
		Random rand=new Random();
		int count = rand.nextInt(1000);
		
		WebDriver driver = new ChromeDriver(settings); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		//Login into the application
		
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		//Create product with mandatory details
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		driver.findElement(By.name("productId")).sendKeys("PPHH");
		WebElement ts = driver.findElement(By.name("quantity"));
		ts.clear();
		ts.sendKeys("2");
		driver.findElement(By.name("productName")).sendKeys("Mixer"+count);
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("200000");
		WebElement categoryDropdown = driver.findElement(By.name("productCategory"));
		Select category=new Select(categoryDropdown);
		category.selectByVisibleText("Furniture");
		WebElement vendorDropdown = driver.findElement(By.name("vendorId"));
		Select vendor=new Select(vendorDropdown);
		vendor.selectByVisibleText("Vendor_95062 - (Electronics)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Validation of create Product
				WebElement toastmsg=driver.findElement(By.xpath("//div[@role='alert']"));
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(toastmsg));
				String msg = toastmsg.getText();
				if(msg.contains("Mixer")) {
					System.out.println("Product created successfully");
				}
				else {
					System.out.println("Product is not created");
				}
				
		
		//Logout
				WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				Actions act = new Actions(driver); 
				act.moveToElement(usericon).click().perform(); 
				driver.findElement(By.xpath("//div[text()='Logout ']")).click();
				driver.close();
		
	}

}
