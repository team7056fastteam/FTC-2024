package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleCommand;
import org.firstinspires.ftc.teamcode.Robot;

public class TestCommand extends FowlervilleCommand {
    Robot robot = null;
    double pos;
    private final ElapsedTime runtime = new ElapsedTime();
    public TestCommand(Robot robot, double pos){
        this.robot = robot;
        this.pos = pos;
    }
    @Override
    public void init() {
        runtime.reset();
        robot.setHamPos(pos);
    }

    @Override
    public void run() {

    }

    @Override
    public Boolean isFinished() {
        return runtime.seconds() >= 1;
    }

    @Override
    public void end() {
    }
}
