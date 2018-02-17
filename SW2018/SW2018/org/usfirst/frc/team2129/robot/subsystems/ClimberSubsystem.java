package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.manual.ManualClimberCommand;
import org.usfirst.frc.team2129.util.encoderdesc.iencoder.IEncoder;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {
	
	public IEncoder climberEncoder = RobotMap.climberEncoder.get();
	SpeedController climberMotor   = RobotMap.climberMotor.get();

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualClimberCommand());
	}
	
	public void setLifter(double v) {climberMotor.set(v);}

}
