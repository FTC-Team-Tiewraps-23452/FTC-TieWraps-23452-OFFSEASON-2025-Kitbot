package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.Claw;


@TeleOp(name="TeleOP-IntoTheDeep-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
private Claw claw;
    private static final double CLAW_OPEN_POSITION = 0.55;
    private static final double CLAW_CLOSED_POSITION = 0.7;
    private boolean ClawOpen = true;
    private boolean lastBump = false;
    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");
claw = new Claw(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        // Restart the timer
        runtime.reset();
    }


    @Override
    public void loop() {
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        if (gamepad1.right_bumper && !lastBump) {
            ClawOpen = !ClawOpen;
            if (ClawOpen) {
                claw.setposition(CLAW_OPEN_POSITION);
            } else{
                claw.setposition(CLAW_CLOSED_POSITION);
            }
        }
        lastBump = gamepad1.right_bumper;

    }
    @Override
    public void stop() {
    }

}