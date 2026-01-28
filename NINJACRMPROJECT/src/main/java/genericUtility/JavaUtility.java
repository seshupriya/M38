package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
    public String RandomAlphabet() {
    	Random rand = new Random();
		char upper = (char) ('A' + rand.nextInt(26));
		char lower = (char)(upper+32);
		String alphabet = ""+upper+lower;
		return alphabet;
    }
    
    public String ExpectedDate() {
    	Date d= new Date();
	       SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");       
	       String currentDate = sim.format(d);
	       Calendar cal = sim.getCalendar();
	       cal.add(cal.DAY_OF_MONTH, 15);
	      String reqDate = sim.format(cal.getTime());
	      return reqDate;
    }
    
    public int randomCount() {
    	Random rand=new Random();
		int count = rand.nextInt(1000);
		return count;
    }
    
}
