// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc4825.AshburySubsystemRobot.subsystems;
import org.usfirst.frc4825.AshburySubsystemRobot.RobotMap;
import org.usfirst.frc4825.AshburySubsystemRobot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Launcher extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController launcherMotor1 = RobotMap.launcherLauncherMotor1;
    SpeedController launcherMotor2 = RobotMap.launcherLauncherMotor2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private boolean isMotorOn = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void turnOnLauncher( double percentage1, double percentage2 )
    {
        //launcher 1 motor has to be inverted...
        launcherMotor1.set(-1*percentage1);
        launcherMotor2.set(-1*percentage2);
        isMotorOn = true;
    }
    public void turnOffLauncher()
    {
        launcherMotor1.set(0.0);
        launcherMotor2.set(0.0);
        isMotorOn = false;
    }
    public boolean isMotorOn()
    {
        return isMotorOn;
    }
    
}