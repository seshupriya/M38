package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	@Test
     public void seshupriya() {
    	Reporter.log("hello seshupriya",true); 
     }
	@Test
     public void meena() {
     	Reporter.log("hello meena",true); 
      }
	@Test(enabled=false)
     public void Ruksar() {
     	Reporter.log("hello Ruksar",true); 
      }
	@Test(enabled=false)
     public void Afrin() {
     	Reporter.log("hello Afrin",true); 
      }
	@Test(enabled=true)
     public void Abhijeet() {
     	Reporter.log("hello Abhijeet",true); 
      }
}
