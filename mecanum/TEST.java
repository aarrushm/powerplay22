package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//@TeleOp
public class TEST extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        // BACK POV
        DcMotor motorBackRight = hardwareMap.dcMotor.get("BR");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("FR");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("BL");
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("FL");


        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        motorFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBackRight.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            if (gamepad1.a == true) {
                motorBackRight.setPower(1);
                sleep(5000);
                motorBackRight.setPower(0);
            } else if (gamepad1.x == true) {
                motorBackLeft.setPower(1);
                sleep(5000);
                motorBackLeft.setPower(0);
            } else if (gamepad1.b == true) {
                motorFrontRight.setPower(1);
                sleep(5000);
                motorFrontRight.setPower(0);
            } else if (gamepad1.y) {
                    motorFrontLeft.setPower(1);
                    sleep(5000);
                    motorFrontLeft.setPower(0);
            } else {
                motorBackRight.setPower(0);
                motorBackLeft.setPower(0);
                motorFrontRight.setPower(0);
                motorFrontLeft.setPower(0);

            }

        }
    }
}