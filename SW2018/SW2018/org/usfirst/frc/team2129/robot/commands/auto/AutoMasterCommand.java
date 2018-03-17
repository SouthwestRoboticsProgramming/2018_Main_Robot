package org.usfirst.frc.team2129.robot.commands.auto;

import org.usfirst.frc.team2129.robot.commands.semiauto.MoveElevatorToTargetCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMasterCommand extends CommandGroup {
	public AutoMasterCommand(String ourSide) {
		addSequential(new AutoSetClampCommand(false), 0.2);
		addSequential(new MoveElevatorToTargetCommand(72), 5);
		addSequential(new AutoDriveCommand(0, -0.3), 5);
		addSequential(new AutoSetClampCommand(true), 0.2);
		addSequential(new AutoDriveCommand((ourSide=="R")?-0.15:0.15, -0.25));
	}
}
