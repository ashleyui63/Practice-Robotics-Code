package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveHatch extends CommandBase
{
    private boolean shift = true;

    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getHatchIntake().MoveHatch(shift);
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getHatchIntake().MoveHatch(shift);   
    }

    @Override
    public void end(boolean interrupted)
    {
        shift = !shift;
    }

    @Override
    public boolean isFinished()
    {
        return !Robot.m_robotContainer.getJoystick().getRawButton(Constants.PCM_PORT_BUTTON);
    }

    public void setShift(boolean shift)
    {
        this.shift = shift;
    }
    
    public boolean getShift()
    {
        return shift;
    }
}
