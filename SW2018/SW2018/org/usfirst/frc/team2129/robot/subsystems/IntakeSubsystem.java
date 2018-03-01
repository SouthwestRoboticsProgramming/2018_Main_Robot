package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.manual.ManualIntakeCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	SpeedController leftIntake = RobotMap.leftIntakeMotor.get();
	SpeedController rightIntake = RobotMap.rightIntakeMotor.get();
	
	SpeedController leftArm = RobotMap.leftArmMotor.get();
	SpeedController rightArm = RobotMap.rightArmMotor.get();
	
	Solenoid        grabberPiston = new Solenoid(RobotMap.grabberSolenoid);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ManualIntakeCommand());
	}

	public void setIntakesRaw(double v, double v2) {
		leftIntake.set(v);
		rightIntake.set(v2);
	}
	
	public void setArmsRaw(double d, double d2) {
		leftArm.set(d);
		rightArm.set(d2);
	}
	
	public void setGrabber(boolean v) {
		grabberPiston.set(v);
	}

}
