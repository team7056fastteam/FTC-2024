package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    DcMotor pivotMotor = null;
    DcMotor extendMotor0 = null;
    DcMotor extendMotor1 = null;

    public void createArm(HardwareMap hardwareMap){
        pivotMotor = hardwareMap.get(DcMotor.class, "Pivot");
        extendMotor0 = hardwareMap.get(DcMotor.class, "Extend1");
        extendMotor1 = hardwareMap.get(DcMotor.class, "Extend2");

        extendMotor1.setDirection(DcMotor.Direction.REVERSE);
        pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        pivotMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void setPivotPower(double power){
        pivotMotor.setPower(power);
    }
    public void setPivotPosition(int position){
        pivotMotor.setTargetPosition(position);
        pivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        pivotMotor.setPower(0.5);
    }
    public void setExtendPower(double power){
        extendMotor0.setPower(power);
        extendMotor1.setPower(power);
    }
}
