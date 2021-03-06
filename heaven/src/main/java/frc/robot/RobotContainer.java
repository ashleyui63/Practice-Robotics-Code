/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.commands.AutonMoveStraigth;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveHatch;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.RotateArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final AutonMoveStraigth moveStraigth = new AutonMoveStraigth(Constants.DT_LEFT_SPEED, Constants.DT_RIGHT_SPEED);

  private SpeedController leftOneDriveTrain, leftTwoDriveTrain, rightOneDriveTrain, rightTwoDriveTrain;
  private SpeedControllerGroup leftDriveTrain, rightDriveTrain;
  private DifferentialDrive drive;
  private DriveTrain driveTrain;
  private Joystick joystick;

  private SpeedController intakeLeft, intakeRight;
  private Intake intake;
  private Button intakeIn, intakeOut;

  private HatchIntake hatch;
  private Solenoid hatchSolenoid;
  private Button hatchSetSolenoid;

  private SpeedController armController;
  private AnalogPotentiometer armPotentiometer;
  private Arm arm;
  private Button armUp;
  private Button armDown;

  private SpeedController wristController;
  private AnalogPotentiometer wristPotentiometer;
  private Wrist wrist;
  private Button wristUp;
  private Button wristDown;




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    leftOneDriveTrain = new SteelTalonController(Constants.LEFT_ONE_DRIVE_TRAIN, false, 1);
    leftTwoDriveTrain = new SteelTalonController(Constants.LEFT_TWO_DRIVE_TRAIN, false, 1);
    rightOneDriveTrain = new SteelTalonController(Constants.RIGHT_ONE_DRIVE_TRAIN, false, 1);
    rightTwoDriveTrain = new SteelTalonController(Constants.RIGHT_TWO_DRIVE_TRAIN, false, 1);

    leftDriveTrain = new SpeedControllerGroup(leftOneDriveTrain, leftTwoDriveTrain);
    rightDriveTrain = new SpeedControllerGroup(rightOneDriveTrain, rightTwoDriveTrain);

    drive = new DifferentialDrive(leftDriveTrain, rightDriveTrain);
    driveTrain = new DriveTrain(leftDriveTrain, rightDriveTrain, drive);

    intakeLeft = new SteelTalonController(Constants.INTAKE_LEFT, false, 1);
    intakeRight = new SteelTalonController(Constants.INTAKE_RIGHT, false, 1);
    
    intake = new Intake(intakeLeft, intakeRight);

    hatchSolenoid = new Solenoid(Constants.PCM_PORT, Constants.HATCH_SOLENOID_CHANNEL);
    hatch = new HatchIntake(hatchSolenoid);

    armController = new SteelTalonController(Constants.ARM_MOTOR_SPEED, false, 1);
    armPotentiometer = new AnalogPotentiometer(Constants.ARM_POTENTIOMETER_CHANNEL, 118);
    arm = new Arm(armController);

    wristController = new SteelTalonController(Constants.WRIST_MOTOR_SPEED, false, 1);
    wristPotentiometer = new AnalogPotentiometer(Constants.WRIST_POTENTIOMETER_CHANNEL, 121);
    wrist = new Wrist(wristController);


    driveTrain.setDefaultCommand(new DriveWithJoystick());
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    joystick = new Joystick(0);
    intakeIn = new JoystickButton(joystick, Constants.INTAKE_IN_BUTTON);
    intakeOut = new JoystickButton(joystick, Constants.INTAKE_OUT_BUTTON);
    armUp = new JoystickButton(joystick, Constants.ARM_UP_BUTTON);
    armDown = new JoystickButton(joystick, Constants.ARM_DOWN_BUTTON);
    hatchSetSolenoid = new JoystickButton(joystick, Constants.HATCH_SOLENOID_BUTTON);

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));
    intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));
    armUp.whileHeld(new RotateArm(Constants.ARM_MOTOR_SPEED));
    armDown.whileHeld(new RotateArm(-Constants.ARM_MOTOR_SPEED));
    wristUp.whileHeld(new RotateArm(Constants.WRIST_MOTOR_SPEED));
    wristDown.whileHeld(new RotateArm(-Constants.WRIST_MOTOR_SPEED));


    hatchSetSolenoid.whenPressed(new MoveHatch());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return moveStraigth;
  }

  public DriveTrain getDriveTrain()
  {
    return driveTrain;
  }
  public Joystick getJoystick()
  {
    return joystick;
  }

  public Intake getIntake()
  {
    return intake;
  }

  public HatchIntake getHatchIntake()

  {
    return hatch;
  }

  public Arm getArm()
  {
    return arm;
  }

  public Potentiometer getArmPotentiometer()
  {
    return armPotentiometer;
  }

  public Wrist getWrist()
  {
    return wrist;
  }

  public Potentiometer getWristPotentiometer()
  {
    return wristPotentiometer;
  }
}
