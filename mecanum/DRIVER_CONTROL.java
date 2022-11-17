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
    private Armslide arm = null;
    private Armslide.level level = Armslide.level.LEVEL_0;
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
        SLIDE2 motor = new SLIDE2(hardwareMap, telemetry);

        Thread t = new Thread(this, "arm thread");
        t.start();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            telemetry.addData("Status", "Run Time: " + runtime.toString());

            //robot movement

            drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x,
                            -gamepad1.right_stick_x
                    )
            );

            // arm movement to assigned level (0,1,2,3)

            /*if (gamepad1.a == true) {
                level = Armslide.level.LEVEL_0;
                //RobotLog.d("Button click A");
            } else if (gamepad1.b == true) {
                level = Armslide.level.LEVEL_1;
                //RobotLog.d("Button click B");
            } else if (gamepad1.x == true) {
                level = Armslide.level.LEVEL_2;
                //RobotLog.d("Button click X");
            } else if (gamepad1.y == true) {
                level = Armslide.level.LEVEL_3;
                //RobotLog.d("Button click Y");
            } else if (gamepad1.left_bumper == true) {
                level = Armslide.level.INTAKE;
            }*/

            // intake + outtake
            if (gamepad2.right_bumper == true) {
                intake.forwardMAX();
            } else if (gamepad2.left_bumper == true) {
                intake.reverseMAX();
            }

            if (gamepad1.right_bumper == true){
                motor.runforward(2000,0);
            } else if (gamepad1.left_bumper == true){
                motor.runbackward(2000,0);
            }else{
                motor.stop();
            }


        }

        opmodeactive = false;
    }

    @Override
    public void run() {
        RobotLog.d("inside thread");
        while(opmodeactive == true) {
            //arm.MoveToLevel(level);
        }
    }
}