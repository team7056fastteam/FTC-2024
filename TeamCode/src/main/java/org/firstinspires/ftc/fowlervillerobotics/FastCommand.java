package org.firstinspires.ftc.fowlervillerobotics;

public abstract class FastCommand {
    public abstract void init();

    public abstract void run();

    public abstract Boolean isFinished();

    public abstract void end();

}