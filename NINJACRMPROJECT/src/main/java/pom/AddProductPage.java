package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
public AddProductPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement ADDPRODUCTWE;
	
	@FindBy(name="productName")
	private  WebElement PRODUCTNAMEWE;
	
	@FindBy(name="productCategory")
	private  WebElement PRODUCTCATEGORYWE;
	
	@FindBy(name="quantity")
	private  WebElement QUANTITYWE;
	
	@FindBy(name="price")
	private  WebElement PRICEWE;
	
	public WebElement getADDPRODUCTWE() {
		return ADDPRODUCTWE;
	}

	public WebElement getPRODUCTNAMEWE() {
		return PRODUCTNAMEWE;
	}

	public WebElement getPRODUCTCATEGORYWE() {
		return PRODUCTCATEGORYWE;
	}

	public WebElement getQUANTITYWE() {
		return QUANTITYWE;
	}

	public WebElement getPRICEWE() {
		return PRICEWE;
	}

	public WebElement getVENDORWE() {
		return VENDORWE;
	}

	public WebElement getADDPRODUCTBUTTONWE() {
		return ADDPRODUCTBUTTONWE;
	}

	@FindBy(name="vendorId")
	private  WebElement VENDORWE;
	
	@FindBy(xpath="//button[text()='Add']")
	private  WebElement ADDPRODUCTBUTTONWE;
}
