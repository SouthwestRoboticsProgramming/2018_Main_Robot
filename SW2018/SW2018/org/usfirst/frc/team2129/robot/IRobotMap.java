package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.util.encoderdesc.IEncoderDescriptor;
import org.usfirst.frc.team2129.util.motordesc.MotorDescriptor;

public interface IRobotMap {

	MotorDescriptor getFrontLeft();

	MotorDescriptor getFrontRight();

	MotorDescriptor getBackLeft();

	MotorDescriptor getBackRight();

	MotorDescriptor getLifterMotor();

	MotorDescriptor getLeftIntakeMotor();

	MotorDescriptor getRightIntakeMotor();

	MotorDescriptor getLeftArmMotor();

	MotorDescriptor getRightArmMotor();

	MotorDescriptor getClimberMotor();

	IEncoderDescriptor getClimberEncoder();

	int getLowerLimitSwitch();

	int getUpperLimitSwitch();

	int getGrabberSolenoid();
}