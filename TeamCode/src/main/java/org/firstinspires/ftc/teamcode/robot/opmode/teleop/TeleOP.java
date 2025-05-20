package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.Arm;


@TeleOp(name="TeleOP-IntoTheDeep-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    private Arm arm;
    private boolean lastGrab = false;
    private boolean lastHook = false;

    int ARM_INTAKE_POSITION = 450;
    int ARM_WALL_GRAB_POSITION = 1100;
    int ARM_HOVER_HIGH_POSITION = 2600;
    int ARM_LOW_BASKET_POSITION = 2500;
    int ARM_INIT_POSITION = 300;
    int ARM_WALL_UNHOOK_POSITION = 1700;
    int ARM_CLIP_HIGH_POSITION = 2100;

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
            arm.goToPosition(ARM_INTAKE_POSITION);
        } else if (gamepad1.b && !lastGrab){
            if (arm.position() >= ARM_WALL_GRAB_POSITION - 10 && arm.position() <= ARM_WALL_GRAB_POSITION + 10) {
                arm.goToPosition(ARM_WALL_UNHOOK_POSITION);
            } else {
                arm.goToPosition(ARM_WALL_GRAB_POSITION);
            }
        } else if (gamepad1.y && !lastHook){
            if (arm.position() >= ARM_HOVER_HIGH_POSITION - 10 && arm.position() <= ARM_WALL_GRAB_POSITION + 10) {
                arm.goToPosition(ARM_CLIP_HIGH_POSITION);
            } else {
                arm.goToPosition(ARM_HOVER_HIGH_POSITION);
            }
        } else if (gamepad1.x){
            arm.goToPosition(ARM_LOW_BASKET_POSITION);
        } else if (gamepad1.dpad_up){
            arm.moveArm(0.5);
        } else if (gamepad1.dpad_down){
            arm.moveArm(-0.5);
        } else if (gamepad1.left_bumper){
            arm.goToPosition(ARM_INIT_POSITION);
        }

        lastGrab = gamepad1.b;
        lastHook = gamepad1.y;
    }

    @Override
    public void stop() {
    }

}