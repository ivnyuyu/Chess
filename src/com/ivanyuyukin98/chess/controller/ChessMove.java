package com.ivanyuyukin98.chess.controller;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.core.Window;

public class ChessMove {
    //private static Move lastMove;
    public boolean checkMove(int arr[]){
        int firstX=arr[0];
        int firstY=arr[1];
        int lastX=arr[2];
        int lastY=arr[3];
        Board board=Board.getBoard();
        Move move=new Move(new Tile(firstY,firstX),new Tile(lastY,lastX));
            if (board.getPieceMap().get(new Tile(firstY, firstX)).checkMove(move)) {
                if(board.getPieceMap().get(new Tile(firstY, firstX)).makeMove(move)){
                    Window.deleteLayer(new Tile(lastX, lastY));
                    return true;
                }

            }
        return false;
    }
}
