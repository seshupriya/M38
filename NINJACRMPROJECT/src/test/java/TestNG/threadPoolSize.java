package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class threadPoolSize {
	@Test(invocationCount = 6,threadPoolSize = 2)
   public void sample() {
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.facebook.com/");
       driver.findElement(By.name("email")).sendKeys("Seshupriya");
       driver.findElement(By.id("pass")).sendKeys("Seshupriya15@");
       driver.findElement(By.name("login")).click();
       driver.quit();
   }
}
	