package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.Logger;
import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AlexManualDriveCommand extends Command implements Logger {

	public AlexManualDriveCommand() {
		requires(Robot.s_DriveSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void execute() {

//		Robot.s_DriveSubsystem.stdMecanumDrive(-OI.leftStick.getX(), OI.leftStick.getY(), -OI.rightStick
//				.getX()/2);
		
		try {
			double leftStickY = OI.leftStick.getY();
			double rightStickY = OI.rightStick.getY();
			double leftStickX = OI.leftStick.getX();
			double rightStickX = OI.rightStick.getX();

//			log("leftSticky = " + leftStickY);
//			log("rightStickY = " + rightStickY);
//			log("leftStickX = " + leftStickX);
//			log("rightStickX = " + rightStickX);

			double frontLeft = leftStickY;
			double backLeft = leftStickY;
			double frontRight = rightStickY;
			double backRight = rightStickY;

			double x;
			if (Math.abs(leftStickX) > Math.abs(rightStickX))
				x = leftStickX;
			else
				x = rightStickX;
			
			x *= -1;

			frontLeft -= x;// leftStickX;
			backLeft += x;// leftStickX;

			frontRight += x;// rightStickX;
			backRight -= x;// rightStickX;

//			double scale = 1.0; //(OI.leftStick.getRawAxis(2) + 1) / 2;
//			frontLeft *= scale;
//			frontRight *= scale;
//			backLeft *= scale;
//			backRight *= scale;

			Robot.s_DriveSubsystem.rawDrive(frontLeft, backLeft, frontRight, backRight);
		} catch (Exception ex) {
			log("Exception in AlexDrive: ", ex);
		}
	}

}
