/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.manual.AlexManualDriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
@SuppressWarnings("deprecation")
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.4
	
	SpeedController frontLeft  = RobotMap.frontLeft.get();
	SpeedController backLeft   = RobotMap.backLeft.get();
	SpeedController frontRight = RobotMap.frontRight.get();
	SpeedController backRight  = RobotMap.backRight.get();
	private RobotDrive      drive      = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	public void initDefaultCommand() {
		drive.setSafetyEnabled(false);
		// Set the default command for a subsystem here.
		 setDefaultCommand(new AlexManualDriveCommand());
	}
	
	public void stdMecanumDrive(double x, double y, double t) {
		drive.mecanumDrive_Cartesian(x, -y, t, 0);
	}
	
	public void rawDrive(double frontleft, double backleft, double frontright, double backright) {
		frontLeft.set(frontleft);
		frontRight.set(frontright);
		backLeft.set(backleft);
		backRight.set(backright);
	}
}
