package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualLifterCommand extends Command {

	public ManualLifterCommand() {
		requires(Robot.s_LifterSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	public void execute() {
		if (OI.eitherStickButton(3))
			Robot.s_LifterSubsystem.setLiferRaw(1);
		else if (OI.eitherStickButton(2))
			Robot.s_LifterSubsystem.setLiferRaw(-1);
		else
			Robot.s_LifterSubsystem.setLiferRaw(0);
		Robot.s_LifterSubsystem.lidar.poll();
	}
}