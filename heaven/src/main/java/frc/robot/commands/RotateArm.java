package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class RotateArm extends CommandBase
{
    private double speed;

    public RotateArm(double speed)
    {
        this.speed = speed;
    }

    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getArm().moveArm(speed); 
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getArm().moveArm(speed);
    }

    @Override 
    public void end(boolean interrupted)
    {
        Robot.m_robotContainer.getArm().stop();
    }

    @Override
    public boolean isFinished()
    {
        if(speed >0)
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ARM_DOWN_BUTTON);
        else if(speed<0)
            return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ARM_UP_BUTTON);
        return false;
    }
}
