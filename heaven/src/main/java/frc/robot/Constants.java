/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int LEFT_ONE_DRIVE_TRAIN = 0;
    public static final int LEFT_TWO_DRIVE_TRAIN = 1;
    public static final int RIGHT_ONE_DRIVE_TRAIN = 2;
    public static final int RIGHT_TWO_DRIVE_TRAIN = 3;

    public static final int INTAKE_LEFT = 4;
    public static final int INTAKE_RIGHT = 5;

    public static final int INTAKE_IN_BUTTON = 7;
    public static final int INTAKE_OUT_BUTTON = 8;

    public static final double INTAKE_IN_SPEED = 0.5;
    public static final double INTAKE_OUT_SPEED = -0.5; 
    
    public static final int HATCH_SOLENOID_CHANNEL = 3; 
    public static final int HATCH_SOLENOID_BUTTON = 11;

    //IN 2019 CODE HAD SAME DEVICE NUMBER INTAKE_RIGHT
    public static final int ARM_MOTOR_SPEED = 5;

    public static final int ARM_POTENTIOMETER_CHANNEL = 1;
    public static final double ARM_LIMIT_UP = 69;
    public static final double ARM_LIMIT_DOWN = 109.5;

    public static final int ARM_UP_BUTTON = 5;
    public static final int ARM_DOWN_BUTTON = 3;

    public static final int WRIST_MOTOR_SPEED = 3;

    public static final int WRIST_POTENTIOMETER_CHANNEL = 0;
    public static final double WRIST_LIMIT_UP = 5.5;
    public static final double WRIST_LIMIT_DOWN = 56.4;

    public static final int WRIST_UP_BUTTON = 8;
    public static final int WRIST_DOWN_BUTTON = 10;


    public static final int PCM_PORT = 0;
    public static final int PCM_PORT_BUTTON = 9;
}
