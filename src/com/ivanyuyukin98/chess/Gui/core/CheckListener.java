package com.ivanyuyukin98.chess.Gui.core;

public class CheckListener {
    private static boolean check=false;
    private static boolean lastHorizont=false;
    public static boolean getCheck(){
        return  check;
    }
    public static void setCheck(boolean result){
        check=result;
    }
    public static boolean getIsLastHorizontalForPawn(){
        return lastHorizont;
    }
    public static void setLastHorizont(boolean s){
        lastHorizont=s;
    }
}
