// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
// import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TankDrive extends CommandBase
{
    @SuppressWarnings({ "PMD.UnusedPrivateFeld", "PMD.SingularField" })


    /**
     * Creates a new TankDrive.
     *
     * @param subsystem The subsystem used by this command.
     */
	public TankDrive()
	{
		// Use addRequirements() here to declare subsystem dependencies.
		addRequirements(RobotContainer.driveTrain);
  	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() 
	{
		RobotContainer.driveTrain.FLMset(0);
		RobotContainer.driveTrain.FRMset(0);
		RobotContainer.driveTrain.BLMset(0);
		RobotContainer.driveTrain.BRMset(0);

	}



	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() 
	{

		double driverAxisX = RobotContainer.controller.getRawAxis(0);
		double driverAxisY = -RobotContainer.controller.getRawAxis(1);
		double driverAxisZ = RobotContainer.controller.getRawAxis(2);
		

		/*
			left motors controll the left motors for sterring, same for right
			used when turning
		*/
		double rotationLeftMotors = 0;
		double rotationRightMotors = 0;
		double motorSpeed = 0;


		
		if (Math.abs(driverAxisY) < Constants.driveConstants.CONTROLLER_DEADZONE)
		{
			driverAxisY = 0;
		}

		if (Math.abs(driverAxisX) < Constants.driveConstants.CONTROLLER_Z_AXIS_DEADZONE)
		{
			driverAxisX = 0;
		}


		motorSpeed = driverAxisY * Constants.driveConstants.FOREWARD_SPEED_MULTIPLIER;
		
		rotationLeftMotors = driverAxisX * Constants.driveConstants.ROTATION_SPEED_MULTIPLIER;
		rotationRightMotors = driverAxisX * -Constants.driveConstants.ROTATION_SPEED_MULTIPLIER;
		
		

		

		RobotContainer.driveTrain.FRMset((rotationRightMotors+motorSpeed));
		RobotContainer.driveTrain.FLMset((rotationLeftMotors+motorSpeed));
		RobotContainer.driveTrain.BRMset((rotationRightMotors+motorSpeed));
		RobotContainer.driveTrain.BLMset((rotationLeftMotors+motorSpeed));







  	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) 
	{
		initialize();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished()
	{
		return false;
	}
}
