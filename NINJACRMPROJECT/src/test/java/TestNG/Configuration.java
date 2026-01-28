package TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Configuration {
	@Test
	public void testcase() {
		Reporter.log("hello",true);
	}
	@Test
	public void testcase1() {
		Reporter.log("hello11",true);
	}
	@BeforeSuite
	public void beforesuite() {
		Reporter.log("Datebase connectivity--beforesuite",true);
	}
	@AfterSuite
	public void aftersuite() {
		Reporter.log("closing Datebase connectivity--beforesuite",true);
	}
	@BeforeClass
	public void beforeclass() {
		Reporter.log("Launching the browser--beforeclass",true);
	}
	@AfterSuite
	public void afterclass() {
		Reporter.log("closing the browser--afterclass",true);
		}
	@BeforeMethod
	public void beforemethod() {
		Reporter.log("Login into the app--beforemethod",true);
	}
	@AfterMethod
	public void aftermethod() {
		Reporter.log("Logout the app--aftermethod",true);
	}
	@BeforeTest
	public void beforetest() {
		Reporter.log("Parallel--beforetest",true);
	}
	@AfterTest
	public void aftertest() {
		Reporter.log("Parallel--aftertest",true);
	}


}

