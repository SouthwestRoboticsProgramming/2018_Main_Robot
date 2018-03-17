/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.util.encoderdesc.IEncoderDescriptor;
import org.usfirst.frc.team2129.util.encoderdesc.QuadratureEncoderDescriptor;
import org.usfirst.frc.team2129.util.motordesc.CANMotorDescriptor;
import org.usfirst.frc.team2129.util.motordesc.MotorDescriptor;
import org.usfirst.frc.team2129.util.motordesc.PWMMotorDescriptor;

import edu.wpi.first.wpilibj.Compressor;

public class RobotMap implements IRobotMap {
	private MotorDescriptor frontLeft        = new CANMotorDescriptor(10);
	private MotorDescriptor frontRight       = new CANMotorDescriptor(12, true);
	private MotorDescriptor backLeft         = new CANMotorDescriptor(11);
	private MotorDescriptor backRight        = new CANMotorDescriptor(13, true);
	
	private MotorDescriptor lifterMotor      = new CANMotorDescriptor(20);
	
	private MotorDescriptor leftIntakeMotor  = new PWMMotorDescriptor(8);
	private MotorDescriptor rightIntakeMotor = new PWMMotorDescriptor(9);
	
	private MotorDescriptor leftArmMotor     = new PWMMotorDescriptor(7, true);
	private MotorDescriptor rightArmMotor    = new PWMMotorDescriptor(6);
	
	private MotorDescriptor climberMotor     = new PWMMotorDescriptor(5);
	
	private IEncoderDescriptor climberEncoder= new QuadratureEncoderDescriptor(0, 1);
	
	private int lowerLimitSwitch             = 2; //PWM
	private int upperLimitSwitch             = 3; //PWM
	
	private int grabberSolenoid              = 7; //PCM
	
	private static RobotMap CurrentRobotMap = new RobotMap();
	
	static {
//		new Compressor(0).setClosedLoopControl(true);
	}

	public static IRobotMap getCurrent() {
		return CurrentRobotMap;
	}
	
	public MotorDescriptor getFrontLeft() {
		return frontLeft;
	}

	public MotorDescriptor getFrontRight() {
		return frontRight;
	}

	public MotorDescriptor getBackLeft() {
		return backLeft;
	}

	public MotorDescriptor getBackRight() {
		return backRight;
	}

	public MotorDescriptor getLifterMotor() {
		return lifterMotor;
	}

	public MotorDescriptor getLeftIntakeMotor() {
		return leftIntakeMotor;
	}

	public MotorDescriptor getRightIntakeMotor() {
		return rightIntakeMotor;
	}

	public MotorDescriptor getLeftArmMotor() {
		return leftArmMotor;
	}

	public MotorDescriptor getRightArmMotor() {
		return rightArmMotor;
	}

	public MotorDescriptor getClimberMotor() {
		return climberMotor;
	}

	public IEncoderDescriptor getClimberEncoder() {
		return climberEncoder;
	}

	public int getLowerLimitSwitch() {
		return lowerLimitSwitch;
	}

	public int getUpperLimitSwitch() {
		return upperLimitSwitch;
	}

	public int getGrabberSolenoid() {
		return grabberSolenoid;
	}

	public static IRobotMap getCurrentRobotMap() {
		return CurrentRobotMap;
	}
	
}
