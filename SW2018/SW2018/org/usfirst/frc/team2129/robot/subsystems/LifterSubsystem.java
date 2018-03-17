package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.DashboardAware;
import org.usfirst.frc.team2129.robot.PreferenceAware;
import org.usfirst.frc.team2129.robot.RobotMapAware;
import org.usfirst.frc.team2129.util.tfmini.TFMini;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem implements PreferenceAware, DashboardAware, RobotMapAware {	
	private SpeedController lifterMotor = getLifterMotor().get();
	private DigitalInput lowerLimit = new DigitalInput(getLowerLimitSwitch());
	private DigitalInput upperLimit = new DigitalInput(getUpperLimitSwitch());
	public TFMini lidar = new TFMini(SerialPort.Port.kMXP);

	public LifterSubsystem() {
		lidar.setDebugMode(true);
	}

	@Override
	protected void initDefaultCommand() {
		// setDefaultCommand(new ManualLifterCommand());
	}

	public void setLiferRaw(double speed) {
		if (getUpperLimit())
			speed = Math.min(speed, 0.05);
		if (getLowerLimit())
			speed = Math.max(speed, 0);
		lifterMotor.set(speed);

		setSmartDashboard("lifter_actual_drive", speed);
		setSmartDashboard("lifter_actual_high_limit", getUpperLimit());
		setSmartDashboard("lifter_actual_low_limit", getLowerLimit());
	}

	public boolean getLowerLimit() {
		return lowerLimit.get();
	}

	public boolean getUpperLimit() {
		return upperLimit.get();
	}
}
