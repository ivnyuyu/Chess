package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.ColorQueue;
import com.ivanyuyukin98.chess.Board.Move;

import java.awt.*;

public abstract class Piece {
    public enum ColorPiece{W, B}
    private ColorPiece color;
    public Piece(ColorPiece color){
        this.color=color;
    }
    abstract public String getConsoleName();
    public ColorPiece getColor(){
        return color;
    }
    public abstract boolean checkMove(Move move);
    public abstract boolean isProtectedTile(Move move);
    public void makeMove(Move move){
        Board board=Board.getBoard();
        board.getPieceMap().put(move.getDestinationTile(),this);
        board.getPieceMap().remove(move.getFirstTile());
        ColorQueue.setColorQueue(getColor());

    }
    public boolean checkMoveQueue(){
        if(getColor().equals(ColorQueue.getColorQueue())) return true;
        return false;
    }
}
