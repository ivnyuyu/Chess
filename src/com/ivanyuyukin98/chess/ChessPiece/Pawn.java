package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
/**
 * Created by Ivan on 02.02.2018.
 */
public class Pawn extends Piece {
    private boolean firstMove=true;
    public boolean getFirstMove(){
        return firstMove;
    }
    @Override
    public boolean isProtectedTile(Move move){
        return false;
    }
    public Pawn(ColorPiece color){
        super(color);
    }
    private String consoleName="P";
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public  boolean checkMove(Move move){
        Board board=Board.getBoard();
        if(move.isColorSame()) return false;
        if(!(move.isHorizontal() ||move.isVertical())) return false;
        if(this.getColor()==ColorPiece.W){
            if(move.isVertical()){
                if(move.diffHorizontal()==1){
                    if(move.getFirstTile().getX()>move.getDestinationTile().getX()){
                        if(board.getPieceMap().get(move.getDestinationTile())==null)
                            return true;
                    }

                }

            }


            if(move.isDiagonal())
                if(move.diffVertical()-move.diffHorizontal()==0)
                    if(move.diffVertical()==1)
                        if(board.getPieceMap().get(move.getDestinationTile())!=null)
                            return true;
        }



        return false;
    }

}
