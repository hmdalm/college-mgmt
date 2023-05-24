package com.utility;

import java.time.Instant;

public class CollegeUtil {
	public static int getID() {
		long currentTimestamp = Instant.now().toEpochMilli();
		return (int) currentTimestamp;
		
		
	}
	public static String getRollno(int Student_id) {
		
		String roll="Roll_";
		
	return	roll+Student_id;
		
		
		
		
		
	}

}
