package org.usfirst.frc.team2129.robot.commands.semiauto;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.PreferenceAware;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUpCommand extends Command implements PreferenceAware {

	public ElevatorUpCommand() {
		requires(Robot.s_IntakeSubsystem);
		requires(Robot.s_LifterSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void execute() {
		double armSpeed = getPreferenceDouble("intake_arm_speed", 0.5);
		if (Robot.s_LifterSubsystem.lidar.getRawDistance() < 70)
			Robot.s_IntakeSubsystem.setArmsRaw(-armSpeed, -armSpeed);
		else
			Robot.s_IntakeSubsystem.setArmsRaw(0, 0);
		Robot.s_IntakeSubsystem.setGrabber(OI.eitherStickButton(1));
		Robot.s_LifterSubsystem.setLiferRaw(1);
		Robot.s_LifterSubsystem.lidar.poll();
	}

	protected void end() {
		Robot.s_LifterSubsystem.setLiferRaw(0);
	}
}
