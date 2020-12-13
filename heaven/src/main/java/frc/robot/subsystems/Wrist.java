package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Wrist extends SubsystemBase
{
    private SpeedController wristController;

    public Wrist(SpeedController wristController)
    {
        this.wristController = wristController;
    }

    public void moveWrist(double speed)
    {
        if( (speed>0 && Robot.m_robotContainer.getWristPotentiometer().get() <= Constants.WRIST_LIMIT_UP)
        || (speed<0 && Robot.m_robotContainer.getWristPotentiometer().get() >= Constants.WRIST_LIMIT_DOWN) )
            wristController.set(speed);
    }
    public void stop()
    {
        wristController.stopMotor();
    }
}
