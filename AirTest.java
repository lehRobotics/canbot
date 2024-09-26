// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AirTest extends CommandBase
{
    @SuppressWarnings({ "PMD.UnusedPrivateFeld", "PMD.SingularField" })


    /**
     * Creates a new TankDrive.
     *
     * @param subsystem The subsystem used by this command.
     */
	public AirTest()
	{
		// Use addRequirements() here to declare subsystem dependencies.
		addRequirements(RobotContainer.pneumatics);
  	}
	
	boolean triggerState, crusherState;
	int debounceCooldown, crusherDebounceCooldown;

	// Called when the command is initially scheduled.
	@Override
	public void initialize() 
	{
		RobotContainer.pneumatics.disableCompressor();
		RobotContainer.pneumatics.offCrusherSolenoid();

		triggerState = false;
		crusherState = false;
		debounceCooldown = 0;
		crusherDebounceCooldown = 0;
	}



	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() 
	{
		RobotContainer.pneumatics.enableCompressor();

		// boolean crusherButtonState = RobotContainer.controller.getRawButton(1);
		boolean armButtonState = RobotContainer.controller.getRawButton(2);

		if (debounceCooldown < 20)
			debounceCooldown++;
		if (crusherDebounceCooldown < 20)
			crusherDebounceCooldown++;
		

		if (RobotContainer.controller.getRawButtonPressed(1) && triggerState == false && debounceCooldown > 10)
		{
			RobotContainer.pneumatics.onCrusherSolenoid();
			triggerState = true;
			debounceCooldown = 0;
		}
		if (RobotContainer.controller.getRawButtonReleased(1) && triggerState == true && debounceCooldown > 10)
		{
			RobotContainer.pneumatics.offCrusherSolenoid();
			triggerState = false;
			debounceCooldown = 0;
		}
		if (RobotContainer.controller.getRawButtonPressed(2) && crusherState == false && crusherDebounceCooldown > 10)
		{
			RobotContainer.pneumatics.onArmSolenoid();
			crusherState = true;
			crusherDebounceCooldown = 0;
		}
		if (RobotContainer.controller.getRawButtonReleased(2) && crusherState == true && crusherDebounceCooldown > 10)
		{
			RobotContainer.pneumatics.offArmSolenoid();
			crusherState = false;
			crusherDebounceCooldown = 0;
		}

		// if (crusherButtonState)
		// {
		// 	RobotContainer.pneumatics.onCrusherSolenoid();
		// }
		// else
		// {
		// 	RobotContainer.pneumatics.offCrusherSolenoid();
		// }

		// if (armButtonState)
		// {
		// 	RobotContainer.pneumatics.onArmSolenoid();
		// }
		// else
		// {
		// 	RobotContainer.pneumatics.offArmSolenoid();
		// }
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
