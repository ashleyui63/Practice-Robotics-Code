package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

public class HatchIntake {

    private Solenoid sole;
    public HatchIntake(Solenoid sole)
    {
        this.sole = sole;
    }

    public void MoveHatch(boolean shift)
    {
        sole.set(shift);
    }

    public Solenoid getSolenoid()
    {
        return sole;
    }
}
