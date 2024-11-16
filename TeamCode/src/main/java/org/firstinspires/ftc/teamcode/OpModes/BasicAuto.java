package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.fowlervillerobotics.FowlervilleAuto;
import org.firstinspires.ftc.teamcode.Commands.*;
import org.firstinspires.ftc.teamcode.Intake;

@Autonomous(name="Basic Auto", group="Auto")
public class BasicAuto extends FowlervilleAuto {
    @Override
    public void routine() throws InterruptedException {
        runCommand(new DriveChassisTimed(robot,0,0.5,1));
        runCommand(new IntakeCommand(robot, Intake.IntakeStates.kForward));
        runCommand(new WaitCommand(3));
    }
}
