### WPILib Getting Started with XRP

Estimated time: 2-4 hours with troubleshooting

Start with the [XRP Hardware, Assembly and Imaging](https://docs.wpilib.org/en/latest/docs/xrp-robot/hardware-and-imaging.html) page, which will start by instructing you to assemble the XRP robot using the [XRP User Guide](https://xrpusersguide.readthedocs.io/en/latest/course/building.html). Follow the XRP User Guide instructions up to and including the point where the XRP arm is mounted to the servo. Then return to the XRP Hardware, Assembly and Imaging page and follow the instructions to image the XRP firmware. Finally, perform the test boot up to check that things are working.

The next three pages, [Getting to know your XRP](https://docs.wpilib.org/en/latest/docs/xrp-robot/getting-to-know-xrp.html), [XRP Hardware Support](https://docs.wpilib.org/en/latest/docs/xrp-robot/hardware-support.html), and [The XRP Web UI](https://docs.wpilib.org/en/latest/docs/xrp-robot/web-ui.html) are deeper technical specifications and are not required information for these lessons. You may skim through the information or skip it.

Before moving to the last step where code is added to the robot, you will need to install the WPILib software by following [the WPILib setup instructions](https://docs.wpilib.org/en/latest/docs/zero-to-robot/step-2/wpilib-setup.html). Choose all default and "fastest" options when installing. You also need to [download the Git version control system](https://git-scm.com/downloads) and run the installer. Choose all default options when installing.

Finally, read through and follow the steps for the last page: [Programming the XRP](https://docs.wpilib.org/en/latest/docs/xrp-robot/programming-xrp.html). These instructions will get the example program onto the robot and allow you to drive and operate.



### Lesson Helpers

When looking at code in the VS Code application, there is a built in tool called Intellisense which has the ability to show documentation about functions, classes, variable types, and more by just hovering your mouse cursor over the text you want to learn more about. This taps directly into the documentation found here: [WPILib Java Docs](https://github.wpilib.org/allwpilib/docs/release/java/index.html). But the documentation can also be used on it's own as a website directory for all aspects of the code. Using Intellisense and the search feature of the documentation website are two powerful tools in understanding what a line of code does.



### Lesson 1 - Understanding Robot.java

Estimated time: 30 minutes

Begin Lesson 1 by downloading the [Lesson 1 code](https://github.com/Mercs-MSA/XRP-Java-Learning/archive/refs/heads/lessons/lesson-1.zip) and unzipping the directory. Open the folder in VS Code, and find the file `src/main/java/frc/robot/Robot.java`. Read through the code in this file, and then attempt to answer the following questions which are also written as comments at the bottom of the file.

1. What is the purpose of the RobotContainer in this class, and when is it instantiated?
2. What does the robotPeriodic() method do, and why is it important for the Command-based framework?
3. What happens in the autonomousInit() method?
4. Why is m_autonomousCommand.cancel(); called in teleopInit()?
5. What is the purpose of the testInit() method?
6. Which method is called every 20 ms, regardless of the robot mode?
7. What would happen if you removed the call to CommandScheduler.getInstance().run(); from robotPeriodic()?
8. What is the difference between autonomousPeriodic() and teleopPeriodic()?
9. How does the robot know which autonomous command to run?



### Lesson 2 - Understanding RobotContainer.java

Estimated time: 30 minutes

Begin Lesson 1 by downloading the [Lesson 1 code](https://github.com/Mercs-MSA/XRP-Java-Learning/archive/refs/heads/lessons/lesson-2.zip) and unzipping the directory. Open the folder in VS Code, and find the file `src/main/java/frc/robot/RobotContainer.java`. Read through the code in this file, and then attempt to answer the following questions which are also written as comments at the bottom of the file.

1. What is the main purpose of the RobotContainer class in a WPILib Command-based robot project?
2. Which subsystems are instantiated as fields in this class?
3. What is the type and purpose of m_controller?
4. What does the SendableChooser<Command> m_chooser do?
5. In the constructor, what method is called to set up button bindings?
6. What is the default command for the drivetrain, and how is it set?
7. How is the onboard IO user button handled in the code?
8. What happens when the A button on the Xbox controller is pressed and released?
9. What happens when the B button on the Xbox controller is pressed and released?
10. How are autonomous routines added to the SmartDashboard chooser?
11. What does the getAutonomousCommand() method return?
12. What does the getArcadeDriveCommand() method return, and what does it do?
13. Why are lambda expressions (e.g., () -> -m_controller.getLeftY()) used in the ArcadeDrive command?
14. What is the purpose of the configureButtonBindings() method?
15. How would you add a new button binding for the Xbox controller’s X button to move the arm to 135 degrees while held?
