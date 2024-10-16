package org.firstinspires.ftc.fowlervillerobotics;

import com.qualcomm.robotcore.hardware.DcMotor;

public class FastRobot {
    public FastRobot(DcMotor leftFront,DcMotor rightFront,DcMotor leftRear,DcMotor rightRear){

    }
    public static FastRobot robot = null;
    public static FastRobot get() { return robot; }
}
