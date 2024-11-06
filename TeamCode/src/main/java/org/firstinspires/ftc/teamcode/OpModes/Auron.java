package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Auron", group="TeleOp")
public class Auron extends LinearOpMode {
    //Servo taylor = null;
    //Servo swift = null;
    DcMotor beeDrill = null;

    @Override
    public void runOpMode() throws InterruptedException {
        //taylor = hardwareMap.get(Servo.class, "taylor");
        //swift = hardwareMap.get(Servo.class, "swift");
        beeDrill = hardwareMap.get(DcMotor.class,"beeDrill");
        waitForStart();

        while (opModeIsActive()){
//            if(gamepad1.dpad_left){
//                taylor.setPosition(1);
//                swift.setPosition(0);
//            }
//            else if(gamepad1.dpad_right){
//                taylor.setPosition(0);
//                swift.setPosition(1);
//            }
//            else {
//                taylor.setPosition(0.5);
//                swift.setPosition(0.5);
//            }
            double stickY = gamepad1.left_stick_y;
            beeDrill.setPower(stickY);
        }
    }
}
