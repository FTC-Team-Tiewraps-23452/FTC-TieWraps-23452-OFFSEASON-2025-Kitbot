package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {

    private final DcMotor armMotor;



    public Arm(HardwareMap hardwareMap){
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void goToPosition(int position, double speed){
        armMotor.setTargetPosition(position);
        armMotor.setPower(speed);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
