package com.ivanyuyukin98.chess.Gui.core;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
public class ConvertorPxinCoordinate {
    private static int firstX, firstY, lastX, lastY;
    public static void convert(int fx, int fy, int lx,int ly){
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
        System.out.println("Expected:"+ firstX+" "+firstY+" to "+lastX+" "+lastY);
        Board board=Board.getBoard();
        if(board.getPieceMap().get(new Tile(firstY,firstX)).checkMove(new Move(new Tile(firstY,firstX),new Tile(lastY,lastX)))){
            board.getPieceMap().get(new Tile(firstY,firstX)).makeMove(new Move(new Tile(firstY,firstX),new Tile(lastY,lastX)));
            System.out.println(firstX+" "+firstY+" to "+lastX+" "+lastY);
        }

    }
}
