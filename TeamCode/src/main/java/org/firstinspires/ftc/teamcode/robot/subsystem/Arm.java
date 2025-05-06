package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {

    private final DcMotor armMotor;
    private final double ARM_SPEED = 0.5;



    public Arm(HardwareMap hardwareMap){
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void goToPosition(int position){
        armMotor.setTargetPosition(position);
        armMotor.setPower(ARM_SPEED);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void moveArm(double speed) {
        armMotor.setPower(speed);
    }
}
