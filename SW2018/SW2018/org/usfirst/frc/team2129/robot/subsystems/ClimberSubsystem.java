package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMapAware;
import org.usfirst.frc.team2129.robot.commands.manual.ManualClimberCommand;
import org.usfirst.frc.team2129.util.encoderdesc.iencoder.IEncoder;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem implements RobotMapAware {
	private IEncoder climberEncoder = getClimberEncoder().get();
	private SpeedController climberMotor = getClimberMotor().get();

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualClimberCommand());
	}

	public void setLifter(double speed) {
		climberMotor.set(speed);
	}
}
