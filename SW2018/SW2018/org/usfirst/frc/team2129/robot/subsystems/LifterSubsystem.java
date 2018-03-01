package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.manual.ManualLifterCommand;
import org.usfirst.frc.team2129.util.tfmini.TFMini;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LifterSubsystem extends Subsystem {
	
	SpeedController lifterMotor   = RobotMap.lifterMotor.get();
	
	DigitalInput    lowerLimit    = new DigitalInput(RobotMap.lowerLimitSwitch);
	DigitalInput    upperLimit    = new DigitalInput(RobotMap.upperLimitSwitch);
	public TFMini   lidar         = new TFMini(SerialPort.Port.kMXP);
	
	
	public LifterSubsystem() {
		lidar.setDebugMode(true);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
//		setDefaultCommand(new ManualLifterCommand());
	}
	
	public void setLiferRaw(double v) {
		if(getUpperLimit()) v = Math.min(v, 0.05);
		if(getLowerLimit()) v = Math.max(v,  0);
		lifterMotor.set(v);
		
		SmartDashboard.putNumber("lifter_actual_drive", v);
		SmartDashboard.putBoolean("lifter_actual_high_limit", getUpperLimit());
		SmartDashboard.putBoolean("lifter_actual_low_limit",  getLowerLimit());
	}
	
	
	
	public boolean getLowerLimit() {
		return lowerLimit.get();
	}
	
	public boolean getUpperLimit() {
		return upperLimit.get();
	}
}
