package org.usfirst.frc.team2129.robot.commands;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualLifterCommand extends Command {
	
	public ManualLifterCommand() {
		requires(Robot.s_LifterSubsystem);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 3];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 3] = hexArray[v >>> 4];
	        hexChars[j * 3 + 1] = hexArray[v & 0x0F];
	        hexChars[j * 3 + 2] = ' ';
	    }
	    return new String(hexChars);
	}
	
	public byte[] getFirstFrame(byte[] array) {
		for(int i=0;i<(array.length-9);i++) {
			if(array[i] == 0x59 && array[i+1] == 0x59) {
				return new byte[]{array[i], array[i+1], array[i+2], array[i+3], array[i+4], array[i+5], array[i+6], array[i+7], array[i+8]};
			}
		}
		return new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
	}
	
	public int getRawDistance(byte[] frame) {
		int ulow = frame[2] & 0xFF;
		int uhigh = frame[3] & 0xFF;
		return ulow + (uhigh << 8);
	}
	
	public int getRawStrength(byte[] frame) {
		int ulow = frame[4] & 0xFF;
		int uhigh = frame[5] & 0xFF;
		return ulow + (uhigh << 8);
	}
	
	public boolean validateFrame(byte[] frame) {
		byte sum = 0;
		for (int i=0;i<8;i++) sum+=frame[i];
		return frame[0] == 0x59 && frame[1] == 0x59 && frame[8] == sum;
	}
	
	public float seekFloat(String data) {
		String number="";
		for(int i=0;i<data.length();i++) {
			if("1234567890.".indexOf(data.charAt(i))!=-1) {
				number+=data.charAt(i);
			}else {
				break;
			}
		}
		if(number=="") return -1;
		return Float.parseFloat(number);
	}
	
	public void execute() {
		Robot.s_LifterSubsystem.setLiferRaw(OI.lifterStick.getY());
		Robot.s_LifterSubsystem.setGrabber(OI.lifterStick.getRawButton(1));
		
		
		Robot.s_LifterSubsystem.updateBuffer();
		byte[] frame = Robot.s_LifterSubsystem.buffer.getSnapshot();
		SmartDashboard.putString("tfmini_debug", bytesToHex(frame));
		if(validateFrame(frame)) {
			SmartDashboard.putNumber("tfmini_distance", getRawDistance(frame));
			SmartDashboard.putNumber("tfmini_strength", getRawStrength(frame));
		}else {
			SmartDashboard.putNumber("tfmini_errors", SmartDashboard.getNumber("tfmini_errors", 0)+1);
		}
		
		
		
//		String s = Robot.s_LifterSubsystem.lidarPort.readString();
//		SmartDashboard.putString("tfmini_debug", s);
//		SmartDashboard.putNumber("tfmini_distance", seekFloat(s));
		SmartDashboard.putNumber("tfmini_waiting", Robot.s_LifterSubsystem.lidarPort.getBytesReceived());
	}

}
