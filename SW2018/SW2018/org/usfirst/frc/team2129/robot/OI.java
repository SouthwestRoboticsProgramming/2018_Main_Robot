/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.robot.commands.manual.AlexManualDriveCommand;
import org.usfirst.frc.team2129.robot.commands.manual.ManualDriveCommand;
import org.usfirst.frc.team2129.robot.commands.semiauto.ElevatorDownCommand;
import org.usfirst.frc.team2129.robot.commands.semiauto.ElevatorUpCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static GenericHID leftStick = new Joystick(0);
	public static GenericHID rightStick    = new Joystick(1);
	public static GenericHID lifterStick    = new Joystick(2);
	
	static {		
		new JoystickButton(leftStick, 8).whenPressed(new ManualDriveCommand());
		new JoystickButton(leftStick, 9).whenPressed(new AlexManualDriveCommand());
		new JoystickButton(leftStick, 3).whileHeld(new ElevatorUpCommand());
		new JoystickButton(leftStick, 2).whileHeld(new ElevatorDownCommand());
		
		new Compressor(0).setClosedLoopControl(true);
	}
	
	public static boolean eitherStickButton(int b) {
		return leftStick.getRawButton(b) || rightStick.getRawButton(b);
	}
}