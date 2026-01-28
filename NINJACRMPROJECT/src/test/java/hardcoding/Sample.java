package hardcoding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Date d= new Date();
       System.out.println(d);//Mon Dec 29 16:30:05 IST 2025
       SimpleDateFormat sim=new SimpleDateFormat();       
       String currentDate = sim.format(d);
       System.out.println(currentDate);
       Calendar cal = sim.getCalendar();
       cal.add(cal.DAY_OF_MONTH, 15);
      String reqDate = sim.format(cal.getTime());
      System.out.println(reqDate);
	}

}
