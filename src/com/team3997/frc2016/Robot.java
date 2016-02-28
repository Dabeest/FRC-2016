/*
 * FRC TEAM 3997. 2016 Robot Code
 * 
 * Programming Team: 
 * -Damir Gluhak
 * -Lucy Zhao
 * -Michael Chacko
 * 
 * 
 * Thanks to the following teams for sharing their code: 
 * 	1477, 254!
 *
 */
package com.team3997.frc2016;

import com.team3997.frc2016.subsystems.*;
import com.team3997.frc2016.auton.Auton;
import com.team3997.frc2016.components.*;
import com.team3997.frc2016.util.Dashboard;
import com.team3997.frc2016.util.Debounce;
import com.team3997.frc2016.util.LogitechF310Gamepad;
import com.team3997.frc2016.util.UpdateParameters;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.vision.AxisCamera.ExposureControl;

public class Robot extends IterativeRobot {
	
	public static boolean isManualMode = false;

	LogitechF310Gamepad driverGamePad = Hardware.kDriverGamePad;
	LogitechF310Gamepad opGamePad = Hardware.kOpGamePad;
	Drive drive = Hardware.kDrive;
	Shooter shooter = Hardware.kShooter;
	Intake intake = Hardware.kIntake;
	Hanger hanger = Hardware.kHanger;
	Vision vision = Hardware.kVision;
	Lights lights = Hardware.kLights;
	Debounce manualToggle = new Debounce(opGamePad, Controls.MANUAL_CONTROL_TOGGLE_BUTTON);
	public static Auton auton = new Auton();
	byte[] toSend;

	@Override
	public void robotInit() {
		System.out.println("Start robotInit()");
		
		auton.listOptions();
		
		//Turn camrea light on
		Hardware.kTargetLED.set(true);
		
		// Update parameters from text file
		UpdateParameters.update();
	}

	@Override
	public void autonomousInit() {
		System.out.println("Start autonomousInit()");

		UpdateParameters.update();
		auton.start();

	}
	
	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopInit() {
		System.out.println("Start teleopInit()");
		shooter.initTeleOp();
		auton.stop();
		UpdateParameters.update();
		//accel.reset();
	}

	@Override
	public void teleopPeriodic() {
		drive.runTeleOp();
		shooter.runTeleOp();
		intake.runTeleOp();
		hanger.runTeleOp();
		vision.runTeleOp();
		
		//Change between manual and automatic mode
		Dashboard.put("Manual Mode", isManualMode);
		if(manualToggle.getFall()){
			isManualMode = !isManualMode;
			shooter.shooterPID.disablePID();
		}
		
		if(isManualMode){
			//set lights to manual mode color
		}
	}

	@Override
	public void disabledInit() {
		System.out.println("Start disabledInit()");
		
		auton.stop();

		UpdateParameters.update();
	}

	@Override
	public void disabledPeriodic() {
		lights.setColor(Lights.PRIDE);
	}
}
