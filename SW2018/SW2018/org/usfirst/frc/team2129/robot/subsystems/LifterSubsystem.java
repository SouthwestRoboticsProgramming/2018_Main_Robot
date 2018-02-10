package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.ManualLifterCommand;
import org.usfirst.frc.team2129.util.tfmini.CircularByteBuffer;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem {
	
	SpeedController lifterMotor   = RobotMap.lifterMotor.get();
	Solenoid        grabberPiston = new Solenoid(RobotMap.grabberSolenoid);
	public SerialPort      lidarPort     = new SerialPort(115200, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone, SerialPort.StopBits.kOne);
	public CircularByteBuffer buffer=new CircularByteBuffer(18);
	
	
	public LifterSubsystem() {
		lidarPort.reset();
		lidarPort.setReadBufferSize(1);
		lidarPort.setTimeout(10);
		lidarPort.setWriteBufferMode(SerialPort.WriteBufferMode.kFlushOnAccess);
		lidarPort.write(new byte[] {0x42, 0x57, 0x02, 0x00, 0x00, 0x00, 0x01, 0x06}, 8);
		lidarPort.flush();
		lidarPort.setTimeout(0);
		
//		lidarPort.reset();
//		lidarPort.setReadBufferSize(100);
//		lidarPort.setTimeout(0.01);
//		lidarPort.setWriteBufferMode(SerialPort.WriteBufferMode.kFlushOnAccess);
//		lidarPort.write(new byte[] {0x42, 0x57, 0x02, 0x00, 0x00, 0x00, 0x04, 0x06}, 8);
//		lidarPort.flush();
//		lidarPort.setTimeout(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ManualLifterCommand());
	}
	
	public void setLiferRaw(double v) {
		lifterMotor.set(v);
	}
	
	public void setGrabber(boolean v) {
		grabberPiston.set(v);
	}
	
	public void updateBuffer() {
		buffer.readIn(lidarPort.read(10000));
	}

}
