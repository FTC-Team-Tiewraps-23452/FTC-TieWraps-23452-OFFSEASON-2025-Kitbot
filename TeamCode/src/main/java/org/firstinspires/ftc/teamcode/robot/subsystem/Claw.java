package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw { private final Servo claw;
private static final double CLAW_OPEN_POSITION = 0.55;
private static final double CLAW_CLOSED_POSITION = 0.7;
    private boolean ClawOpen = true;
    private boolean lastBump = false;

    public Claw (HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class,"claw");


                

    }
    public void setposition(double positie){
        claw.setPosition(positie);
    }
}
