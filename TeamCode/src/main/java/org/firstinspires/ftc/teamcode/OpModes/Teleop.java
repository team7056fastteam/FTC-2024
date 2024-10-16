package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
@TeleOp(name="TeleOp", group="TeleOp")
public class Teleop extends LinearOpMode {
    Robot robot = null;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.createRobot();
        waitForStart();
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        robot.arcadeDrive(x,y,rx);
    }
}
