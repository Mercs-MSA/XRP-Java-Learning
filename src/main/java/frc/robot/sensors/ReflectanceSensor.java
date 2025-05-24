package frc.robot.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReflectanceSensor extends SubsystemBase {
    private final XRPReflectanceSensor m_reflectanceSensor;

    /**
     * Creates a new ReflectanceSensor.
     */
    public ReflectanceSensor() {
        m_reflectanceSensor = new XRPReflectanceSensor();
    }

    /**
     * Returns the reflectance value of the left sensor.
     *
     * @return Reflectance value (0.0 to 1.0)
     */
    public double getLeftReflectanceValue() {
        return m_reflectanceSensor.getLeftReflectanceValue();
    }

    /**
     * Returns the reflectance value of the right sensor.
     *
     * @return Reflectance value (0.0 to 1.0)
     */
    public double getRightReflectanceValue() {
        return m_reflectanceSensor.getRightReflectanceValue();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Left Reflectance", m_reflectanceSensor.getLeftReflectanceValue());
        SmartDashboard.putNumber("Right Reflectance", m_reflectanceSensor.getRightReflectanceValue());
    }
}
