package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Wrist {
    private final DcMotor wristMotor;

    public Wrist(HardwareMap hardwareMap) {
        wristMotor = hardwareMap.get(DcMotor.class, "wristMotor");
        wristMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}