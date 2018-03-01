package org.usfirst.frc.team2129.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class JustDriveForwardCommand extends CommandGroup {
	public JustDriveForwardCommand(String side) {
		this.addSequential(new AutoDriveCommand((side=="R")?-0.3:0.3, -0.25), 5);
	}
}
