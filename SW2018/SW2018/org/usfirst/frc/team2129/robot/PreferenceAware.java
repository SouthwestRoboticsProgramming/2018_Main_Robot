package org.usfirst.frc.team2129.robot;

import edu.wpi.first.wpilibj.Preferences;

public interface PreferenceAware {

	default Preferences getPreferences() {
		return Preferences.getInstance();
	}
	
	default double getPreferenceDouble(String preferenceName, double defaultVal) {
		return getPreferences().getDouble(preferenceName, defaultVal);
	}
	
	default int getPreferenceInt(String preferenceName, int defaultVal) {
		return getPreferences().getInt(preferenceName, defaultVal);
	}

}
