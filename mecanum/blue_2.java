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

//@Autonomous(name="blue2", group="Autonomous")
public class blue_2 extends LinearOpMode {
    @Override
    public void runOpMode() {


        Motion1 motion = new Motion1(hardwareMap, telemetry, true);

        waitForStart();
        while (opModeIsActive()) {
            motion.forward(10);
            sleep(500);
            /*motion.spinleft(15);
            sleep(500);
            motion.backward(15);
            sleep(500);
            motion.spinright(11);*/
        }

        //drive.followTrajectorySequence(builder);

    }
}