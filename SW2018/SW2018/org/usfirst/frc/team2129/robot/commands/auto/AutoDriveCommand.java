package org.usfirst.frc.team2129.robot.commands.auto;

import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveCommand extends Command {
	
	double speedx;
	double speedy;

	public AutoDriveCommand(double x, double y) {
		requires(Robot.s_DriveSubsystem);
		speedx=x;
		speedy=y;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		Robot.s_DriveSubsystem.stdMecanumDrive(speedx, speedy, 0);
	}
	
	public void end() {
		Robot.s_DriveSubsystem.rawDrive(0, 0, 0, 0);
	}

}
