package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain {

    public static DriveTrain instance;
    public TalonSRX t_frontLeft, t_frontRight, t_backLeft, t_backRight;
    public CANSparkMax d_frontLeft, d_frontRight, d_backLeft, d_backRight;
    public XBoxController driver;
    // Big Horse, Big Giraffe, Big Sushi, Big Bird

    public static DriveTrain getInstance() {
        if (instance == null)
            instance = new DriveTrain();
        return instance;
    }

    public DriveTrain() {

        d_backRight = new CANSparkMax(Constants.DT_BB_DRIVE_TALON_ID, MotorType.kBrushless);
        d_frontLeft = new CANSparkMax(Constants.DT_BH_DRIVE_TALON_ID, MotorType.kBrushless);
        d_frontRight = new CANSparkMax(Constants.DT_BG_DRIVE_TALON_ID, MotorType.kBrushless);
        d_backLeft = new CANSparkMax(Constants.DT_BS_DRIVE_TALON_ID, MotorType.kBrushless);

        // t_backRight = new TalonSRX(Constants.DT_BB_TURN_TALON_ID);
        // t_frontLeft = new TalonSRX(Constants.DT_BH_TURN_TALON_ID);
        // t_frontRight = new TalonSRX(Constants.DT_BG_TURN_TALON_ID);
        // t_backLeft = new TalonSRX(Constants.DT_BS_TURN_TALON_ID);

        driver = new XBoxController(Constants.XBOX_DRIVER);
    }

    public void setDrivePower(double backRightPower, double backLeftPower, double frontLeftPower,
            double frontRightPower) {
        d_backRight.set(backRightPower);
        d_backLeft.set(backLeftPower);
        d_frontLeft.set(frontLeftPower);
        d_frontRight.set(frontRightPower);
    }
    
    public void tankDrive() {
        double left = driver.getLeftStickYAxis();
        double right = driver.getRightStickYAxis();
        setDrivePower(right, left, left, right);
    }

    // public void setTurnPower(double backRightPower, double backLeftPower, double frontLeftPower,
    //         double frontRightPower) {
    //     t_backRight.set(ControlMode.PercentOutput, backRightPower);
    //     t_backLeft.set(ControlMode.PercentOutput, backLeftPower);
    //     t_frontLeft.set(ControlMode.PercentOutput, frontLeftPower);
    //     t_frontRight.set(ControlMode.PercentOutput, frontRightPower);
    // }

    /*     public void stopDrive() {
        setDrivePower(0, 0, 0, 0);
    }

    public void setAllIdleMode(boolean brake) {
        if (brake) {
            d_backLeft.setIdleMode(IdleMode.kBrake);
            d_backRight.setIdleMode(IdleMode.kBrake);
            d_frontRight.setIdleMode(IdleMode.kBrake);
            d_frontLeft.setIdleMode(IdleMode.kBrake);
        } else {
            d_backLeft.setIdleMode(IdleMode.kCoast);
            d_backRight.setIdleMode(IdleMode.kCoast);
            d_frontRight.setIdleMode(IdleMode.kCoast);
            d_frontLeft.setIdleMode(IdleMode.kCoast);
        }
    }

    public void humanDrive(double fwd, double str, double rot) {
        if (Math.abs(fwd) < Constants.DRIVER_DEAD_ZONE && Math.abs(str) < Constants.DRIVER_DEAD_ZONE
                && Math.abs(rot) < Constants.DRIVER_ROT_DEAD_ZONE) {

            setAllIdleMode(true);
            stopDrive();

        } else {
            setAllIdleMode(false);

            swerveDrive(Utils.expoDeadzone(Sensitivity.LOW, Constants.DRIVER_DEAD_ZONE, fwd),
                    Utils.expoDeadzone(Sensitivity.LOW, Constants.DRIVER_DEAD_ZONE, str),
                    Utils.expoDeadzone(Sensitivity.LOW, Constants.DRIVER_ROT_DEAD_ZONE, rot));
        }
    }

    public void fieldCentricDrive(double fwd, double str, double rot) {
        double temp = (fwd * Math.cos(getgyroAngleInRad())) + (str * Math.sin(getgyroAngleInRad()));
        str = (-fwd * Math.sin(getgyroAngleInRad())) + (str * Math.cos(getgyroAngleInRad()));
        fwd = temp;
        humanDrive(fwd, str, rot);
    }*/

}
