package org.firstinspires.ftc.teamcode.mecanum;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;
import org.firstinspires.ftc.teamcode.mecanum.Motion1;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

@Autonomous(name="red1", group="Autonomous")
public class red_1 extends LinearOpMode {
    @Override
    public void runOpMode() {

        Motor motor = new Motor (hardwareMap, telemetry);

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        int x = 4;

        if (x>1){
            Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(110)
                    .build();
            Trajectory traj2 = drive.trajectoryBuilder(new Pose2d())
                    .back(50)
                    .build();
            Trajectory traj3 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(30)
                    .build();
            Trajectory traj4 = drive.trajectoryBuilder(new Pose2d())
                    .forward(15)
                    .build();
            Trajectory traj5 = drive.trajectoryBuilder(new Pose2d())
                    .back(15)
                    .build();
            Trajectory traj6 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(22)
                    .build();
            Trajectory traj7 = drive.trajectoryBuilder(new Pose2d())
                    .forward(40)
                    .build();
            Trajectory traj8 = drive.trajectoryBuilder(new Pose2d())
                    .back(40)
                    .build();
            Trajectory traj9 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(15)
                    .build();
            Trajectory traj10 = drive.trajectoryBuilder(new Pose2d())
                    .forward(15)
                    .build();
            Trajectory traj11 = drive.trajectoryBuilder(new Pose2d())
                    .back(15)
                    .build();
            Trajectory traj12 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(15)
                    .build();
            Trajectory traj13 = drive.trajectoryBuilder(new Pose2d())
                    .forward(20)
                    .build();
            Trajectory traj14 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(65)
                    .build();

            drive.followTrajectory(traj1);
            //move arm
            sleep(100);
            drive.followTrajectory(traj2);
            sleep(100);
            drive.followTrajectory(traj3);
            drive.followTrajectory(traj4);
            drive.followTrajectory(traj5);
            sleep(100);
            drive.followTrajectory(traj6);
            sleep(100);
            drive.followTrajectory(traj7);
            sleep(100);
            drive.followTrajectory(traj8);
            sleep(100);
            drive.followTrajectory(traj9);
            sleep(100);
            drive.followTrajectory(traj10);
            sleep(100);
            drive.followTrajectory(traj11);
            sleep(100);
            drive.followTrajectory(traj12);
            sleep(100);
            drive.followTrajectory(traj13);
            sleep(100);
            drive.followTrajectory(traj14);
            sleep(100);

        }else if (x<1){
            Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(55)
                    .build();
            Trajectory traj2 = drive.trajectoryBuilder(new Pose2d())
                    .back(20)
                    .build();
            Trajectory traj3 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(10)
                    .build();
            Trajectory traj4 = drive.trajectoryBuilder(new Pose2d())
                    .forward(5)
                    .build();
            Trajectory traj5 = drive.trajectoryBuilder(new Pose2d())
                    .back(5)
                    .build();
            Trajectory traj6 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(12)
                    .build();
            Trajectory traj7 = drive.trajectoryBuilder(new Pose2d())
                    .forward(30)
                    .build();
            Trajectory traj8 = drive.trajectoryBuilder(new Pose2d())
                    .back(30)
                    .build();
            Trajectory traj9 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(5)
                    .build();
            Trajectory traj10 = drive.trajectoryBuilder(new Pose2d())
                    .forward(5)
                    .build();
            Trajectory traj11 = drive.trajectoryBuilder(new Pose2d())
                    .back(5)
                    .build();
            Trajectory traj12 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(5)
                    .build();
            Trajectory traj13 = drive.trajectoryBuilder(new Pose2d())
                    .forward(10)
                    .build();
            Trajectory traj14 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(65)
                    .build();
            Trajectory traj15 = drive.trajectoryBuilder(new Pose2d())
                    .back(5)
                    .build();

            drive.followTrajectory(traj1);
            //move arm
            sleep(100);
            drive.followTrajectory(traj2);
            sleep(100);
            drive.followTrajectory(traj3);
            drive.followTrajectory(traj4);
            drive.followTrajectory(traj5);
            sleep(100);
            drive.followTrajectory(traj6);
            sleep(100);
            drive.followTrajectory(traj7);
            sleep(100);
            drive.followTrajectory(traj8);
            sleep(100);
            drive.followTrajectory(traj9);
            sleep(100);
            drive.followTrajectory(traj10);
            sleep(100);
            drive.followTrajectory(traj11);
            sleep(100);
            drive.followTrajectory(traj12);
            sleep(100);
            drive.followTrajectory(traj13);
            sleep(100);
            drive.followTrajectory(traj14);
            sleep(100);
        }else if (x>5){
            Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(55)
                    .build();
            Trajectory traj2 = drive.trajectoryBuilder(new Pose2d())
                    .back(20)
                    .build();
            Trajectory traj3 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(10)
                    .build();
            Trajectory traj4 = drive.trajectoryBuilder(new Pose2d())
                    .forward(5)
                    .build();
            Trajectory traj5 = drive.trajectoryBuilder(new Pose2d())
                    .back(5)
                    .build();
            Trajectory traj6 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(12)
                    .build();
            Trajectory traj7 = drive.trajectoryBuilder(new Pose2d())
                    .forward(30)
                    .build();
            Trajectory traj8 = drive.trajectoryBuilder(new Pose2d())
                    .back(30)
                    .build();
            Trajectory traj9 = drive.trajectoryBuilder(new Pose2d())
                    .strafeLeft(5)
                    .build();
            Trajectory traj10 = drive.trajectoryBuilder(new Pose2d())
                    .forward(5)
                    .build();
            Trajectory traj11 = drive.trajectoryBuilder(new Pose2d())
                    .back(5)
                    .build();
            Trajectory traj12 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(5)
                    .build();
            Trajectory traj13 = drive.trajectoryBuilder(new Pose2d())
                    .forward(10)
                    .build();
            Trajectory traj14 = drive.trajectoryBuilder(new Pose2d())
                    .strafeRight(65)
                    .build();
            Trajectory traj15 = drive.trajectoryBuilder(new Pose2d())
                    .forward(5)
                    .build();

            drive.followTrajectory(traj1);
            //move arm
            sleep(100);
            drive.followTrajectory(traj2);
            sleep(100);
            drive.followTrajectory(traj3);
            drive.followTrajectory(traj4);
            drive.followTrajectory(traj5);
            sleep(100);
            drive.followTrajectory(traj6);
            sleep(100);
            drive.followTrajectory(traj7);
            sleep(100);
            drive.followTrajectory(traj8);
            sleep(100);
            drive.followTrajectory(traj9);
            sleep(100);
            drive.followTrajectory(traj10);
            sleep(100);
            drive.followTrajectory(traj11);
            sleep(100);
            drive.followTrajectory(traj12);
            sleep(100);
            drive.followTrajectory(traj13);
            sleep(100);
            drive.followTrajectory(traj14);
            sleep(100);
        }
    }
}