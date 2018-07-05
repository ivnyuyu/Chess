package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.SandBox.LayerPiece;
import com.ivanyuyukin98.chess.Gui.core.Window;

import java.io.IOException;

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
        if(this.getColor()==ColorPiece.W)
            if(move.isDiagonal())
                if(move.diffVertical()-move.diffHorizontal()==0)
                    if(move.diffVertical()==1)
                        if(move.getFirstTile().getX()>move.getDestinationTile().getX())
                            return true;
        if(this.getColor()==ColorPiece.B)
            if(move.isDiagonal())
                if(move.diffVertical()-move.diffHorizontal()==0)
                    if(move.diffVertical()==1)
                        if(move.getFirstTile().getX()<move.getDestinationTile().getX())
                            return true;
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
                            isLastHorizont(move);
                            return true;
                        }
                    }

                }

            }

            if(move.isDiagonal())
                if(move.diffVertical()-move.diffHorizontal()==0)
                    if(move.diffVertical()==1)
                        if(move.getFirstTile().getX()>move.getDestinationTile().getX())
                            if(board.getPieceMap().get(move.getDestinationTile())!=null){
                                isLastHorizont(move);
                                firstMove=1;
                                return true;
                            }




        }
        //проверка для черной пешки
        if(this.getColor()==ColorPiece.B){
            if(move.isVertical()){
                if(move.diffHorizontal()<=firstMove){
                    if(move.getFirstTile().getX()<move.getDestinationTile().getX()){
                        if(board.getPieceMap().get(move.getDestinationTile())==null){
                            firstMove=1;
                            isLastHorizont(move);
                            return true;
                        }
                    }

                }

            }


            if(move.isDiagonal())
                if(move.diffVertical()-move.diffHorizontal()==0)
                    if(move.diffVertical()==1)
                        if(move.getFirstTile().getX()<move.getDestinationTile().getX())
                             if(board.getPieceMap().get(move.getDestinationTile())!=null){
                                firstMove=1;
                                 isLastHorizont(move);
                                 return true;
                             }
        }



        return false;
    }
    private void isLastHorizont(Move move){
        if(getColor()==ColorPiece.W){
            if(move.getDestinationTile().getX()==0){
                Board board=Board.getBoard();
                Window.deleteLayer(new Tile(move.getFirstTile().getY(),move.getFirstTile().getX()));
                board.getPieceMap().put(move.getFirstTile(),new Queen(getColor()));
                try {
                    Window.addLayer(new LayerPiece(move.getDestinationTile().getY()*80,0,"queenw",new Tile(move.getDestinationTile().getX(),move.getDestinationTile().getY())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(getColor()==ColorPiece.B){
            if(move.getDestinationTile().getX()==7){

                Board board=Board.getBoard();
                Window.deleteLayer(new Tile(move.getFirstTile().getY(),move.getFirstTile().getX()));
                board.getPieceMap().put(move.getFirstTile(),new Queen(getColor()));
                try {
                    Window.addLayer(new LayerPiece(move.getDestinationTile().getY()*80,560,"queenb",new Tile(move.getDestinationTile().getX(),move.getDestinationTile().getY())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
