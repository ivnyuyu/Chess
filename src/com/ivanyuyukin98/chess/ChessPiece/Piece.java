package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;

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
        System.out.println("all right");
    }
}
