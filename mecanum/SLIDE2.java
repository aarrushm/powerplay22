package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.freightfrenzy.Motor;

public class SLIDE2 extends Motor {
    public SLIDE2(HardwareMap hardwareMap, Telemetry t){
        super(hardwareMap,t);
        motor = hardwareMap.get(DcMotorEx.class, "arm");
    }
}