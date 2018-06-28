package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.LocationKing;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

import java.util.Map;

/**
 * Created by Ivan on 02.02.2018.
 */
public class King extends Piece {

    public King(ColorPiece color){
        super(color);
        if(color==ColorPiece.W){
            LocationKing.setLocationWKing(new Tile(7,4));
        }else{
            LocationKing.setLocationBKing(new Tile(0,4));
        }


    }
    private String consoleName="King";
    public String getConsoleName(){
        return consoleName;
    }

    @Override
    public boolean isProtectedTile(Move move) {
        if(move.diffHorizontal()==0&&move.diffVertical()==0) return false;
        if(move.isDiagonal()){
            if(move.diffHorizontal()-move.diffVertical()==0) return true;
            return false;
        }
        if(move.isVertical()||move.isHorizontal()){
            if(Math.abs(move.diffVertical()-move.diffHorizontal())!=1) return false;
            return true;
        }
        return false;
    }
    public boolean isProtectedTiles(Move move){
        Board board=Board.getBoard();
        if(move.isDiagonal()){

            if(move.diffHorizontal()!=1) return false;
            if(move.diffVertical()!=1) return false;

        }
        if(move.isVertical()||move.isHorizontal()){

            if(Math.abs(move.diffVertical()-move.diffHorizontal())!=1) return false;
        }
        Map<Tile, Piece> pieceMap=board.getPieceMap();
        Tile dTile=move.getDestinationTile();
        for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
            Tile fTile=entry.getKey();
            Move move2=new Move(fTile,dTile);
            if(pieceMap.get(fTile).getColor()==this.getColor()) continue;
            if(pieceMap.get(fTile).isProtectedTile(move2)) {
                System.out.println("here:");
                System.out.println(pieceMap.get(fTile).getConsoleName());
                return false;
            }
        }

        if(getColor()==ColorPiece.W){
            LocationKing.setLocationWKing(move.getDestinationTile());
        }else{
            LocationKing.setLocationBKing(move.getDestinationTile());
        }

        return true;
    }
    public  boolean checkMove(Move move) {
        if(!checkMoveQueue()) return false;
        if (move.isColorSame()) return false;
        if (!isProtectedTiles(move)) return false;
        return true;
    }

}
