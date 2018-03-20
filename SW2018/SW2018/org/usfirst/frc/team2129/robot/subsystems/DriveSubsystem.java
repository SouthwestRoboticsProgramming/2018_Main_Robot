/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.Logger;
import org.usfirst.frc.team2129.robot.RobotMapAware;
import org.usfirst.frc.team2129.robot.commands.manual.AlexManualDriveCommand;
import org.usfirst.frc.team2129.util.pwm3901.PWM3901;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
@SuppressWarnings("deprecation")
public class DriveSubsystem extends Subsystem implements RobotMapAware, Logger {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.4
	
	SpeedController frontLeft  = getFrontLeft().get();
	SpeedController backLeft   = getBackLeft().get();
	SpeedController frontRight = getFrontRight().get();
	SpeedController backRight  = getBackRight().get();
	private MecanumDrive      drive      = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
	public PWM3901 flowSensor = new PWM3901(SPI.Port.kOnboardCS3);
//	private RobotDrive      drive      = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	public void initDefaultCommand() {
		drive.setSafetyEnabled(false);
		// Set the default command for a subsystem here.
		 setDefaultCommand(new AlexManualDriveCommand());
//		 setDefaultCommand(new ManualDriveCommand());
	}
	
	public void stdMecanumDrive(double xSpeed, double ySpeed, double zRotation) {
//		log("DRIVE xSpeed = " + xSpeed + "  ySpeed = " + ySpeed + "  zRotation" + zRotation);
		drive.driveCartesian(-ySpeed, xSpeed, zRotation);
	}
	
	public void rawDrive(double frontleft, double backleft, double frontright, double backright) {
//		log("DRIVE frontleft = " + frontleft + "  Backleft = " + backleft + "  FrontRight" + frontright + "    BackRight: " + backright);
		
		frontLeft.set(frontleft);
		frontRight.set(frontright);
		backLeft.set(backleft);
		backRight.set(backright);
	}
}
