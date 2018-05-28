package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

/**
 * Created by Ivan on 02.02.2018.
 */
public class Bishop extends Piece {
    private  String consoleName="B";
    public Bishop(ColorPiece color){
        super(color);
    }
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public  boolean isProtectedTile(Move move){
        if(!move.isDiagonal()) return false;
        if(move.isValidPathDiagonal()) return true;
        return false;
    }
    @Override
    public  boolean checkMove(Move move){
        if(move.isColorSame()) return false;
        if(isProtectedTile(move)) return true;
        return false;
    }



}
