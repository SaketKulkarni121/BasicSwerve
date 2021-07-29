package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp {
    
    public DriveTrain dt = DriveTrain.getInstance();

    public XBoxController driver;
    public static TeleOp instance;

    public static TeleOp getInstance() {
        if (instance == null)
            instance = new TeleOp();
        return instance;
    }

    public TeleOp() {
        driver = new XBoxController(Constants.XBOX_DRIVER);
    }

    
    public void run() {
        dt.tankDrive(driver.getLeftStickYAxis(), driver.getRightStickYAxis());
    }

}
