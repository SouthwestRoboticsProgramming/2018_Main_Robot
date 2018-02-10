package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.ManualIntakeCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	
	SpeedController leftIntake = RobotMap.leftIntakeMotor.get();
	SpeedController rightIntake = RobotMap.rightIntakeMotor.get();

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ManualIntakeCommand());
	}

	public void setIntakesRaw(int v) {
		leftIntake.set(v);
		rightIntake.set(v);
	}

}
