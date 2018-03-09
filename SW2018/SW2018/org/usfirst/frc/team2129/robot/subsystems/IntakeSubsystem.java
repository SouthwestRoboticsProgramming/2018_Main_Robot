package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.manual.ManualIntakeCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {	
	private SpeedController leftIntake = RobotMap.leftIntakeMotor.get();
	private SpeedController rightIntake = RobotMap.rightIntakeMotor.get();
	
	private SpeedController leftArm = RobotMap.leftArmMotor.get();
	private SpeedController rightArm = RobotMap.rightArmMotor.get();
	
	private Solenoid        grabberPiston = new Solenoid(RobotMap.grabberSolenoid);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualIntakeCommand());
	}

	public void setIntakesRaw(double leftSpeed, double rightSpeed) {
		leftIntake.set(leftSpeed);
		rightIntake.set(rightSpeed);
	}
	
	public void setArmsRaw(double leftSpeed, double rightSpeed) {
		leftArm.set(leftSpeed);
		rightArm.set(rightSpeed);
	}
	
	public void setGrabber(boolean onOrOff) {
		grabberPiston.set(onOrOff);
	}

}
