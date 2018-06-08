package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
/**
 * Created by Ivan on 02.02.2018.
 */
public class Pawn extends Piece {
    private int firstMove;
    public Pawn(ColorPiece color){
        super(color);
        firstMove=2;
    }
    private String consoleName="P";
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public boolean isProtectedTile(Move move){
        return false;
    }
    @Override
    public  boolean checkMove(Move move){
        if(!checkMoveQueue()) return false;
        Board board=Board.getBoard();
        if(move.isColorSame()) return false;
        if(!(move.isHorizontal() || move.isVertical()||move.isDiagonal())) return false;
        //проверка для белой пешки
        if(this.getColor()==ColorPiece.W){
            if(move.isVertical()){
                if(move.diffHorizontal()<=firstMove){
                    if(move.getFirstTile().getX()>move.getDestinationTile().getX()){
                        if(board.getPieceMap().get(move.getDestinationTile())==null){
                            firstMove=1;
                            return true;
                        }
                    }

                }

            }

            if(move.isDiagonal())
                if(move.diffVertical()-move.diffHorizontal()==0)
                    if(move.diffVertical()==1)
                        if(board.getPieceMap().get(move.getDestinationTile())!=null)
                            return true;




        }
        //проверка для черной пешки
        if(this.getColor()==ColorPiece.B){
            if(move.isVertical()){
                if(move.diffHorizontal()<=firstMove){
                    if(move.getFirstTile().getX()<move.getDestinationTile().getX()){
                        if(board.getPieceMap().get(move.getDestinationTile())==null){
                            firstMove=1;
                            return true;
                        }
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
