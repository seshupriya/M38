package TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class screenshotOfLoginPage {
	@Test
	 public void sample() throws IOException {
		 	Date d=new Date();
		 	String newdate = d.toString().replace(" ","_").replace(":", "_");
	    	WebDriver driver = new ChromeDriver(); 
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			driver.get("http://49.249.28.218:8098/"); 
			TakesScreenshot ts=(TakesScreenshot) driver;
	        File temp=ts.getScreenshotAs(OutputType.FILE);
	        File perm=new File("./Screenshot/ninzacrm_"+newdate+".png");
	        FileHandler.copy(temp,perm);
}
}

