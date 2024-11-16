package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Arm;
import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.Robot;
@TeleOp(name="TeleOp", group="TeleOp")
public class Teleop extends LinearOpMode {
    Robot robot = new Robot();
    int armPos = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.createRobot(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Heading Degrees", robot.getHeadingInDegrees());
            telemetry.addData("armPos", armPos);
            telemetry.update();

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            robot._arm.setExtendPower(-gamepad2.right_stick_y);
            //robot._arm.setPivotPower(-gamepad2.left_stick_y);
            robot._arm.setPivotPosition(armPos);

            robot.arcadeDrive(x,y,rx);
            robot._intake.run();

            if(gamepad1.a){
                robot.resetHeading();
            }

            if(gamepad2.right_bumper){
                robot._intake.setIntakeState(Intake.IntakeStates.kForward);
            }
            else if(gamepad2.left_bumper){
                robot._intake.setIntakeState(Intake.IntakeStates.kReversed);
            }
            else{
                robot._intake.setIntakeState(Intake.IntakeStates.kIdle);
            }

            if(gamepad2.left_stick_y > 0.1){
                armPos = armPos - 3;
            }
            if(gamepad2.left_stick_y < -0.1){
                armPos = armPos + 3;
            }
        }
    }
}
