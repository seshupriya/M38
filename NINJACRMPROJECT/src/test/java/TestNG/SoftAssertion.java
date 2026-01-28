package TestNG;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
    public void sample() {
		String ExpectedTitle = "ninza";
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("http://49.249.28.218:8098/"); 
		String actualTitle = driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualTitle, ExpectedTitle);
		System.out.println("hello");
		
		
    }
}
