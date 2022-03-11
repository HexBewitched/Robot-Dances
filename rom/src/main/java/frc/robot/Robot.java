package frc.robot;

//import java.util.zip.ZipEntry;

//import javax.transaction.xa.Xid;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {

    // Motors
    private CANTSparkMax backLeftMotor = new CANTSparkMax(2);
    private CANTSparkMax frontLeftMotor = new CANTSparkMax(1);
    private CANTSparkMax frontRightMotor = new CANTSparkMax(3);
    private CANTSparkMax backRightMotor = new CANTSparkMax(4);

    // Joysticks
    Joystick xboxController = new Joystick(0);

    Timer timer = new Timer();
    boolean isDancing = false;
    boolean isCoolDancing = false;

    @Override
    public void robotInit() {
      frontLeftMotor.setInverted(true);
      backLeftMotor.setInverted(true);
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }
    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        double xInput = xboxController.getX();
        double yInput = -xboxController.getY();
        double zInput = xboxController.getZ();
        boolean danceButton = xboxController.getRawButtonReleased(3);
        boolean coolDanceButton = xboxController.getRawButtonReleased(2);
        
        /*timer.reset();
        timer.start();
        if (timer.get() < 15) {
            if (timer.get() < 0.5) {
                yInput = 0.5;
            } else {
            yInput = 0;
                while(timer.get() < 15) {
                    double currentTime = timer.get();
                    if (timer.get() < currentTime + 0.2) {
                        xInput = 0.2;
                        yInput = 0;
                    } else {
                        xInput = -0.2;
                        yInput = 0;
                    }
                }
            }    
       } else{*/ 
        if(Math.abs(xInput) < 0.2) {
          xInput = 0;
        } else if(Math.abs(yInput) < 0.2){
          yInput = 0;
        } else if (Math.abs(zInput) < 0.2){
          zInput = 0;
        }
        
        if (coolDanceButton) {
            timer.reset();
            timer.start();
            isCoolDancing = !isCoolDancing;
        }
        if(isCoolDancing){
          if(timer.get() < 0.5){
            xInput = 0.3;
            zInput = 0.3;
          } else if (timer.get() < 1){
            xInput = -03;
            zInput = 03;
          } else if (timer.get() < 1.5) {
            xInput = 0.3;
            zInput = 0.3;
          } else if (timer.get() < 2) {
            xInput = -03;
            zInput = 03;
          } else if (timer.get() < 2.5) {
            xInput = 0.3;
            zInput = 0.3;
          } else if (timer.get() < 3) {
            xInput = -0.3;
            zInput = 0.3;
          } else if (timer.get() < 3.5){
            xInput = 0;
            zInput = 0.5;
          } else if (timer.get() < 4){
            zInput = -0.5;
          } else if (timer.get() < 5) {
            zInput = 0.5;
          } else if (timer.get() < 6) {
            zInput = -0.5;
          } else if (timer.get() < 7) {
            zInput = 0.5;
          } else if (timer.get() < 7.4) {
            zInput = 0;
            xInput = 0.3;
          } else if (timer.get() < 8) {
            xInput = -0.3;
          } else if (timer.get() < 8.3) {
            xInput = 0;
            yInput = 0.3;
          }
          else {
            isCoolDancing = false;
          }
        }
        if (danceButton) {
            timer.reset();
            timer.start();
            isDancing = !isDancing;
        }
        if (isDancing) {
            if (timer.get() < 0.5) {
                xInput = 0;
                yInput = 0.5;
            } else if (timer.get() < 1) {
                xInput = 0;
                yInput = -0.5;
            } else if (timer.get() < 1.5){
                zInput = 0.26 * 4;
                yInput = 0;
            } else if (timer.get() < 2.2) {
                zInput = 0;
                yInput = 0.5;
            } else if (timer.get() < 2.7) {
                zInput = 0;
                yInput = -0.5;
            }else if (timer.get() < 3.2) {
                zInput = 0.26 * 4;
                yInput = 0;
            } else if (timer.get() < 3.8) {
                zInput = 0;
                yInput = 0.5;
            } else if (timer.get() < 4.3) {
                zInput = 0;
                yInput = -0.5;
            } else if (timer.get() < 4.8){
                zInput = 0.26 * 4;
                yInput = 0;
            } else if (timer.get() < 5.3) {
                zInput = 0;
                yInput = 0.5;
            } else if (timer.get() < 5.8) {
                zInput = 0;
                yInput = -0.5;
            } else if (timer.get() < 10) {
                yInput = 0;
                zInput = 0.7;
            } else { 
                isDancing = false;
            }
        }

        backLeftMotor.set((-xInput + yInput - zInput));
        backRightMotor.set((xInput + yInput + zInput));
        frontLeftMotor.set((xInput + yInput - zInput));
        frontRightMotor.set((-xInput + yInput + zInput));
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }
}