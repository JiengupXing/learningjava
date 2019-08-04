package com.run;
import com.resource.*;
public class RunPlane{
    public static void main(String[] args){
        FighterPlane fp = new FighterPlane();
        fp.name = "su 35";
        fp.missileNum = 6;
        fp.fire();
    }
}