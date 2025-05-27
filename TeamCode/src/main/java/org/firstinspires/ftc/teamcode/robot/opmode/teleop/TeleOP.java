package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.Wrist;



@TeleOp(name="TeleOP-IntoTheDeep-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    private Wrist wrist;

    int WRIST_INIT_POSITION = 0;
    int WRIST_SAMPLE_POSITION = 270;
    int WRIST_SPEC_POSITION = 10;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");


        telemetry.addData("Status", "Initialized");

        wrist = new Wrist(hardwareMap);
    }

    @Override
    public void init_loop() {
        wrist = new Wrist(hardwareMap);
    }

    @Override
    public void start() {
        // Restart the timer
        runtime.reset();
    }


    @Override
    public void loop() {
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }

    @Override
    public void stop() {
    }

}