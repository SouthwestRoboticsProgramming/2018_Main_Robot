package org.usfirst.frc.team2129.robot.commands.manual;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualClimberCommand extends Command {
	
	public ManualClimberCommand() {
		requires(Robot.s_ClimberSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void execute() {
		SmartDashboard.putNumber("climber_enc_pos", Robot.s_ClimberSubsystem.climberEncoder.getDistance());
		Robot.s_ClimberSubsystem.setLifter(OI.rightStick.getRawAxis(2));
	}

}
