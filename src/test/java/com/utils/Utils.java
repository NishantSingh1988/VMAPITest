package com.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {
	
	public static String getUUID() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(cal.getTime());
		
	}
}
