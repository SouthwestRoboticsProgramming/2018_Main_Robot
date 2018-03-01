package org.usfirst.frc.team2129.robot.commands.auto;

import org.usfirst.frc.team2129.robot.commands.semiauto.MoveElevatorToTargetCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMasterCommand extends CommandGroup {
	public AutoMasterCommand(String ourSide) {
		this.addSequential(new AutoSetClampCommand(false), 0.2);
		this.addSequential(new MoveElevatorToTargetCommand(72), 5);
		this.addSequential(new AutoDriveCommand(0, -0.3), 5);
		this.addSequential(new AutoSetClampCommand(true), 0.2);
		this.addSequential(new AutoDriveCommand((ourSide=="R")?-0.15:0.15, -0.25));
	}
}
