package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Slide4 extends Motor1 {
    public Slide4(HardwareMap hardwareMap, Telemetry t) {
        super(hardwareMap, t);
        motor = hardwareMap.get(DcMotorEx.class, "side");
    }

    }
