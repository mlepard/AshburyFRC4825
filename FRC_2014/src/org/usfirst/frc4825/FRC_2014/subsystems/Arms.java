//Imports
package org.usfirst.frc4825.FRC_2014.subsystems;
import org.usfirst.frc4825.FRC_2014.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4825.FRC_2014.Support.ArmPos;
public class Arms extends Subsystem {
    
    //Declaring objects
    SpeedController leftArmBeltMotorController = RobotMap.armsLeftArmBeltMotorController;
    SpeedController rightArmBeltMotorController = RobotMap.armsRightArmBeltMotorController;
    Solenoid armPositionSolenoid = RobotMap.armsArmPositionSolenoid;
    ArmPos currentArmPos = ArmPos.UP;
    double currentMotorSpeed = 0;
            
    public void initDefaultCommand() {
    
    }
    
    //Sets arm position
    public void moveArm(ArmPos armPosToSet){
        if(armPosToSet == currentArmPos){
            System.out.println("Error : Arm Already At Position");
        }
        else if(armPosToSet == ArmPos.UP){
            armPositionSolenoid.set(true);
            currentArmPos = ArmPos.UP;
            System.out.println("Arms Moved Up");
        }
        else if(armPosToSet == ArmPos.DOWN){
            armPositionSolenoid.set(false);
            currentArmPos = ArmPos.DOWN;
            System.out.println("Armes Moved Down");
        }
        else{
            System.out.println("Unknown Error In moveArm()");
        }
        
    }
    
    //Sets motor speed
    public void setMotorSpeed(double motorSpeedToSet){
        if(motorSpeedToSet == currentMotorSpeed){
            System.out.println("Error : Motor already at requested speed");
        }
        else if (motorSpeedToSet > 1.0){
            System.out.println("Error : Motor speed imput cannot be greater than 1.0");
        }
        else if (motorSpeedToSet < -1.0){
            System.out.println("Error : Motor speed imput cannot be less that -1.0");
        }
        else{
            leftArmBeltMotorController.set(motorSpeedToSet);
            rightArmBeltMotorController.set(motorSpeedToSet);
            currentMotorSpeed = motorSpeedToSet;
            System.out.println("Motor Set To Speed : "+currentMotorSpeed);
        }
    }
    
    //Returns Arm Position
    public ArmPos getArmPos(){
        if(currentArmPos == ArmPos.DOWN){
            System.out.println("Returning ArmPos.DOWN");
        }
        else{
            System.out.println("Returning ArmPos.UP");
        }
        return currentArmPos;
    }
    
    //Returns true if arm is up
    public boolean isArmUp(){
        if(currentArmPos == ArmPos.UP){
            System.out.println("Arm is up");
            return true;
        }
        else{
            System.out.println("Arm is not up");
            return false;
        }
    }
    
    //Returns true if arm is down
    public boolean isArmDown(){
        if(currentArmPos == ArmPos.DOWN){
            System.out.println("Arm is down");
            return true;
        }
        else{
            System.out.println("Arm is not down");
            return false;
        }
    }
    
    //Returns the current motor speed
    public double getMotorSpeed(){
        System.out.println("Returned : "+currentMotorSpeed);
        return currentMotorSpeed;
    }
}
