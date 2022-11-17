package org.firstinspires.ftc.teamcode.mecanum;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.freightfrenzy.Arm;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;
import org.firstinspires.ftc.teamcode.mecanum.VuforiaFTC;

@Autonomous(name="blue left", group="Autonomous")
public class BLUE_LEFT extends LinearOpMode {
    @Override
    public void runOpMode() {

        Motor motor = new Motor(hardwareMap, telemetry);
        VuforiaFTC vf = new VuforiaFTC(hardwareMap, telemetry);
        Armslide arm = new Armslide(hardwareMap, telemetry,true);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Servos intake = new Servos(hardwareMap, telemetry);
        int x = 4;

        VuforiaFTC.barcode_level BarcodeLevel = vf.BarcodeLevel();

        waitForStart();
        while (opModeIsActive()) {

            intake.forwardMAX();
            drive.setPoseEstimate(new Pose2d());
            Trajectory traj0 = drive.trajectoryBuilder(new Pose2d())
                    .lineToSplineHeading(new Pose2d(15, -26.5, Math.toRadians(-90)))
                    .build();
            Trajectory traj1 = drive.trajectoryBuilder(traj0.end())
                    .back(6)
                    .build();
            Trajectory traj2a = drive.trajectoryBuilder(traj0.start())
                    .lineToSplineHeading(new Pose2d(-35, -36, Math.toRadians(90)))
                    .build();
            Trajectory traj2b = drive.trajectoryBuilder(traj0.start())
                    .lineToSplineHeading(new Pose2d(5, -36, Math.toRadians(0)))
                    .build();
            Trajectory traj2c = drive.trajectoryBuilder(traj0.start())
                    .lineToSplineHeading(new Pose2d(35, -36, Math.toRadians(0)))
                    .build();

            if (BarcodeLevel == VuforiaFTC.barcode_level.SLEEVE_1){
                arm.MoveToLevel(Armslide.level.LEVEL_1);
                drive.followTrajectory(traj0);
                intake.reverseMAX();
                sleep(2000);
                //drive.followTrajectory(traj1);
                //sleep(2000);
                //drive.turn(Math.toRadians(-90));
                //sleep(2000);
                drive.followTrajectory(traj2a);
            } else if (BarcodeLevel == VuforiaFTC.barcode_level.SLEEVE_2){
                arm.MoveToLevel(Armslide.level.LEVEL_1);
                drive.followTrajectory(traj0);
                intake.reverseMAX();
                sleep(2000);
                //drive.followTrajectory(traj1);
                //sleep(2000);
                //drive.turn(Math.toRadians(-90));
                //sleep(2000);
                drive.followTrajectory(traj2b);
            } else {
                arm.MoveToLevel(Armslide.level.LEVEL_1);
                drive.followTrajectory(traj0);
                intake.reverseMAX();
                sleep(2000);
                //drive.followTrajectory(traj1);
                //sleep(2000);
                //drive.turn(Math.toRadians(90));
                //sleep(2000);
                drive.followTrajectory(traj2c);
                }
            break;
            }
        }
    }
