package com.shopperStack.genericUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	
	public int randomNumber() {
		Random r=new Random();
		int value=r.nextInt(1000);
		return value;
	}
	
	public String localDate() {
		String date=LocalDate.now().toString().replace("-","");
		return date;
	}
	
	public String localDateTime() {
		String dateTime=LocalDateTime.now().toString().replace("-","").replace(".","").replace(":","");
		return dateTime;
	}

}
