package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOn {
	@Test
    public void createAccount() {
    	Reporter.log("account is created",true);
    }
	@Test(dependsOnMethods ="createAccount" )
    public void updateAccount() {
    	Reporter.log("account is updated",true);
    }
	@Test(dependsOnMethods = {"createAccount","updateAccount"})
    public void deleteAccount() {
    	Reporter.log("account is deleted",true);
    }
}
