/*
 * FRC TEAM 3997. 2016 RR
 * 
 * Thanks to the following teams for sharing their code!: 
 * 	1477, 1899
 *
 */
package com.team3997.frc2016;

//import com.team3997.frc2016.commands.Vision;
import com.team3997.frc2016.subsystems.*;
import com.team3997.frc2016.util.CameraSwitcher;
import com.team3997.frc2016.components.UpdateParameters;
import com.team3997.frc2016.components.Vision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	DriveSubsystem drive;
	Shooter shooter;
	Intake intake;
	Climber climber;
	Vision vision;
	CameraSwitcher cameraSwitcher;

	@Override
	public void robotInit() {
		// Init robot functions
		drive = new DriveSubsystem();
		shooter = new Shooter();
		intake = new Intake();
		climber = new Climber();
		vision = new Vision();
		cameraSwitcher = new CameraSwitcher();

		// Update parameters from text file
		UpdateParameters.update();

		// vision.visionInit();
		
	}

	@Override
	public void autonomousInit() {
		
		UpdateParameters.update();
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
		UpdateParameters.update();
		CameraSwitcher.init();
	}

	@Override
	public void teleopPeriodic() {
		drive.runTeleOp();
		shooter.runTeleOp();
		intake.runTeleOp();
		climber.runTeleOp();
		vision.runTeleOp();
		cameraSwitcher.runTeleOP();
	}

	@Override
	public void disabledInit() {
		CameraSwitcher.end();
		UpdateParameters.update();

	}

	@Override
	public void disabledPeriodic() {

	}

	@Override
	public void testInit() {
		UpdateParameters.update();
	}

	@Override
	public void testPeriodic() {

	}

}
