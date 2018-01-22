package org.usfirst.frc.team4131.robot.subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.command.ClimbCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Links control of the climbing mechanism.
 */
public class ClimberSubsystem extends Subsystem {
    /**
     * Initializes and caches the climbing mechanism motors.
     */
    
	private final TalonSRX one;
    private final TalonSRX two;
	
	public ClimberSubsystem() {
		 this.one = new TalonSRX(RobotMap.C1);
	     this.two = new TalonSRX(RobotMap.C2);
	}

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new ClimbCommand(this));
    }

    /**
     * Performs the climbing action and hoists the robot
     * up the pull-up bar.
     */
    public void doClimb(boolean upDown) {
    	if (upDown) {
    		this.one.set(ControlMode.PercentOutput, 1);
    		this.two.set(ControlMode.PercentOutput, 1);
    	} else {
    		this.one.set(ControlMode.PercentOutput, -1);
        	this.two.set(ControlMode.PercentOutput, -1);
    	}
    }
    
    
    public void doStop() {
    	this.one.set(ControlMode.PercentOutput, 0);
    	this.two.set(ControlMode.PercentOutput, 0);
    }
}