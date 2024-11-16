package org.firstinspires.ftc.teamcode.Commands;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleCommand;
import org.firstinspires.ftc.teamcode.Robot;

public class TurnCommand extends FowlervilleCommand {
    Robot robot;
    double desiredAngle;
    double p = 0.005;
    public TurnCommand(Robot robot, double desiredAngle){
        this.robot = robot;
        this.desiredAngle = desiredAngle;
    }
    @Override
    public void init() {
        robot.arcadeDrive(0,0,0);
    }

    @Override
    public void run() {
        double error = desiredAngle - robot.getHeadingInDegrees();
        robot.arcadeDrive(0,0,error * p);
    }

    @Override
    public Boolean isFinished() {
        return Math.abs(desiredAngle- robot.getHeadingInDegrees()) < 3;
    }

    @Override
    public void end() {
        robot.arcadeDrive(0,0,0);
    }
}
