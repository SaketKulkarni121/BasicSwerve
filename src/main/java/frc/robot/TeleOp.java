package frc.robot;

public class TeleOp {
    public static XBoxController driver;
    public static DriveTrain dt = DriveTrain.getInstance();
    public static TeleOp instance;

    public static TeleOp getInstance() {
        if (instance == null)
            instance = new TeleOp();
        return instance;
    }

    private TeleOp() {
        driver = new XBoxController(Constants.XBOX_DRIVER);
    }

    
    public static void run() {
        dt.tankDrive(driver.getLeftStickYAxis(), driver.getRightStickYAxis());
    }

}
