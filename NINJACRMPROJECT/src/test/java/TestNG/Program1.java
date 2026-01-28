package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Program1 {
   
   @Test
   public void blinkit() {
	   Reporter.log("Hello blinkit");
   }
   @Test
   public void zepto() {
	   Reporter.log("Hello zepto");
   }
   @Test
   public void instamart() {
	   Reporter.log("Hello instamart");
   }
   @Test
   public void amazon() {
	   Reporter.log("Hello amazon");
   }
}
