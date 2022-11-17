package org.firstinspires.ftc.teamcode.mecanum;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.freightfrenzy.Arm;
import org.firstinspires.ftc.teamcode.freightfrenzy.Button;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;

/**
 * This is a simple teleop routine for testing localization. Drive the robot around like a normal
 * teleop routine and make sure the robot's estimated pose matches the robot's actual pose (slight
 * errors are not out of the ordinary, especially with sudden drive motions). The goal of this
 * exercise is to ascertain whether the localizer has been configured properly (note: the pure
 * encoder localizer heading may be significantly off if the track width has not been tuned).
 */

//@TeleOp(group = "drive")
//@Disabled
public class MecanumController extends LinearOpMode implements Runnable {

    public Armslide arm = null;
    public Armslide.level level = Armslide.level.LEVEL_0;
    private boolean opmodeactive = false;

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Servos intake = new Servos(hardwareMap, telemetry);
        slide slide = new slide(hardwareMap, telemetry);
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm = new Armslide(hardwareMap, telemetry, true);
        /*Button button_a = new Button(telemetry, Button.ButtonType.BUTTON_A, gamepad1);
        Button button_b = new Button(telemetry, Button.ButtonType.BUTTON_B, gamepad1);
        Button button_x = new Button(telemetry, Button.ButtonType.BUTTON_X, gamepad1);
        Button button_y = new Button(telemetry, Button.ButtonType.BUTTON_Y, gamepad1);
        Button leftbumper = new Button(telemetry, Button.ButtonType.LEFTBUMPER, gamepad1);
        Button rightbumper = new Button(telemetry, Button.ButtonType.RIGHTBUMPER, gamepad1);
        Button joystickpush_l = new Button(telemetry, Button.ButtonType.L_STICK_BUTTON, gamepad1);
        Button joystickpush_r = new Button(telemetry, Button.ButtonType.R_STICK_BUTTON, gamepad1);*/

        waitForStart();

        while (!isStopRequested()) {
            drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x,
                            -gamepad1.right_stick_x
                    )
            );

            drive.update();

            Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();

            if (gamepad1.right_bumper == true) {
                intake.forwardMAX();
            } else if (gamepad1.left_bumper == true) {
                intake.reverseMAX();
            }

            /*if (gamepad2.y == true) {
                slide.runforward(2000,0);
            } else if (gamepad2.a == true) {
                slide.runbackward(2000, 0);
            } else {
                slide.stop();
            }*/

            if (gamepad1.a == true) {
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
            } else if (gamepad2.a == true) {
                level = Armslide.level.INTAKE;
            }
        }
        opmodeactive = false;

    }

    @Override
    public void run() {
        RobotLog.d("inside thread");
        while (opmodeactive == true) {
            arm.MoveToLevel(level);
        }
    }
}
