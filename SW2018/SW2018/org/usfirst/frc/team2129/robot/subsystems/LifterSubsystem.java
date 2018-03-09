package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.DashboardAware;
import org.usfirst.frc.team2129.robot.PreferenceAware;
import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.util.tfmini.TFMini;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem implements PreferenceAware, DashboardAware {
	private SpeedController lifterMotor = RobotMap.lifterMotor.get();
	private DigitalInput lowerLimit = new DigitalInput(RobotMap.lowerLimitSwitch);
	private DigitalInput upperLimit = new DigitalInput(RobotMap.upperLimitSwitch);
	public TFMini lidar = new TFMini(SerialPort.Port.kMXP);

	public LifterSubsystem() {
		lidar.setDebugMode(true);
	}

	@Override
	protected void initDefaultCommand() {
		// setDefaultCommand(new ManualLifterCommand());
	}

	public void setLiferRaw(double v) {
		if (getUpperLimit())
			v = Math.min(v, 0.05);
		if (getLowerLimit())
			v = Math.max(v, 0);
		lifterMotor.set(v);

		setSmartDashboard("lifter_actual_drive", v);
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
