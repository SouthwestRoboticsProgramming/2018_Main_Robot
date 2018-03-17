package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.util.encoderdesc.IEncoderDescriptor;
import org.usfirst.frc.team2129.util.motordesc.MotorDescriptor;

public interface RobotMapAware {

	// Use whatever robotMap you want
	default IRobotMap getRobotMap() {
		return R2RobotMap.getCurrent();
//		return RobotMap.getCurrent();
	}

	// --------------- DRIVE MOTORS --------------- 
	
	default MotorDescriptor getFrontLeft() {
		return getRobotMap().getFrontLeft();
	}

	default MotorDescriptor getFrontRight() {
		return getRobotMap().getFrontRight();
	}

	default MotorDescriptor getBackLeft() {
		return getRobotMap().getBackLeft();
	}

	default MotorDescriptor getBackRight() {
		return getRobotMap().getBackRight();
	}

	// --------------- LIFTERt MOTORS --------------- 

	default MotorDescriptor getLifterMotor() {
		return getRobotMap().getLifterMotor();
	}

	// --------------- INTAKE MOTORS --------------- 
	
	default MotorDescriptor getLeftIntakeMotor() {
		return getRobotMap().getLeftIntakeMotor();
	}

	default MotorDescriptor getRightIntakeMotor() {
		return getRobotMap().getRightIntakeMotor();
	}

	default MotorDescriptor getLeftArmMotor() {
		return getRobotMap().getLeftArmMotor();
	}

	default MotorDescriptor getRightArmMotor() {
		return getRobotMap().getRightArmMotor();
	}

	// --------------- CLIMBER MOTORS --------------- 
	
	default MotorDescriptor getClimberMotor() {
		return getRobotMap().getClimberMotor();
	}

	default IEncoderDescriptor getClimberEncoder() {
		return getRobotMap().getClimberEncoder();
	}

	default int getLowerLimitSwitch() {
		return getRobotMap().getLowerLimitSwitch();
	}

	default int getUpperLimitSwitch() {
		return getRobotMap().getUpperLimitSwitch();
	}

	default int getGrabberSolenoid() {
		return getRobotMap().getGrabberSolenoid();
	}
}
