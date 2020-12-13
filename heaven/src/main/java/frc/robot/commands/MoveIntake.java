package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveIntake extends CommandBase 
{
    private double speed;
    public MoveIntake(double speed)
    {
        this.speed = speed;
    }
    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getIntake().moveIntake(speed);
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getIntake().moveIntake(speed); 
    }
    @Override
    public boolean isFinished()
    {
        if(speed>0)
            return !Robot.m_robotContainer.getJoystick().getRawButton(Constants.INTAKE_IN_BUTTON);
        return !Robot.m_robotContainer.getJoystick().getRawButton(Constants.INTAKE_OUT_BUTTON);
    }
}
