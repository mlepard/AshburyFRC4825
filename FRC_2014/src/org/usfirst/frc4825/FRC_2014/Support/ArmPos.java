/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc4825.FRC_2014.Support;

/**
 *
 * @author Isidor
 */
public class ArmPos {

    public final int value;

    protected static final int UP_VAL = 0;
    protected static final int DOWN_VAL = 0;
    public static final ArmPos UP = new ArmPos(UP_VAL);
    public static final ArmPos DOWN = new ArmPos(DOWN_VAL);

    private ArmPos(int value){
        this.value = value;
    }    
}