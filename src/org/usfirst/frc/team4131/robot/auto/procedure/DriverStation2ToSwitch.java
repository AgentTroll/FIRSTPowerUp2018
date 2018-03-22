package org.usfirst.frc.team4131.robot.auto.procedure;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team4131.robot.auto.Action;
import org.usfirst.frc.team4131.robot.auto.Procedure;
import org.usfirst.frc.team4131.robot.auto.Side;
import org.usfirst.frc.team4131.robot.auto.action.DistanceMoveAction;
import org.usfirst.frc.team4131.robot.auto.action.RaiseElevatorAndClimberAction;
import org.usfirst.frc.team4131.robot.auto.action.StartPnuematicAction;
import org.usfirst.frc.team4131.robot.auto.action.EndPnuematicAction;
import org.usfirst.frc.team4131.robot.auto.action.TurnAction;
import org.usfirst.frc.team4131.robot.subsystem.SubsystemProvider;

import java.util.List;

/**
 * Autonomous procedure to run when the robot is placed
 * in front of the driver station.
 */
public class DriverStation2ToSwitch implements Procedure {
	@Override
	public int estimateLen() {
		return 5;
	}

	@Override
	public void populate(SubsystemProvider provider, List<Side> data, List<Action> procedure) {
		// check fms data
		//Johnny's implementation: data.get(0) == Side.RIGHT
		if (data.get(0) == Side.RIGHT) {
			//forward 18", right 90, forward 27", left 90, forward 122"
			procedure.add(new StartPnuematicAction(provider.getClaw()));
			procedure.add(new DistanceMoveAction(provider.getDriveBase(), 30));
			Timer.delay(1);
			procedure.add(new TurnAction(provider.getDriveBase(), 90));
			Timer.delay(1);
			procedure.add(new DistanceMoveAction(provider.getDriveBase(), 50));
			Timer.delay(1);
			procedure.add(new TurnAction(provider.getDriveBase(), -90));
			procedure.add(new RaiseElevatorAndClimberAction(provider.getClimber(), provider.getElevator(), true, false));
			procedure.add(new DistanceMoveAction(provider.getDriveBase(), 54));//74
			Timer.delay(1);
			procedure.add(new EndPnuematicAction(provider.getClaw()));
		} else if (data.get(0) == Side.LEFT){
			//forward 18", left 90, forward 151", right 90, forward 122"
			procedure.add(new StartPnuematicAction(provider.getClaw()));
			Timer.delay(1);
			procedure.add(new DistanceMoveAction(provider.getDriveBase(), 30));
			Timer.delay(1);
			procedure.add(new TurnAction(provider.getDriveBase(), -90));
			Timer.delay(1);
			procedure.add(new DistanceMoveAction(provider.getDriveBase(), 75));
			Timer.delay(1);
			procedure.add(new TurnAction(provider.getDriveBase(), 90));
			Timer.delay(2);
			procedure.add(new RaiseElevatorAndClimberAction(provider.getClimber(), provider.getElevator(), true, false));
			procedure.add(new DistanceMoveAction(provider.getDriveBase(), 54));//74
			Timer.delay(1);
			procedure.add(new EndPnuematicAction(provider.getClaw()));
		} else {
			DriverStation.reportError("Bad FMS data", true);
			System.err.println("Bad FMS data");
		}
	}
}
