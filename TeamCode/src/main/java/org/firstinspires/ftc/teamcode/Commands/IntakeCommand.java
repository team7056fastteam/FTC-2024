package org.firstinspires.ftc.teamcode.Commands;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleCommand;
import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.Robot;

public class IntakeCommand extends FowlervilleCommand {
    Intake.IntakeStates state = Intake.IntakeStates.kIdle;
    Robot robot = null;
    public IntakeCommand(Robot robot, Intake.IntakeStates state){
        this.robot = robot;
        this.state = state;
    }
    @Override
    public void init() {
        robot._intake.setIntakeState(state);
        robot._intake.run();
    }

    @Override
    public void run() {

    }

    @Override
    public Boolean isFinished() {
        return true;
    }

    @Override
    public void end() {

    }
}
