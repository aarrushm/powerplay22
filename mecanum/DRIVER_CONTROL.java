package org.firstinspires.ftc.teamcode.mecanum;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.freightfrenzy.Arm;
import org.firstinspires.ftc.teamcode.freightfrenzy.Button;
import org.firstinspires.ftc.teamcode.freightfrenzy.Crsl;
import org.firstinspires.ftc.teamcode.freightfrenzy.Intake;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motion;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;

@TeleOp(name="DRIVER_CONTROL", group="Linear Opmode") // @Autonomous(...) is the other common choice
public class DRIVER_CONTROL extends LinearOpMode implements Runnable {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private boolean opmodeactive = false;
    @Override
    public void runOpMode() {
        opmodeactive = true;
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        Servos intake = new Servos(hardwareMap, telemetry);
        Slide4 side = new Slide4(hardwareMap, telemetry);
        Slide3 motor = new Slide3(hardwareMap, telemetry);

        Thread t = new Thread(this, "arm thread");
        t.start();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            telemetry.addData("Status", "Run Time: " + runtime.toString());

            //robot movement

            drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y*0.5,
                            -gamepad1.left_stick_x*0.5,
                            -gamepad1.right_stick_x*0.5
                    )
            );


            // intake + outtake5
            if (gamepad2.right_bumper == true) {
                intake.forwardMAX();
            } else if (gamepad2.left_bumper == true) {
                intake.reverseMAX();
            }

            if (gamepad1.right_bumper == true){
                motor.runforward(7000,0);
            } else if (gamepad1.left_bumper == true){
                motor.runbackward(7000,0);
            }else{
                motor.stop();
            }

            if (gamepad2.a == true){
                side.runforward(600,0);
            } else if (gamepad2.b == true){
                side.runbackward(600,0);
            } else {
                side.stop();
            }


        }

        opmodeactive = false;
    }

    @Override
    public void run() {
        RobotLog.d("inside thread");
        while(opmodeactive == true) {
        }
    }
}