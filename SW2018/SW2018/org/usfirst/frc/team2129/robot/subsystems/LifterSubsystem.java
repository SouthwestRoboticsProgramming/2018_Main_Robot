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
	Solenoid        grabberPiston = new Solenoid(RobotMap.grabberSolenoid);
	DigitalInput    lowerLimit    = new DigitalInput(RobotMap.lowerLimitSwitch);
	public TFMini   lidar         = new TFMini(SerialPort.Port.kMXP);
	
	
	public LifterSubsystem() {
		lidar.setDebugMode(true);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ManualLifterCommand());
	}
	
	public void setLiferRaw(double v) {
		lifterMotor.set(v);
	}
	
	public void setGrabber(boolean v) {
		grabberPiston.set(v);
	}
	
	public boolean getLowerLimit() {
		
		return lowerLimit.get();
	}
}
