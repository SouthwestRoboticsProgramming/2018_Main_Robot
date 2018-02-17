package org.usfirst.frc.team2129.robot.commands.semiauto;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevatorToBottomCommand extends Command {
	public MoveElevatorToBottomCommand() {
		requires(Robot.s_LifterSubsystem);
	}
	
	protected void execute() {
		Robot.s_LifterSubsystem.setLiferRaw(-Preferences.getInstance().getDouble("lifter_drivedown", 0.5));
		Robot.s_LifterSubsystem.setGrabber(OI.lifterStick.getRawButton(1));
	}
	
	protected void end() {
		Robot.s_LifterSubsystem.setLiferRaw(0);
	}
	
	protected boolean isFinished() {
		return Robot.s_LifterSubsystem.getLowerLimit();
	}

}
