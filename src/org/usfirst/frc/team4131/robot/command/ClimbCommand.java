package org.usfirst.frc.team4131.robot.command;

import org.usfirst.frc.team4131.robot.Oi;
import org.usfirst.frc.team4131.robot.subsystem.ClimberSubsystem;

/**
 * A command which will activate the climber and raise the
 * robot using the pull-up bar.
 */
// TODO: complete
public class ClimbCommand extends SingleSubsystemCmd<ClimberSubsystem> {
    public ClimbCommand(ClimberSubsystem subsystem) {
        super(subsystem);
    }

    @Override
    protected void execute() {
        if (up() && down()) {
        	this.subsystem.doStop();
        } else if (up()) {
        	this.subsystem.doClimb(true);
        } else if (down()) {
        	this.subsystem.doClimb(false);
        } else {
        	this.subsystem.doStop();
        }
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    @Override
    protected void interrupted() {
        this.subsystem.doStop();
    }
    
    private static boolean up() {
    	return Oi.CLIMB.get();
    }
    
    private static boolean down() {
    	return Oi.LOWER.get();
    }
}