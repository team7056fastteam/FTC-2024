package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    public enum IntakeStates{ kForward, kReversed, kIdle}

    IntakeStates state = IntakeStates.kIdle;

    Servo leftIntake = null;
    Servo rightIntake = null;

    public void createIntake(HardwareMap hardwareMap){
        leftIntake = hardwareMap.get(Servo.class, "LeftIntake");
        rightIntake = hardwareMap.get(Servo.class, "RightIntake");
    }

    public void setIntakeState(IntakeStates state){
        this.state = state;
    }

    public void run(){
        switch (state){
            case kForward:
                leftIntake.setPosition(0);
                rightIntake.setPosition(1);
                break;
            case kReversed:
                leftIntake.setPosition(1);
                rightIntake.setPosition(0);
                break;
            case kIdle:
                leftIntake.setPosition(0.5);
                rightIntake.setPosition(0.5);
                break;
        }
    }
}
