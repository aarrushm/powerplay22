package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;

public class Armslide extends Motor {


    static final int LEVEL_0_TP = 0;
    static final int INTAKE_TP = 100;
    static final int LEVEL_1_TP = 640;
    static final int LEVEL_2_TP = 1200;
    static final int LEVEL_3_TP = 10000;
    enum level{

        LEVEL_0,
        INTAKE,
        LEVEL_1,
        LEVEL_2,
        LEVEL_3
    }

    private ElapsedTime time = new ElapsedTime();
    public Armslide(HardwareMap hardwareMap, Telemetry t, boolean runtoposition){
        super(hardwareMap,t);
        motor = hardwareMap.get(DcMotorEx.class, "arm");
        if (runtoposition == true){
            super.setTargetPosition(0);
            setModeResetEncoder();
            setModeRunToPosition();
            time.reset();
        }

    }

    public boolean MoveToLevel(level l){
        if (l == level.LEVEL_0) {
            runforward(LEVEL_0_TP);
            //RobotLog.d("MoveToLevel 0");
        } else if (l == level.LEVEL_1) {
            runforward(LEVEL_1_TP);
            //RobotLog.d("MoveToLevel 1");
        } else if (l == level.LEVEL_2) {
            runforward(LEVEL_2_TP);
            //RobotLog.d("MoveToLevel 2");
        } else if (l == level.INTAKE) {
            runforward(INTAKE_TP);
            //RobotLog.d("MoveToLevel 2");
        } else {
            runforward(LEVEL_3_TP);
            //RobotLog.d("MoveToLevel 3");
        }
    return true;
    }
}