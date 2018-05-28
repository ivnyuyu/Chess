package com.ivanyuyukin98.chess;


import com.ivanyuyukin98.chess.Display.ConsoleDisplay;
import com.ivanyuyukin98.chess.Gui.SandBox.Example;
import com.ivanyuyukin98.chess.Gui.core.Window;

import java.awt.*;


public class Main  {
    public static void main(String[] args) {
        double a=2;
        double b=1.1;
        double c=a-b;
        System.out.println( c);
        Window window=new Window("",640,640);
        window.addLayer(new Example(0,0,"Rook", Color.GRAY));
        window.addLayer(new Example(80,0,"Knight", Color.GRAY));
        window.addLayer(new Example(160,0,"Bishop", Color.GRAY));
        window.addLayer(new Example(240,0,"Queen", Color.GRAY));
        window.addLayer(new Example(320,0,"King", Color.GRAY));
        window.addLayer(new Example(400,0,"Bishop", Color.GRAY));
        window.addLayer(new Example(480,0,"King", Color.GRAY));
        window.addLayer(new Example(560,0,"Rook", Color.GRAY));
        window.addLayer(new Example(0,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(80,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(160,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(240,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(320,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(400,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(480,80,"Pawn", Color.GRAY));
        window.addLayer(new Example(560,80,"Pawn", Color.GRAY));

        window.addLayer(new Example(0,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(80,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(160,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(240,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(320,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(400,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(480,480,"Pawn", Color.YELLOW));
        window.addLayer(new Example(560,480,"Pawn", Color.YELLOW));

        window.addLayer(new Example(0,560,"Rook", Color.YELLOW));
        window.addLayer(new Example(80,560,"Knight", Color.YELLOW));
        window.addLayer(new Example(160,560,"Bishop", Color.YELLOW));
        window.addLayer(new Example(240,560,"Queen", Color.YELLOW));
        window.addLayer(new Example(320,560,"King", Color.YELLOW));
        window.addLayer(new Example(400,560,"Bishop", Color.YELLOW));
        window.addLayer(new Example(480,560,"Knight", Color.YELLOW));
        window.addLayer(new Example(560,560,"Rook", Color.YELLOW));

        while(true){
            ConsoleDisplay cd=new ConsoleDisplay();
            try{
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            cd.showBoard();
        }


    }
}
