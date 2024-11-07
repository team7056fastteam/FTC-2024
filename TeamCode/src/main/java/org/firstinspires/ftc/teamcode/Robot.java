package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleMecanumMath;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Robot{
    private DcMotor leftFrontDrive = null;
    private DcMotor leftRearDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightRearDrive = null;

    private Servo ham = null;

    private IMU imu = null;

    public void createRobot(HardwareMap robotHardwareMap) {
        ham = robotHardwareMap.get(Servo.class,"ham");
        //leftFrontDrive = hardwareMap.get(DcMotor.class, "0");
        //leftRearDrive = hardwareMap.get(DcMotor.class, "1");
        //rightFrontDrive = hardwareMap.get(DcMotor.class, "2");
        //rightRearDrive = hardwareMap.get(DcMotor.class, "3");

        //leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        //leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        //rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        //rightRearDrive.setDirection(DcMotor.Direction.FORWARD);

//        imu = hardwareMap.get(IMU.class, "imu");
//        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
//                RevHubOrientationOnRobot.LogoFacingDirection.UP,
//                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
//        imu.initialize(parameters);
    }

    public void arcadeDrive(double xPower, double yPower, double rPower){
        FowlervilleMecanumMath.ChassisState chassisState = FowlervilleMecanumMath.getChassisStateFromPower(xPower,yPower,rPower,getHeadingInRadians());
        leftFrontDrive.setPower(chassisState.getLeftFrontDrive());
        leftRearDrive.setPower(chassisState.getLeftRearDrive());
        rightFrontDrive.setPower(chassisState.getRightFrontDrive());
        rightRearDrive.setPower(chassisState.getRightRearDrive());
    }

    public double getHeadingInRadians(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }

    public void setHamPos(double pos) {
        ham.setPosition(pos);
    }
}