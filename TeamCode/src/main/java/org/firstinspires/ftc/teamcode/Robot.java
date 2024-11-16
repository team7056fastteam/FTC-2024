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

    private IMU imu = null;

    public Intake _intake = null;
    public Arm _arm = null;

    public void createRobot(HardwareMap hardwareMap) {
        //ham = robotHardwareMap.get(Servo.class,"ham");
        leftFrontDrive = hardwareMap.get(DcMotor.class, "LF");
        leftRearDrive = hardwareMap.get(DcMotor.class, "LR");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "RF");
        rightRearDrive = hardwareMap.get(DcMotor.class, "RR");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightRearDrive.setDirection(DcMotor.Direction.FORWARD);

        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        imu.initialize(parameters);

        _intake = new Intake();
        _intake.createIntake(hardwareMap);

        _arm = new Arm();
        _arm.createArm(hardwareMap);
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

    public double getHeadingInDegrees(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public void resetHeading(){
        imu.resetYaw();
    }

}