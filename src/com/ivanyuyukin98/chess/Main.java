package com.ivanyuyukin98.chess;

import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Display.ConsoleDisplay;
import com.ivanyuyukin98.chess.Gui.SandBox.LayerPiece;
import com.ivanyuyukin98.chess.Gui.core.Window;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        //625
        Window window=new Window("Chess",900,625);
        window.addLayer(new LayerPiece(0,0,"rookb", new Tile(0,0)));
        window.addLayer(new LayerPiece(80,0,"horseb",new Tile(1,0)));
        window.addLayer(new LayerPiece(160,0,"bishopb",new Tile(2,0)));
        window.addLayer(new LayerPiece(240,0,"queenb",new Tile(3,0)));
        window.addLayer(new LayerPiece(320,0,"kingb",new Tile(4,0)));
        window.addLayer(new LayerPiece(400,0,"bishopb",new Tile(5,0)));
        window.addLayer(new LayerPiece(480,0,"horseb",new Tile(6,0)));
        window.addLayer(new LayerPiece(560,0,"rookb",new Tile(7,0)));

        window.addLayer(new LayerPiece(0,80,"pawnb", new Tile(0,1)));
        window.addLayer(new LayerPiece(80,80,"pawnb",new Tile(1,1)));
        window.addLayer(new LayerPiece(160,80,"pawnb",new Tile(2,1)));
        window.addLayer(new LayerPiece(240,80,"pawnb",new Tile(3,1)));
        window.addLayer(new LayerPiece(320,80,"pawnb",new Tile(4,1)));
        window.addLayer(new LayerPiece(400,80,"pawnb",new Tile(5,1)));
        window.addLayer(new LayerPiece(480,80,"pawnb",new Tile(6,1)));
        window.addLayer(new LayerPiece(560,80,"pawnb",new Tile(7,1)));

        window.addLayer(new LayerPiece(0,560,"rookw", new Tile(0,7)));
        window.addLayer(new LayerPiece(80,560,"horsew",new Tile(1,7)));
        window.addLayer(new LayerPiece(160,560,"bishopw",new Tile(2,7)));
        window.addLayer(new LayerPiece(240,560,"queenw",new Tile(3,7)));
        window.addLayer(new LayerPiece(320,560,"kingw",new Tile(4,7)));
        window.addLayer(new LayerPiece(400,560,"bishopw",new Tile(5,7)));
        window.addLayer(new LayerPiece(480,560,"horsew",new Tile(6,7)));
        window.addLayer(new LayerPiece(560,560,"rookw",new Tile(7,7)));

        window.addLayer(new LayerPiece(0,480,"pawnw", new Tile(0,6)));
        window.addLayer(new LayerPiece(80,480,"pawnw",new Tile(1,6)));
        window.addLayer(new LayerPiece(160,480,"pawnw",new Tile(2,6)));
        window.addLayer(new LayerPiece(240,480,"pawnw",new Tile(3,6)));
        window.addLayer(new LayerPiece(320,480,"pawnw",new Tile(4,6)));
        window.addLayer(new LayerPiece(400,480,"pawnw",new Tile(5,6)));
        window.addLayer(new LayerPiece(480,480,"pawnw",new Tile(6,6)));
        window.addLayer(new LayerPiece(560,480,"pawnw",new Tile(7,6)));

       /* while(true){
            ConsoleDisplay consoleDisplay=new ConsoleDisplay();
            consoleDisplay.showBoard();
            System.out.println("");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }
}

