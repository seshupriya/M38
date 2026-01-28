package batch;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo1 {
	@Test
	public void sample() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		System.out.println("hello");
		driver.quit();
	}
}
