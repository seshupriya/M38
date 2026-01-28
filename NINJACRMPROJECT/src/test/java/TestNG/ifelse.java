package TestNG;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ifelse {
	@Test
    public void sample() {
		String ExpectedTitle = "ninza";
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("http://49.249.28.218:8098/"); 
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if(actualTitle.equals(ExpectedTitle)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		
    }
}
