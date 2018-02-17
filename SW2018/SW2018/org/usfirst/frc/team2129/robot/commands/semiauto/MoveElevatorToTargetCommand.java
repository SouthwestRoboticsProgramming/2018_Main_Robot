package org.usfirst.frc.team2129.robot.commands.semiauto;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveElevatorToTargetCommand extends PIDCommand {
	
	double target;
	
	public MoveElevatorToTargetCommand(double target) {
		super(0, 0, 0);
		requires(Robot.s_LifterSubsystem);
		this.getPIDController().setContinuous(false);
		this.target=target;
		this.setSetpoint(this.target);
	}
	
	protected void execute() {
		this.getPIDController().setPID(
				Preferences.getInstance().getDouble("lifter_p", 0.1),
				Preferences.getInstance().getDouble("lifter_i", 0.001),
				Preferences.getInstance().getDouble("lifter_d", 0)
		);
		this.getPIDController().setOutputRange(
				(-Preferences.getInstance().getDouble("lifter_output_clamp", 0.5))-0.1,
				 Preferences.getInstance().getDouble("lifter_output_clamp", 0.5)+0.1
		);
		this.getPIDController().setInputRange(
				Preferences.getInstance().getDouble("lifter_in_min", 0),
				Preferences.getInstance().getDouble("lifter_in_max", 300)
		);
		
		SmartDashboard.putNumber("lifter_pid_distance", this.getPIDController().getError());
		
		if(OI.lifterStick.getRawButton(2)) this.setSetpointRelative(OI.lifterStick.getY()*3);
		SmartDashboard.putNumber("lifter_pid_target", this.getPIDController().getSetpoint());
		
		Robot.s_LifterSubsystem.setGrabber(OI.lifterStick.getRawButton(1));
	}

	@Override
	protected double returnPIDInput() {
		Robot.s_LifterSubsystem.lidar.poll();
		return Robot.s_LifterSubsystem.lidar.getRawDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		double hold = Preferences.getInstance().getDouble("lifter_pid_hold", 0.15);
		if(this.returnPIDInput()>Preferences.getInstance().getDouble("lifter_height_cap", 173)) {
			output=Math.min(output, hold);
		}
		if(Math.abs(this.getPIDController().getError())>Preferences.getInstance().getDouble("lifter_pid_error", 2)) {
			Robot.s_LifterSubsystem.setLiferRaw(output+hold);
			SmartDashboard.putNumber("lifter_pid_output", output+hold);
		}else {
			Robot.s_LifterSubsystem.setLiferRaw(hold);
			SmartDashboard.putNumber("lifter_pid_output", hold);
		}
	}

	@Override
	protected boolean isFinished() {
		return OI.lifterStick.getRawButton(4);
	}
}
