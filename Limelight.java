// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");
	NetworkTableEntry tv = table.getEntry("tv");

	

	double xPosition = 9999;
	double yPosition = 9998;
	double area = 9996;

	public Limelight()
	{
		
    }

	@Override
	public void periodic()
	{
	// This method will be called once per scheduler run
	double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(90);
	double x = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(90);
	double y = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(90);
	double a = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(90);
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);

		// System.out.println(a + "," + x + "," + y);
	}

	@Override
	public void simulationPeriodic()
	{
	// This method will be called once per scheduler run during simulation
	}


	public double getX()
	{
		return tx.getDouble(0.0);
	}
	public double getY()
	{
		return yPosition;
	}
	public double getArea()
	{
		return area;
	}


	
	
}
