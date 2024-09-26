// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AirTest;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Pneumatics;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
	// The robot's subsystems and commands are defined here...
	// public static final RampDriveTrain driveTrain = new RampDriveTrain();

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Limelight limelight = new Limelight();
	public static final Pneumatics pneumatics = new Pneumatics();
	
	public static final Command tankDrive = new TankDrive();
	public static final Command airTest = new AirTest();

	public static final XboxController controller = new XboxController(0);
	public static final AHRS navx = new AHRS();


	/** The container for the robot. Contains subsystems, OI devices, and commands. */
	public RobotContainer()
	{
		// Configure the button bindings
		configureButtonBindings();

		navx.reset();
	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
	 * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {}
}
