package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.commands.manual.ManualLightsCommand;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightsSubsystem extends Subsystem {
	
	PWM light = new PWM(4);
	
	public LightsSubsystem() {
		light.setBounds(100, 51, 50, 49, 0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ManualLightsCommand());
	}
	
	public void setPWM(double v) {
		light.setBounds(Preferences.getInstance().getDouble("lightpwm_max", 50),
				Preferences.getInstance().getDouble("lightpwm_db_max", 26),
				Preferences.getInstance().getDouble("lightpwm_db_center", 25),
				Preferences.getInstance().getDouble("lightpwm_db_min", 24),
				Preferences.getInstance().getDouble("lightpwm_min", 0));
	
		int m = Preferences.getInstance().getInt("lightpwm_multiplier", 1);
		if(m==1) light.setPeriodMultiplier(PWM.PeriodMultiplier.k1X);
		if(m==2) light.setPeriodMultiplier(PWM.PeriodMultiplier.k2X);
		if(m==4) light.setPeriodMultiplier(PWM.PeriodMultiplier.k4X);
		
		int s = Preferences.getInstance().getInt("light_manual", -1);
		if(s==-1) s = (int) (v*2000);
		
		light.setRaw(s);
		SmartDashboard.putNumber("lightpwm_speed", light.getSpeed());
		SmartDashboard.putNumber("lightpwm_speed_raw", light.getRaw());
		SmartDashboard.putNumber("lightpwm_speed_req", v);
	}

}
