package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleCommand;

public class WaitCommand extends FowlervilleCommand {
    double seconds = 0;
    private final ElapsedTime runtime = new ElapsedTime();
    public WaitCommand(double seconds){
        this.seconds = seconds;
    }
    @Override
    public void init() {
        runtime.reset();
    }

    @Override
    public void run() {

    }

    @Override
    public Boolean isFinished() {
        return runtime.seconds() > seconds;
    }

    @Override
    public void end() {

    }
}
