// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {

	Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
	DoubleSolenoid solenoid3 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);	// cursher solenoid
	DoubleSolenoid solenoid2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);	// arm solenoid

	public Pneumatics()
	{
        pcmCompressor.disable();
		solenoid3.set(Value.kOff);
		solenoid2.set(Value.kOff);
    }

	@Override
	public void periodic()
	{
	// This method will be called once per scheduler run
	}

	@Override
	public void simulationPeriodic()
	{
	// This method will be called once per scheduler run during simulation
	}


	public void disableCompressor()
	{
		pcmCompressor.disable();
	}
	public void enableCompressor()
	{
		pcmCompressor.enableDigital();
	}

	public void onCrusherSolenoid()
	{
		solenoid3.set(Value.kForward);
	}
	public void offCrusherSolenoid()
	{
		solenoid3.set(Value.kReverse);
	}
	public void toggleCrusherSolenoid()
	{
		solenoid3.toggle();
	}
	public DoubleSolenoid.Value getCrusherSolinoidState()
	{
		return solenoid3.get();
	}

	public void onArmSolenoid()
	{
		solenoid2.set(Value.kForward);
	}
	public void offArmSolenoid()
	{
		solenoid2.set(Value.kReverse);
	}
	public void toggleArmSolenoid()
	{
		solenoid2.toggle();
	}
	public DoubleSolenoid.Value getArmSolinoidState()
	{
		return solenoid2.get();
	}

	
}
