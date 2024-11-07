package org.firstinspires.ftc.fowlervillerobotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;


public abstract class FowlervilleAuto extends LinearOpMode {
    public abstract void routine() throws InterruptedException;
    private final ElapsedTime runtime = new ElapsedTime();
    public Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.createRobot(hardwareMap);
        waitForStart();
        try {
            routine();
        } catch (Exception e) {
            System.out.println("Auto mode done, ended early");
            return;
        }
        System.out.println("Auto mode done");
    }
    public boolean isActiveWithThrow() throws InterruptedException {
        if (!opModeIsActive()) {
            throw new InterruptedException();
        }

        return opModeIsActive();
    }

    public void runCommand(FowlervilleCommand command) throws InterruptedException{
        isActiveWithThrow();
        command.init();

        while(isActiveWithThrow() && !command.isFinished()){
            command.run();
            while(runtime.milliseconds() < 20){
               //do nothing ;)
            }
            runtime.reset();
        }

        command.end();
    }
}
