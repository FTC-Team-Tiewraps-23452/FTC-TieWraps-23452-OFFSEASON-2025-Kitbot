package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.Arm;


@TeleOp(name="TeleOP-IntoTheDeep-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    private Arm arm;

    int ARM_INTAKE_POSITION = 450;
    int ARM_WALL_GRAB_POSITION = 1100;
    int ARM_HOVER_HIGH_POSITION = 2600;
    int ARM_LOW_BASKET_POSITION = 2500;
    double ARM_SPEED = 0.5;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");


        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
        arm = new Arm(hardwareMap);
    }

    @Override
    public void start() {
        // Restart the timer
        runtime.reset();
    }


    @Override
    public void loop() {
        telemetry.addData("Status", "Run Time: " + runtime.toString());

        if (gamepad1.a){
            arm.goToPosition(ARM_INTAKE_POSITION, ARM_SPEED);
        }

        if (gamepad1.b){
            arm.goToPosition(ARM_WALL_GRAB_POSITION, ARM_SPEED);
        }

        if (gamepad1.y){
            arm.goToPosition(ARM_HOVER_HIGH_POSITION, ARM_SPEED);
        }

        if (gamepad1.x){
            arm.goToPosition(ARM_LOW_BASKET_POSITION, ARM_SPEED);
        }
    }

    @Override
    public void stop() {
    }

}