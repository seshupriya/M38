package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadingDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     FileInputStream fis=new FileInputStream("./src/test/resources/Commondata");
     Properties prop=new Properties();
     prop.load(fis);
     String BROWSER = prop.getProperty("browser");
     String URL = prop.getProperty("url");
     String USERNAME = prop.getProperty("username");
     String PASSWORD = prop.getProperty("password");
     
     //System.out.println(BROWSER);
     //System.out.println(URL);
     //System.out.println(USERNAME);
     //System.out.println(PASSWORD);
     
     
     
     WebDriver driver=null;
     if(BROWSER.equals("chrome")){
    	 ChromeOptions settings = new ChromeOptions(); 
 		Map<String, Object> prefs = new HashMap<>(); 
 		prefs.put("profile.password_manager_leak_detection", false); 
 		settings.setExperimentalOption("prefs", prefs); 
 		driver=new ChromeDriver(settings);
     }else if(BROWSER.equals("edge")) {
    	 driver=new EdgeDriver();
     }
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get(URL);
     driver.findElement(By.id("username")).sendKeys(USERNAME);
     driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
     driver.findElement(By.xpath("//button[text()='Sign In']")).click();
     
	}

}
