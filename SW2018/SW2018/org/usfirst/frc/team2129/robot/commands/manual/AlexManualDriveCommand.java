package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AlexManualDriveCommand extends Command {
	
	public AlexManualDriveCommand() {
		requires(Robot.s_DriveSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void execute() {
		double leftStickY = OI.leftStick.getY();
		double rightStickY = OI.rightStick.getY();
		double leftStickX = OI.leftStick.getX();
		double rightStickX = OI.rightStick.getX();
		
		double frontLeft = leftStickY;
		double backLeft = leftStickY;
		double frontRight = rightStickY;
		double backRight = rightStickY;
		
		double x;
		if(Math.abs(leftStickX)>Math.abs(rightStickX)) x = leftStickX;
		else x = rightStickX;
		
		frontLeft -= x;//leftStickX;
		backLeft  += x;//leftStickX;
		
		frontRight += x;//rightStickX;
		backRight  -= x;//rightStickX;
		
		double scale = (OI.leftStick.getRawAxis(2)+1)/2;
		frontLeft*=scale;
		frontRight*=scale;
		backLeft*=scale;
		backRight*=scale;
		
		Robot.s_DriveSubsystem.rawDrive(frontLeft, backLeft, frontRight, backRight);
	}

}
