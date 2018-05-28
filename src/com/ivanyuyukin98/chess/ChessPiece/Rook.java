package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
/**
 * Created by Ivan on 07.01.2018.
 */
public class Rook extends Piece {
    public Rook(ColorPiece color){
        super(color);
    }
    private String consoleName="R";
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public boolean isProtectedTile(Move move){
        if (!move.isVertical()&&!move.isHorizontal()) return false;
        if (move.isValidPathDiagonal()) return true;
        return false;
    }
    @Override
    public  boolean checkMove(Move move){
        if (move.isColorSame()) return false;
        if (isProtectedTile(move)) return true;
        return false;
    }


}
