package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
    public void sample() {
		String ExpectedTitle = "ninza";
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("http://49.249.28.218:8098/"); 
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, ExpectedTitle);
		System.out.println("step1");
		
    }
}
