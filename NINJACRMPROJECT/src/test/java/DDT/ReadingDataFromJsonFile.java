package DDT;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadingDataFromJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
      JSONParser jparser=new JSONParser();
      FileReader reader=new FileReader("./src/test/resources/Commondata.json");
      Object javaobj = jparser.parse(reader);
      JSONObject obj=(JSONObject)javaobj;
      String URL= obj.get("url").toString();
      String BROWSER = obj.get("browser").toString();
      String USERNAME = obj.get("username").toString();
      String PASSWORD = obj.get("password").toString();
      
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
