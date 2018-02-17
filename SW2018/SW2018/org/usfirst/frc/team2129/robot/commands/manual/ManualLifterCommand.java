package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualLifterCommand extends Command {
	
	public ManualLifterCommand() {
		requires(Robot.s_LifterSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		Robot.s_LifterSubsystem.setLiferRaw(OI.lifterStick.getY());
		Robot.s_LifterSubsystem.setGrabber(OI.lifterStick.getRawButton(1));
		SmartDashboard.putBoolean("lifter_lowerlimit", Robot.s_LifterSubsystem.getLowerLimit());
		
		Robot.s_LifterSubsystem.lidar.poll();
		
	}

}