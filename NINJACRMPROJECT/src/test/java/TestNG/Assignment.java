package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment {
	@DataProvider
	public Object[][] flipkart() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src/test/resources/iPhone_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MobileData");
		int rowcount = sh.getLastRowNum();   // number of data rows (excluding header)

		Object[][] obj = new Object[rowcount][2];

		for (int i = 0; i < rowcount; i++) {
		    obj[i][0] = sh.getRow(i + 1).getCell(0).getStringCellValue();
		    obj[i][1] = sh.getRow(i + 1).getCell(1).getStringCellValue();
		}

		    return obj;
	}
	
	
	@Test(dataProvider = "flipkart")
	public void sample(String mobile,String version ) throws InterruptedException {
    	WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.flipkart.com/"); 
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(mobile+Keys.ENTER);
		WebElement priceElement = driver.findElement(
			    By.xpath("(//div[contains(text(),'" + version + "')]/../..//div[contains(text(),'₹')])[1]")
			);

			String price = priceElement.getText();
			System.out.println(version + " Price: " + price);
		Thread.sleep(2000);
		driver.quit();
}
}
