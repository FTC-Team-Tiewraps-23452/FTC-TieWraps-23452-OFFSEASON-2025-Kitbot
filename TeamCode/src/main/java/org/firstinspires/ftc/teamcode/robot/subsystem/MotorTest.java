package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorTest {

    private final DcMotor motor;

    public MotorTest(HardwareMap hardwareMap){
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void motorAan(double speed){
        motor.setPower(speed);
    }

    public double motorValue(){
        return motor.getCurrentPosition();
    }

}
