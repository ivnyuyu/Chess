package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

/**
 * Created by Ivan on 02.02.2018.
 */
public class Queen extends Piece {
    public Queen(ColorPiece color){
        super(color);
    }
    private String consoleName="Q";
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public boolean isProtectedTile(Move move){
        if (move.isDiagonal())
            if (move.isValidPathDiagonal()) return true;
        if (move.isVertical()||move.isHorizontal())
            if (move.isValidPathVerticalOrHorizontal()) return true;
        return false;
    }
    @Override
    public  boolean checkMove(Move move){
        if (move.isColorSame()) return false;
        if(isProtectedTile(move)) return true;
        System.out.println("here");
        return false;
    }

}
