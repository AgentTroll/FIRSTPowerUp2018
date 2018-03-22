package org.usfirst.frc.team4131.robot.auto.action;

import org.usfirst.frc.team4131.robot.auto.Action;
import org.usfirst.frc.team4131.robot.subsystem.ClimberSubsystem;
import org.usfirst.frc.team4131.robot.subsystem.ElevatorSubsystem;

import edu.wpi.first.wpilibj.Timer;

public class RaiseElevatorAndClimberAction implements Action{

	ClimberSubsystem climber;
	ElevatorSubsystem elevator;

	private boolean elevator2 = false;
	private boolean climber2 = false;

	public RaiseElevatorAndClimberAction(ClimberSubsystem climber, ElevatorSubsystem elevator, boolean climber2, boolean elevator2) {
		this.climber = climber;
		this.elevator = elevator;

		this.climber2 = climber2;
		this.elevator2 = elevator2;
	}

	@Override
	public void doAction() {
		System.err.println("Raising!");
		if (!this.elevator2 && !this.climber2) {
			this.elevator.goToTop();
			this.climber.goToTop();
		} else if (!this.climber2) {
			this.climber.goToTop();
		} else if (!this.elevator2) {
			this.elevator.goToTop();
		}
		else {
			System.err.println("bad action booleans!");
		}
	}
}