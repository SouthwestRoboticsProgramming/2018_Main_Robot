/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.util.motordesc.CANMotorDescriptor;
import org.usfirst.frc.team2129.util.motordesc.MotorDescriptor;
import org.usfirst.frc.team2129.util.motordesc.PWMMotorDescriptor;

import edu.wpi.first.wpilibj.Compressor;

public class RobotMap {
	public static MotorDescriptor frontLeft        = new CANMotorDescriptor(10);
	public static MotorDescriptor frontRight       = new CANMotorDescriptor(12, true);
	public static MotorDescriptor backLeft         = new CANMotorDescriptor(11);
	public static MotorDescriptor backRight        = new CANMotorDescriptor(13, true);
	
	public static MotorDescriptor lifterMotor      = new CANMotorDescriptor(20);
	
	public static MotorDescriptor leftIntakeMotor  = new PWMMotorDescriptor(0, true);
	public static MotorDescriptor rightIntakeMotor = new PWMMotorDescriptor(1, true);
	
	public static int grabberSolenoid              = 7;
	
	static {
		new Compressor(0).setClosedLoopControl(true);
	}
}
