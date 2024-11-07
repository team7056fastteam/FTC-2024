package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleAuto;
import org.firstinspires.ftc.teamcode.Commands.DriveChassisTimed;
import org.firstinspires.ftc.teamcode.Commands.TestCommand;

@Autonomous(name="Basic Auto", group="Auto")
public class BasicAuto extends FowlervilleAuto {
    @Override
    public void routine() throws InterruptedException {
        //(new DriveChassisTimed(robot,0,0.5,3));
        runCommand(new TestCommand(robot,1));
        runCommand(new TestCommand(robot,0.8));
        runCommand(new TestCommand(robot,.6));
        runCommand(new TestCommand(robot,.4));
        runCommand(new TestCommand(robot,1));
        runCommand(new TestCommand(robot,0.8));
        runCommand(new TestCommand(robot,.6));
        runCommand(new TestCommand(robot,.4));
        runCommand(new TestCommand(robot,1));
        runCommand(new TestCommand(robot,0.8));
        runCommand(new TestCommand(robot,.6));
        runCommand(new TestCommand(robot,.4));
    }
}
