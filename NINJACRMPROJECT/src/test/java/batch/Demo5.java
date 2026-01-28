package batch;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo5 {
	@Test
	public void sample() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		System.out.println("hello");
		driver.quit();
	}
}
