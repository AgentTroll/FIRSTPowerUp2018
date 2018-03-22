package org.usfirst.frc.team4131.robot.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.command.ClimbCommand;

/**
 * Links control of the climbing mechanism, used to raise
 * the robot.
 */
public class ClimberSubsystem extends Subsystem {
	private final TalonSRX one;
	private final TalonSRX two;

	/**
	 * Initializes and caches the climbing mechanism motors.
	 */
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
	public void raise() {
		this.one.set(ControlMode.PercentOutput, 1);
		this.two.set(ControlMode.PercentOutput, 1);
	}

	/**
	 * Lowers the elevator.
	 */
	public void lower() {
		this.one.set(ControlMode.PercentOutput, -0.80);
		this.two.set(ControlMode.PercentOutput, -0.80);
	}

	/**
	 * Stops the elevator from movement produced by the
	 * controls.
	 */
	public void stop() {
		this.one.set(ControlMode.PercentOutput, 0);
		this.two.set(ControlMode.PercentOutput, 0);
	}

	public void goToBottom() {
		while (Robot.isClimberBottom) {
			this.lower();
		}
		this.stop();
	}

	public void goToTop() {
		System.err.println("Climber going to top!");
		/*while (Robot.isClimberTop) {
    		System.err.println("Climber still in loop!");
    		this.raise();
    	}
    	this.stop();
		 */
		this.one.set(ControlMode.PercentOutput, -0.5);
		this.two.set(ControlMode.PercentOutput, -0.5);
		Timer.delay(5);
		this.one.set(ControlMode.PercentOutput, 0);
		this.two.set(ControlMode.PercentOutput, 0);
	}
}