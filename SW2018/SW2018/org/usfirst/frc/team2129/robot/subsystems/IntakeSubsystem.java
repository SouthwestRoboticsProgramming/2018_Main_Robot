package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMapAware;
import org.usfirst.frc.team2129.robot.commands.manual.ManualIntakeCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem implements RobotMapAware {	
	private SpeedController leftIntake = getLeftIntakeMotor().get();
	private SpeedController rightIntake = getRightIntakeMotor().get();
	
	private SpeedController leftArm = getLeftArmMotor().get();
	private SpeedController rightArm = getRightArmMotor().get();
	
	private Solenoid        grabberPiston = new Solenoid(getGrabberSolenoid());

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
