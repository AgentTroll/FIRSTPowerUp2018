package org.usfirst.frc.team4131.robot.auto;

import org.usfirst.frc.team4131.robot.nav.TurnController;
import org.usfirst.frc.team4131.robot.subsystem.DriveBaseSubsystem;

import java.util.function.DoubleConsumer;

/**
 * A turn action causes the robot to rotate until the given
 * arguments have been reached.
 */
public class TurnAction implements Action {

    private static final TurnController controller = new TurnController();
    /** The drive base */
    private final DriveBaseSubsystem driveBase;
    /** The value to turn */
    private final float delta;

    /**
     * Creates a new turning action that moves a specified
     * relative delta value.
     *
     * @param driveBase the drive base
     * @param delta the delta angle to turn
     */
    public TurnAction(DriveBaseSubsystem driveBase, float delta) {
        this.driveBase = driveBase;
        this.delta = delta;
    }

    @Override
    public void doAction() {
        DoubleConsumer consumer = value -> this.driveBase.doThrottle(value, -value);
        controller.begin(this.delta);
        while (!controller.hasFinished()) {
            controller.pollData(consumer);
        }
        this.driveBase.doThrottle(0, 0);
    }
}