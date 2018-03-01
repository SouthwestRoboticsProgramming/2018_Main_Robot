package org.usfirst.frc.team2129.robot.commands.auto;

import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSetClampCommand extends Command {
	
	boolean toSetTo;
	
	public AutoSetClampCommand(boolean s) {
		toSetTo = s;
		requires(Robot.s_IntakeSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		Robot.s_IntakeSubsystem.setGrabber(toSetTo);
	}

}
