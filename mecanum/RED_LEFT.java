package org.firstinspires.ftc.teamcode.mecanum;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;

@Autonomous(name="red left", group="Autonomous")
public class RED_LEFT extends LinearOpMode {
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


            Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(50.5)
                    .build();
            Trajectory traj2 = drive.trajectoryBuilder(new Pose2d())
                    .forward(2)
                    .build();
            Trajectory traj3 = drive.trajectoryBuilder(new Pose2d())
                    .back(2)
                    .build();
            Trajectory traj4 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(10)
                    .build();

            if (BarcodeLevel == VuforiaFTC.barcode_level.SLEEVE_1){
                Trajectory traj5 = drive.trajectoryBuilder(new Pose2d())
                        .forward(24)
                        .build();
                drive.followTrajectory(traj1);
                sleep(100);
                arm.MoveToLevel(Armslide.level.LEVEL_1);
                drive.followTrajectory(traj2);
                sleep(100);
                intake.reverseMAX();
                drive.followTrajectory(traj3);
                drive.followTrajectory(traj4);
                drive.followTrajectory(traj5);
            } else if (BarcodeLevel == VuforiaFTC.barcode_level.SLEEVE_2){
                drive.followTrajectory(traj1);
                sleep(100);
                arm.MoveToLevel(Armslide.level.LEVEL_1);
                drive.followTrajectory(traj2);
                sleep(100);
                intake.reverseMAX();
                drive.followTrajectory(traj3);
                drive.followTrajectory(traj4);
            } else {
                Trajectory traj6 = drive.trajectoryBuilder(new Pose2d())
                        .back(24)
                        .build();
                drive.followTrajectory(traj1);
                sleep(100);
                arm.MoveToLevel(Armslide.level.LEVEL_1);
                drive.followTrajectory(traj2);
                sleep(100);
                intake.reverseMAX();
                drive.followTrajectory(traj3);
                drive.followTrajectory(traj4);
                drive.followTrajectory(traj6);
                }
            break;
            }
        }
    }
