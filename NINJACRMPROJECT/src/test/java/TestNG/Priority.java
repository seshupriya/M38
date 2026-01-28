package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {
	@Test(priority = -1)
    public void createAccount() {
    	Reporter.log("account is created",true);
    }
	@Test(priority = 0)
    public void updateAccount() {
    	Reporter.log("account is updated",true);
    }
	@Test(priority = 1)
    public void deleteAccount() {
    	Reporter.log("account is deleted",true);
    }
}
