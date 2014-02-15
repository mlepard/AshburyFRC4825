// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4825.FRC_2014.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4825.FRC_2014.Robot;
import org.usfirst.frc4825.FRC_2014.RobotMap;
/**
 *
 */
public class pullBackHammer extends Command {
    public pullBackHammer() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.hammer);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Initialize pullBackHammer");
        setTimeout(SmartDashboard.getNumber("Max Hammer Pullback Time"));
        if (!Robot.hammer.isHammerAtLatch()) {
            System.out.println("Pulling back hammer " + SmartDashboard.getNumber("Hammer Motor Speed"));
            Robot.hammer.pullBackHammer((float) SmartDashboard.getNumber("Hammer Motor Speed"));
        } else {
            System.out.println("Error: Hammer is already at latch");
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (RobotMap.hammerHammerLatchSwitch.get() == false) {
            Robot.hammer.readyLatch();
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.hammer.isHammerAtLatch() || isTimedOut());
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.hammer.stopMotor();
        System.out.println("End pullBackHammer");
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        System.out.println("pullBackHammer interrupted");
    }
}
