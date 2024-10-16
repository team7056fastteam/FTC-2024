package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.fowlervillerobotics.FastAuto;
import org.firstinspires.ftc.teamcode.Commands.DriveChassisTimed;

@Autonomous(name="Basic Auto", group="Auto")
public class BasicAuto extends FastAuto {
    @Override
    public void routine() throws InterruptedException {
        runCommand(new DriveChassisTimed(robot,0,2,3));
    }
}
