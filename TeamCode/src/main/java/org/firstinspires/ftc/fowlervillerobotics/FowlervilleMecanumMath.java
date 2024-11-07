package org.firstinspires.ftc.fowlervillerobotics;

public class FowlervilleMecanumMath {
    public static ChassisState getChassisStateFromPower(double x, double y, double r, double heading){
        double rotX = x * Math.cos(-heading) - y * Math.sin(-heading);
        double rotY = x * Math.sin(-heading) + y * Math.cos(-heading);

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(r), 1);

        double frontLeftPower = (rotY + rotX + r) / denominator;
        double backLeftPower = (rotY - rotX + r) / denominator;
        double frontRightPower = (rotY - rotX - r) / denominator;
        double backRightPower = (rotY +rotX - r) / denominator;

        return new ChassisState(frontLeftPower,backLeftPower,frontRightPower,backRightPower);
    }
    public static class ChassisState {
        private double leftFrontDrive = 0;
        private double leftRearDrive = 0;
        private double rightFrontDrive = 0;
        private double rightRearDrive = 0;
        public ChassisState(double leftFrontDrive, double leftRearDrive,double rightFrontDrive,double rightRearDrive){
            this.leftFrontDrive = leftFrontDrive;
            this.leftRearDrive = leftRearDrive;
            this.rightFrontDrive = rightFrontDrive;
            this.rightRearDrive = rightRearDrive;
        }

        public double getLeftFrontDrive() {
            return leftFrontDrive;
        }
        public double getLeftRearDrive(){
            return leftRearDrive;
        }

        public double getRightFrontDrive() {
            return rightFrontDrive;
        }

        public double getRightRearDrive() {
            return rightRearDrive;
        }
    }
}
