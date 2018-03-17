package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.DashboardAware;
import org.usfirst.frc.team2129.robot.PreferenceAware;
import org.usfirst.frc.team2129.robot.commands.manual.ManualLightsCommand;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LightsSubsystem extends Subsystem implements PreferenceAware, DashboardAware {
	
	PWM light = new PWM(4);
	
	public LightsSubsystem() {
		light.setBounds(100, 51, 50, 49, 0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualLightsCommand());
	}
	
	public void setPWM(double v) {
		light.setBounds(getPreferenceDouble("lightpwm_max", 50),
				getPreferenceDouble("lightpwm_db_max", 26),
				getPreferenceDouble("lightpwm_db_center", 25),
				getPreferenceDouble("lightpwm_db_min", 24),
				getPreferenceDouble("lightpwm_min", 0));
	
		int m = getPreferenceInt("lightpwm_multiplier", 1);
		if(m==1) light.setPeriodMultiplier(PWM.PeriodMultiplier.k1X);
		if(m==2) light.setPeriodMultiplier(PWM.PeriodMultiplier.k2X);
		if(m==4) light.setPeriodMultiplier(PWM.PeriodMultiplier.k4X);
		
		int s = Preferences.getInstance().getInt("light_manual", -1);
		if(s==-1) s = (int) (v*2000);
		
		light.setRaw(s);
		setSmartDashboard("lightpwm_speed", light.getSpeed());
		setSmartDashboard("lightpwm_speed_raw", light.getRaw());
		setSmartDashboard("lightpwm_speed_req", v);
	}

}
