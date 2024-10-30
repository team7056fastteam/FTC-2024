package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name="Test", group="TeleOp")
public class TestOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //Servo taylorSwift = hardwareMap.get(Servo.class, "taylorswift");
        DcMotor kurt = hardwareMap.get(DcMotor.class, "balls");


        waitForStart();

        //taylorSwift.setPosition(1);

        while(opModeIsActive()){
            kurt.setPower(-gamepad1.left_stick_y);
        }
    }
}
