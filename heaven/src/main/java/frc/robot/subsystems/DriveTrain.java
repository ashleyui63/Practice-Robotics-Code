package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{

    private SpeedControllerGroup left,right;
    private DifferentialDrive drive;

    public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive)
    {
        this.drive = drive;
        this.left = left;
        this.right = right;
    }

    public void takeJoystickInputs(Joystick joy)
    {
        drive.arcadeDrive(joy.getY(), joy.getZ());
    }

    public void moveTankDrive(double leftspeed, double rightspeed)
    {
        left.set(leftspeed);
        right.set(rightspeed);
    }
    public void stop(){
        left.stopMotor();
        right.stopMotor();
    }
    public void setLeft(SpeedControllerGroup left)
    {
        this.left = left;
    }

    public void setRight(SpeedControllerGroup right)
    {
        this.right = right;
    }

    public void setDrive(DifferentialDrive drive)
    {
        this.drive = drive;
    }

    public SpeedControllerGroup getLeft()
    {
        return left;
    }

    public SpeedControllerGroup getRight()
    {
        return right;
    }
    public DifferentialDrive getDrive()
    {
        return drive;
    }

}