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
    // The robot's subsystems and commands are defined here...
    private final Drivetrain m_drivetrain = new Drivetrain();
    private final XRPOnBoardIO m_onboardIO = new XRPOnBoardIO();
    private final Rangefinder m_rangefinder = new Rangefinder();
    private final ReflectanceSensor m_reflectanceSensor = new ReflectanceSensor();
    private final Arm m_arm = new Arm();

    // Assumes a gamepad plugged into channel 0
    private final CommandXboxController m_controller = new CommandXboxController(OperatorConstants.kDriverControllerPort);

    // Create SmartDashboard chooser for autonomous routines
    private final SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
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
        // Default command is arcade drive. This will run unless another command
        // is scheduled over it.
        m_drivetrain.setDefaultCommand(getArcadeDriveCommand());

        // Example of how to use the onboard IO
        Trigger userButton = new Trigger(m_onboardIO::getUserButtonPressed);
        userButton
                .onTrue(new PrintCommand("USER Button Pressed"))
                .onFalse(new PrintCommand("USER Button Released"));

        // A button: Arm to 45 degrees while held, 0 degrees when released
        Trigger joystickAButton = m_controller.a();
        joystickAButton
                .onTrue(new InstantCommand(() -> m_arm.setAngle(45.0), m_arm))
                .onFalse(new InstantCommand(() -> m_arm.setAngle(0.0), m_arm));

        // B button: Arm to 90 degrees while held, 0 degrees when released
        Trigger joystickBButton = m_controller.b();
        joystickBButton
                .onTrue(new InstantCommand(() -> m_arm.setAngle(90.0), m_arm))
                .onFalse(new InstantCommand(() -> m_arm.setAngle(0.0), m_arm));

        // Setup SmartDashboard options for autonomous routines
        m_chooser.setDefaultOption("Auto Routine Distance", new AutonomousDistance(m_drivetrain));
        m_chooser.addOption("Auto Routine Time", new AutonomousTime(m_drivetrain));
        SmartDashboard.putData(m_chooser);
    }

    /**
     * Returns the selected autonomous command from the SmartDashboard chooser to the main {@link Robot} class.
     *
     * @return the command to run in autonomous mode
     */
    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }

    /**
     * Returns the default teleop driving command (arcade drive) to the main {@link Robot} class.
     *
     * @return the command to run in teleop mode
     */
    public Command getArcadeDriveCommand() {
        return new ArcadeDrive(
                m_drivetrain, () -> -m_controller.getLeftY(), () -> -m_controller.getRightX());
    }
}
