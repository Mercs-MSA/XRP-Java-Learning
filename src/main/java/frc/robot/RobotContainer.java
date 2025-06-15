// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutonomousDistance;
import frc.robot.commands.AutonomousTime;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.sensors.Rangefinder;
import frc.robot.sensors.ReflectanceSensor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.Constants.OperatorConstants;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // What is the type and constructor for the drivetrain subsystem?
    private final _________ m_drivetrain = new _________();

    // What is the type and constructor for the onboard IO subsystem?
    private final _________ m_onboardIO = new _________();

    // What is the type and constructor for the rangefinder sensor?
    private final _________ m_rangefinder = new _________();

    // What is the type and constructor for the reflectance sensor?
    private final _________ m_reflectanceSensor = new _________();

    // What is the type and constructor for the arm subsystem?
    private final _________ m_arm = new _________();

    // What is the type and constructor for the Xbox controller used for operator input?
    private final _________ m_controller = new _________(OperatorConstants.kDriverControllerPort);

    // What is the type and constructor for the SmartDashboard autonomous routine chooser?
    private final _________ m_chooser = new _________<>();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // What method should be called in the constructor to set up button bindings?
        __________();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // What method sets the default command for the drivetrain subsystem?
        m_drivetrain.______________(getArcadeDriveCommand());

        // Example of how to use the onboard IO
        Trigger userButton = new Trigger(m_onboardIO::getUserButtonPressed);
        userButton
                .onTrue(new PrintCommand("USER Button Pressed"))
                .onFalse(new PrintCommand("USER Button Released"));

        // What method gets the A button trigger from the Xbox controller?
        Trigger joystickAButton = m_controller.___();
        joystickAButton
                .onTrue(new InstantCommand(() -> m_arm.setAngle(45.0), m_arm))
                .onFalse(new InstantCommand(() -> m_arm.setAngle(0.0), m_arm));

        // What method gets the B button trigger from the Xbox controller?
        Trigger joystickBButton = m_controller.___();
        joystickBButton
                .onTrue(new InstantCommand(() -> m_arm.setAngle(90.0), m_arm))
                .onFalse(new InstantCommand(() -> m_arm.setAngle(0.0), m_arm));

        // What method sets the default autonomous option in the chooser?
        m_chooser.______________________("Auto Routine Distance", new AutonomousDistance(m_drivetrain));
        // What method adds an additional autonomous option to the chooser?
        m_chooser.__________("Auto Routine Time", new AutonomousTime(m_drivetrain));
        // What method puts the chooser on the SmartDashboard?
        SmartDashboard.________(m_chooser);
    }

    /**
     * Returns the selected autonomous command from the SmartDashboard chooser to the main {@link Robot} class.
     *
     * @return the command to run in autonomous mode
     */
    public Command getAutonomousCommand() {
        // What method gets the selected autonomous command from the chooser?
        return m_chooser.__________();
    }

    /**
     * Returns the default teleop driving command (arcade drive) to the main {@link Robot} class.
     *
     * @return the command to run in teleop mode
     */
    public Command getArcadeDriveCommand() {
        // What is the name of the command class used for arcade drive, and what methods get the left Y and right X values from the controller?
        return new _________(
                m_drivetrain, () -> -m_controller._________(), () -> -m_controller._________());
    }
}