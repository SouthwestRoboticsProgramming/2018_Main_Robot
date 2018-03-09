package org.usfirst.frc.team2129.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public interface DashboardAware {

	default void setSmartDashboard(String keyName, boolean value) {
		SmartDashboard.putBoolean(keyName, value);
	}

	default void setSmartDashboard(String keyName, String value) {
		SmartDashboard.putString(keyName, value);
	}

	default void setSmartDashboard(String keyName, double value) {
		SmartDashboard.putNumber(keyName, value);
	}

	default void setSmartDashboard(String keyName, SendableChooser<?> value) {
		SmartDashboard.putData(keyName, value);
	}
}
