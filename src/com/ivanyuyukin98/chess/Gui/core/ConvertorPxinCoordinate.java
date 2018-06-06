package com.ivanyuyukin98.chess.Gui.core;
import com.ivanyuyukin98.chess.Board.Move;

public class ConvertorPxinCoordinate {
    private static int firstX, firstY, lastX, lastY;
    private static Move lastMove;
    private static int arr[]=new int[4];

    public static int[] getArr() {
        return arr;
    }

    public static void convert(int fx, int fy, int lx, int ly){
        for(int i=0,x=0;i<640;i+=80,x++){
            for (int j=0,y=0; j<640;j+=80,y++){
                if(i<fx && i+80>fx &&j<fy&& j+80>fy){
                    firstX=x;
                    firstY=y;
                }
                if(i<lx && i+80>lx &&j<ly&& j+80>ly){
                    lastX=x;
                    lastY=y;
                }
            }
        }
        System.out.println(firstX+" "+firstY+"/"+lastX+" "+lastY);
        arr[0]=firstX;
        arr[1]=firstY;
        arr[2]=lastX;
        arr[3]=lastY;
    }
}

