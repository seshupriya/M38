package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class invocationCount {
	@Test(invocationCount = 5)
    public void sample() {
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("http://49.249.28.218:8098/"); 
		driver.findElement(By.id("username")).sendKeys("rmgyantra"); 
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999"); 
		driver.findElement(By.xpath("//button[text()='Sign In']")).click(); 
		driver.quit();
    }
}
