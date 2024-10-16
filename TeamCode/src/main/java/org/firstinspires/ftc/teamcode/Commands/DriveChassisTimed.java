package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.fowlervillerobotics.FastCommand;
import org.firstinspires.ftc.teamcode.Robot;

public class DriveChassisTimed extends FastCommand {
    private Robot robot = null;
    private final ElapsedTime runtime = new ElapsedTime();
    double xPower = 0;
    double yPower = 0;
    double seconds = 0;
    public DriveChassisTimed(Robot robot, double xPower, double yPower, double seconds){
        this.robot = robot;
    }
    @Override
    public void init() {
        runtime.reset();
        robot.arcadeDrive(0,0,0);
    }

    @Override
    public void run() {
        robot.arcadeDrive(xPower,yPower,0);
    }

    @Override
    public Boolean isFinished() {
        return runtime.seconds() > seconds;
    }

    @Override
    public void end() {
        robot.arcadeDrive(0,0,0);
    }
}
