package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.PreferenceAware;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualIntakeCommand extends Command implements PreferenceAware {

	public ManualIntakeCommand() {
		requires(Robot.s_IntakeSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void execute() {
		// if(OI.rightStick.getRawButton(2)) Robot.s_IntakeSubsystem.setIntakesRaw(1,
		// 1);
		// else if(OI.rightStick.getRawButton(3))
		// Robot.s_IntakeSubsystem.setIntakesRaw(-1, -1);
		// else if(OI.rightStick.getRawButton(4))
		// Robot.s_IntakeSubsystem.setIntakesRaw(-1, 1);
		// else if(OI.rightStick.getRawButton(5))
		// Robot.s_IntakeSubsystem.setIntakesRaw(1, -1);
		// else Robot.s_IntakeSubsystem.setIntakesRaw(0, 0);
		//
		//
		// double leftspeed = Preferences.getInstance().getDouble("intake_arm_speed_l",
		// 0.05);
		// double rightspeed = Preferences.getInstance().getDouble("intake_arm_speed_r",
		// 0.05);
		// double rdir;
		// double ldir = rdir = 0;
		// if(OI.leftStick.getRawButton(2)) ldir=rdir=1;
		// else if (OI.leftStick.getRawButton(3)) ldir=rdir = -1;
		// else if (OI.leftStick.getRawButton(4)) {ldir=1;rdir=-1;}
		// else if (OI.leftStick.getRawButton(5)) {ldir=-1;rdir=1;}
		// Robot.s_IntakeSubsystem.setArmsRaw(leftspeed*ldir, rightspeed*rdir);

		double armSpeed = getPreferenceDouble("intake_arm_speed", 0.5);
		if (OI.leftStick.getRawButton(4)) {
			Robot.s_IntakeSubsystem.setArmsRaw(-armSpeed, -armSpeed);
			Robot.s_IntakeSubsystem.setIntakesRaw(-1, 1);
			Robot.s_IntakeSubsystem.setGrabber(OI.eitherStickButton(1));
		} else if (OI.leftStick.getRawButton(5)) {
			Robot.s_IntakeSubsystem.setArmsRaw(armSpeed, armSpeed);
			Robot.s_IntakeSubsystem.setIntakesRaw(-1, 1);
			Robot.s_IntakeSubsystem.setGrabber(true);
		} else {
			if (OI.rightStick.getRawButton(3))
				Robot.s_IntakeSubsystem.setArmsRaw(-armSpeed, -armSpeed);
			else if (OI.rightStick.getRawButton(2))
				Robot.s_IntakeSubsystem.setArmsRaw(armSpeed, armSpeed);
			else
				Robot.s_IntakeSubsystem.setArmsRaw(0, 0);

			if (OI.rightStick.getRawButton(4))
				Robot.s_IntakeSubsystem.setIntakesRaw(1, 1);
			else if (OI.rightStick.getRawButton(5))
				Robot.s_IntakeSubsystem.setIntakesRaw(-1, -1);
			else
				Robot.s_IntakeSubsystem.setIntakesRaw(0, 0);

			Robot.s_IntakeSubsystem.setGrabber(OI.eitherStickButton(1));
		}
	}

}
