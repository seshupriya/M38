package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
   
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	 public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 public void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOf(element));
	    }
	 
	public void selectByIndex(int index,WebElement element) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
    
	public void selectByValue(String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectByVisibleText(String text,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void switchToFrame(String idOrname,WebDriver driver) {
		driver.switchTo().frame(idOrname);
	}
	
	public void switchToFrame(WebElement element,WebDriver driver) {
		driver.switchTo().frame(element);
	}
	
	public void switchToFrame(int index ,WebDriver driver) {
		driver.switchTo().frame(index);
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();;
	}
	
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alertSendKeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	public String alertgetText(WebDriver driver) {
		String Text = driver.switchTo().alert().getText();
		return Text;
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void clickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void doubleClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).click().perform();
	}
	
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).click().perform();
	}
	
	public void switchToWindow(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> allwindowId = driver.getWindowHandles();
		allwindowId.remove(parent);
		for(String id:allwindowId) {
		driver.switchTo().window(id);
		}
	}
	
	public void passInput(WebDriver driver,WebElement
			element,String text) {
			Actions act = new Actions(driver);
			act.click(element).sendKeys(text).perform();
			}
			public void takesScreenshot(WebDriver driver,String filename)
			throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File perm=new File("./errorshot/"+filename+".png");
			FileHandler.copy(temp, perm);
			}
			public void toScrollby(WebDriver driver,int x,int y) {
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy("+x+","+y+")");
			}
		
	public void ApplicationUrl(WebDriver driver,String url) {
	    driver.get(url);
	}
	
	public void closeBrowser(WebDriver driver) {
        driver.close();
    }
	
	public void quitBrowser(WebDriver driver) {
        driver.quit();
    }

	 public String getTitle(WebDriver driver) {
	        return driver.getTitle();
	    }
	 
	 public String getCurrentURL(WebDriver driver) {
	        return driver.getCurrentUrl();
	    }
     
	 public void navigateBack(WebDriver driver) {
	        driver.navigate().back();
	    }

	  public void navigateForward(WebDriver driver) {
	        driver.navigate().forward();
	    }

	  public void refreshPage(WebDriver driver) {
	        driver.navigate().refresh();
	  }
}