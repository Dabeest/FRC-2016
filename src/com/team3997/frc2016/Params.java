package com.team3997.frc2016;

import com.team3997.frc2016.util.UpdateParameters;
import com.team3997.frc2016.util.UpdateParameters.Constant;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * 
 * All parameters go in this class.
 *
 */

public class Params extends UpdateParameters {

	/*
	 * 
	 * Other Params
	 */
	public static final String CONSTANTS_FILE = "/home/admin/params.txt";
	public static final String CAMERA_USB = "cam2";
	public static final String CAMERA_AXIS = "cam0";
	
	/*
	 * 
	 * Vision Params
	 * 
	 */
	public static final int MIDDLE_GOAL_X = 146;
	public static final int LEFT_GOAL_X  = 146;
	public static final int RIGHT_GOAL_X  = 146;
	
	/*
	 * 
	 * Encoder Parameters
	 * 
	 */
	public static final EncodingType ENCODER_ENCODING_TYPE = EncodingType.k4X;
	public static final double ENCODER_DISTANCE_PER_PULSE = (double)1/2048;
	
	/*
	 * 
	 * Drive Parameters
	 */
	public static final double DRIVE_MOTOR_SPEED = 1.0;
	public static final boolean SQUARE_INPUTS = true;
	public static final boolean ARCADE_DRIVE = true; // arcade drive is true, tank is false
	
	/*
	 * 
	 * ChickenRun
	 * 
	 */
	public static final double CRUN_MOTOR_POWER = 1.00;
	public static final double CRUN_OUTTAKE_MOTOR_POWER = 1.00;
	public static final double CRUN_SHOOTING_MOTOR_POWER = 0.6; //60%
	/*
	 * 
	 * Intake Parameters
	 */
	public static final double INTAKE_MOTOR_POWER = 0.70;
	public static final double INTAKE_OUTTAKE_MOTOR_POWER = 1.0;

	/*
	 * 
	 * Shooter Parameters
	 */
	public static final boolean SHOOTER_USE_PID = true;
	public static final double SHOOTER_OUTTAKE_MOTOR_POWER = 0.55;
	
	public static final double SHOOTER_YELLOW_MOTOR_POWER = 1.00;
	public static final double SHOOTER_RED_MOTOR_POWER = 0.98;
	public static final double SHOOTER_BLUE_MOTOR_POWER = 0.96;
	public static final double SHOOTER_GREEN_MOTOR_POWER = 0.94;
	public static Constant testShooter = new Constant("testShooter", 1.0);
}