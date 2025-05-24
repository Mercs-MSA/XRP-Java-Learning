package frc.robot.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rangefinder extends SubsystemBase {
    private final XRPRangefinder m_rangefinder;

    /**
     * Creates a new RangeFinder.
     */
    public Rangefinder() {
        m_rangefinder = new XRPRangefinder();
    }

    /**
     * Get the current distance reading from the sensor.
     *
     * @return Distance in inches
     */
    public double getDistanceInches() {
        return m_rangefinder.getDistanceInches();
    }

    /**
     * Get the current distance reading from the sensor.
     *
     * @return Distance in meters
     */
    public double getDistanceMeters() {
        return m_rangefinder.getDistanceMeters();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Rangefinder Distance (in)", m_rangefinder.getDistanceInches());
        SmartDashboard.putNumber("Rangefinder Distance (m)", m_rangefinder.getDistanceMeters());
    }
}
