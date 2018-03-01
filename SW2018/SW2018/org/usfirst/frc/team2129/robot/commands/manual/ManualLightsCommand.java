package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualLightsCommand extends Command {
	
	public ManualLightsCommand() {
		requires(Robot.s_LightsSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		Robot.s_LightsSubsystem.setPWM((OI.lifterStick.getY()+1)/2);
	}

}
