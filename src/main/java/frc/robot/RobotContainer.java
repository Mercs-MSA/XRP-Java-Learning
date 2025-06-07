// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutonomousDistance;
import frc.robot.commands.AutonomousTime;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.Constants.OperatorConstants;

public class RobotContainer {
    private final Drivetrain m_drivetrain = new Drivetrain();
    private final XRPOnBoardIO m_onboardIO = new XRPOnBoardIO();
    private final Arm m_arm = new Arm();

    private final CommandXboxController m_controller = new CommandXboxController(OperatorConstants.kDriverControllerPort);

    private final SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        m_drivetrain.setDefaultCommand(getArcadeDriveCommand());

        Trigger userButton = new Trigger(m_onboardIO::getUserButtonPressed);
        userButton
                .onTrue(new PrintCommand("USER Button Pressed"))
                .onFalse(new PrintCommand("USER Button Released"));

        Trigger joystickAButton = m_controller.a();
        joystickAButton
                .onTrue(new InstantCommand(() -> m_arm.setAngle(45.0), m_arm))
                .onFalse(new InstantCommand(() -> m_arm.setAngle(0.0), m_arm));

        Trigger joystickBButton = m_controller.b();
        joystickBButton
                .onTrue(new InstantCommand(() -> m_arm.setAngle(90.0), m_arm))
                .onFalse(new InstantCommand(() -> m_arm.setAngle(0.0), m_arm));

        m_chooser.setDefaultOption("Auto Routine Distance", new AutonomousDistance(m_drivetrain));
        m_chooser.addOption("Auto Routine Time", new AutonomousTime(m_drivetrain));
        SmartDashboard.putData(m_chooser);
    }

    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }

    public Command getArcadeDriveCommand() {
        return new ArcadeDrive(
                m_drivetrain, () -> -m_controller.getLeftY(), () -> -m_controller.getRightX());
    }
}


/**
 * 
 * 1. What is the main purpose of the RobotContainer class in a WPILib Command-based robot project?
 * 
 * 2. Which subsystems are instantiated as fields in this class?
 * 
 * 3. What is the type and purpose of m_controller?
 * 
 * 4. What does the SendableChooser<Command> m_chooser do?
 * 
 * 5. In the constructor, what method is called to set up button bindings?
 * 
 * 6. What is the default command for the drivetrain, and how is it set?
 * 
 * 7. How is the onboard IO user button handled in the code?
 * 
 * 8. What happens when the A button on the Xbox controller is pressed and released?
 * 
 * 9. What happens when the B button on the Xbox controller is pressed and released?
 * 
 * 10. How are autonomous routines added to the SmartDashboard chooser?
 * 
 * 11. What does the getAutonomousCommand() method return?
 * 
 * 12. What does the getArcadeDriveCommand() method return, and what does it do?
 * 
 * 13. Why are lambda expressions (e.g., () -> -m_controller.getLeftY()) used in the ArcadeDrive command?
 * 
 * 14. What is the purpose of the configureButtonBindings() method?
 * 
 * 15. How would you add a new button binding for the Xbox controller’s X button to move the arm to 135 degrees while held?
 * 
 */