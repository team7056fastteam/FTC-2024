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
        Servo taylor = hardwareMap.get(Servo.class, "taylor");
        Servo swift = hardwareMap.get(Servo.class, "swift");
        //DcMotor kurt = hardwareMap.get(DcMotor.class, "balls");


        waitForStart();

        //taylorSwift.setPosition(1);

        while(opModeIsActive()){
            //kurt.setPower(-gamepad1.left_stick_y);

           if(gamepad1.dpad_left){
               taylor.setPosition(0);
               swift.setPosition(1);
           }
           else if(gamepad1.dpad_right){
               taylor.setPosition(1);
               swift.setPosition(0);
           }
           else{
               taylor.setPosition(0.5);
               swift.setPosition(0.5);
           }
        }
    }
}
