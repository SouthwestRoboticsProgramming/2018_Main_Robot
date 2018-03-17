package org.usfirst.frc.team2129.robot;

public interface Logger {

	default void log(String aString) {
		System.out.println("Out: " + aString);
	}

	default void log(String aString, Exception ex) {
		log(aString + ex.getMessage());
		ex.printStackTrace();
	}

}
