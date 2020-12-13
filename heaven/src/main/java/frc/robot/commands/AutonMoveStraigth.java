package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutonMoveStraigth extends CommandBase
{
   private double leftSpeed;
   private double rightSpeed;

   public AutonMoveStraigth(double leftSpeed, double rightSpeed)
   {
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
   }
    @Override
  public void initialize(){
    Robot.m_robotContainer.getDriveTrain().moveTankDrive(leftSpeed, rightSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_robotContainer.getDriveTrain().moveTankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_robotContainer.getDriveTrain().stop();;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
