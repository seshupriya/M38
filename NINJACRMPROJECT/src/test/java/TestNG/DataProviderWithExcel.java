package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
	@DataProvider
	public Object[][] logindetails() throws EncryptedDocumentException, IOException{
	
		FileInputStream fis=new FileInputStream("./src/test/resources/E38_updated.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int count = sh.getLastRowNum();
		Object[][] obj=new Object[count][2];
		for(int i=0;i<count;i++) {
			obj[i][0]=sh.getRow(+1).getCell(0).getStringCellValue();
			obj[i][1]=sh.getRow(+1).getCell(1).getStringCellValue();
			
		}
		return obj;
	
	}
	@Test(dataProvider = "logindetails")
	public void sample(String un,String pwd) throws InterruptedException {
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("http://49.249.28.218:8098/"); 
		driver.findElement(By.id("username")).sendKeys(un); 
		driver.findElement(By.id("inputPassword")).sendKeys(pwd); 
		driver.findElement(By.xpath("//button[text()='Sign In']")).click(); 
		Thread.sleep(2000);
		driver.quit();
}
}
