/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.robot.commands.auto.JustDriveForwardCommand;
import org.usfirst.frc.team2129.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.LifterSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveSubsystem s_DriveSubsystem   = new DriveSubsystem();
	public static final LifterSubsystem s_LifterSubsystem = null; //new LifterSubsystem();
	public static final IntakeSubsystem s_IntakeSubsystem = null; //new IntakeSubsystem();
	public static final ClimberSubsystem s_ClimberSubsystem = null; //new ClimberSubsystem();
	public static final LightsSubsystem s_LightsSubsystem = null; //new LightsSubsystem();
	public static Command autoCommand;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String ourSide = Preferences.getInstance().getString("auto_side", "");
		String m = DriverStation.getInstance().getGameSpecificMessage();
		autoCommand = new JustDriveForwardCommand(ourSide);
//		if(m.length()>0 && ourSide.length()>0) {
//			if(m.charAt(0)==ourSide.charAt(0)) autoCommand = new AutoMasterCommand(ourSide);
//		}		
		autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		if(!autoCommand.isRunning()) autoCommand.start();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if(autoCommand!=null) autoCommand.cancel();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		if(autoCommand!=null) autoCommand.cancel();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
