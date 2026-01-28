package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderProgram {
	@DataProvider
	public Object[][] logindetails(){
	
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="Seshupriya";
		objarr[0][1]="Seshupriya@123";
		objarr[1][0]="Meena";
		objarr[1][1]="Meena@123";
		objarr[2][0]="Abhi";
		objarr[2][1]="Abhi@123";
		return objarr;
	
	}
	@Test(dataProvider = "logindetails")
	public void sample(String un,String pwd) throws InterruptedException {
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("http://49.249.28.218:8098/"); 
		driver.findElement(By.id("username")).sendKeys(un); 
		driver.findElement(By.id("inputPassword")).sendKeys(pwd); 
		driver.findElement(By.xpath("//button[text()='Sign In']")).click(); 
		Thread.sleep(2000);
		driver.quit();
}
}
