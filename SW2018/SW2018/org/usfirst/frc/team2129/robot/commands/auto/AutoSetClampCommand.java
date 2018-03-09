package org.usfirst.frc.team2129.robot.commands.auto;

import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSetClampCommand extends Command {
	private boolean toSetTo; // grabber on or off

	public AutoSetClampCommand(boolean s) {
		toSetTo = s;
		requires(Robot.s_IntakeSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	public void execute() {
		Robot.s_IntakeSubsystem.setGrabber(toSetTo);
	}
}