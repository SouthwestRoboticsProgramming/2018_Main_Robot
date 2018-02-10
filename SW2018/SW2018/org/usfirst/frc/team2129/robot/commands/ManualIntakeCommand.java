package org.usfirst.frc.team2129.robot.commands;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualIntakeCommand extends Command {

	public ManualIntakeCommand() {
		requires(Robot.s_IntakeSubsystem);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void execute() {
		if(OI.translateStick.getRawButton(1)) Robot.s_IntakeSubsystem.setIntakesRaw(1);
		else if(OI.translateStick.getRawButton(2)) Robot.s_IntakeSubsystem.setIntakesRaw(-1);
		else Robot.s_IntakeSubsystem.setIntakesRaw(0);
	}

}
