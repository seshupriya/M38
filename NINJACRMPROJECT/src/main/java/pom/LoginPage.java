package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(id="username")
private WebElement UN;

@FindBy(id="inputPassword")
private WebElement PWD;

@FindBy(xpath="//button[text()='Sign In']")
private WebElement LOGIN;

public WebElement getUN() {
	return UN;
}

public WebElement getPWD() {
	return PWD;
}

public WebElement getLOGIN() {
	return LOGIN;
}

}
