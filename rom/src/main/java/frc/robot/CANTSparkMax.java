package frc.robot;

import com.revrobotics.CANSparkMax;

public class CANTSparkMax extends CANSparkMax{
    public CANTSparkMax(int id) {
        super(id, MotorType.kBrushless);
    }
}
