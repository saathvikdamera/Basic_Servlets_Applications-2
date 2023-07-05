package com.Damera.advjava;

import java.time.LocalTime;

public class Time {

	public static void main(String[] args) {
		
		LocalTime localTime = LocalTime.now();
		
		String s = String.valueOf(localTime);
		String substring = s.substring(0, 2);
		int i = Integer.parseInt(substring);
		System.out.println(i);
	}

}
