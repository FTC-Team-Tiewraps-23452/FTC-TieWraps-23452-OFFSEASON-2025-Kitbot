package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.TankDrivetrain;



@TeleOp(name="TeleOP-IntoTheDeep-1", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();


    private TankDrivetrain tankDrivetrain;


    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");


        telemetry.addData("Status", "Initialized");

        tankDrivetrain = new TankDrivetrain(hardwareMap);
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
        tankDrivetrain.tankDrive(-gamepad1.left_stick_y, gamepad1.right_stick_x);
    }

    @Override
    public void stop() {
    }

}