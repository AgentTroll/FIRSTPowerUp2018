package org.usfirst.frc.team4131.robot.auto.action;

import org.usfirst.frc.team4131.robot.auto.Action;
import org.usfirst.frc.team4131.robot.subsystem.ClawSubsystem;

/*
 * Cube despense actions, end of auton
 * Release cube
 * Eject Cube
 */
public class EndPnuematicAction implements Action{

	ClawSubsystem claw;

	public EndPnuematicAction(ClawSubsystem claw) {
		this.claw = claw;
	}
	
	@Override
	public void doAction() {
		claw.armDown();
		claw.release();
		claw.pusherOut();
	}
}
