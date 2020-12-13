package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;


public class Arm extends SubsystemBase
{
    private SpeedController armController;
    


    public Arm(SpeedController armSpeedController)
    {
        this.armController = armSpeedController;
        
    }
    
    public void moveArm(double speed)
    {
        if( (speed>0 && Robot.m_robotContainer.getArmPotentiometer().get() <= Constants.ARM_LIMIT_UP)
        || (speed<0 && Robot.m_robotContainer.getArmPotentiometer().get() >= Constants.ARM_LIMIT_DOWN) )
            armController.set(speed);
    }  

    public void stop()
    {
        armController.stopMotor();
    }
}