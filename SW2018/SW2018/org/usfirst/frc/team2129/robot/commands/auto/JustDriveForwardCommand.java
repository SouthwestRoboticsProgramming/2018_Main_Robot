package org.usfirst.frc.team2129.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

// This thing drives forward at an angle .. the angle determined by the side,
// which is set using the drivers station "auto_side" prop .. R(ight) or L(eft)
// TODO: how about we keep the drivers preferences in one spot??

public class JustDriveForwardCommand extends CommandGroup {
	public JustDriveForwardCommand(String side) {
		double speedX = (side == "R") ? -0.3 : 0.3;
		double speedY = -0.25;
		addSequential(new AutoDriveCommand(speedX, speedY), 5);
	}
}
