package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

import java.util.Map;

/**
 * Created by Ivan on 02.02.2018.
 */
public class King extends Piece {
    public static Tile positionKing;
    public King(ColorPiece color){
        super(color);
        if(color==ColorPiece.W){
            positionKing=new Tile(7,4);
        }else{
            positionKing=new Tile(0,4);
        }

    }
    private String consoleName="K";
    public String getConsoleName(){
        return consoleName;
    }

    @Override
    public boolean isProtectedTile(Move move) {
        return false;
    }

    public boolean isProtectedTiles(Move move){
        Board board=Board.getBoard();
        if(move.isDiagonal()){
            if(move.diffHorizontal()!=1) return false;
            if(move.diffVertical()!=1) return false;
        }
        if(move.isVertical()||move.isHorizontal()){
            System.out.println("diff=");
            System.out.println(move.diffVertical()-move.diffHorizontal());
            if(Math.abs(move.diffVertical()-move.diffHorizontal())!=1) return false;
        }

        Map<Tile, Piece> pieceMap=board.getPieceMap();
        for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
            Tile fTile=entry.getKey();
            Tile dTile=move.getDestinationTile();
            Move move2=new Move(fTile,dTile);
            if(pieceMap.get(fTile).getColor()==this.getColor()) continue;
            if(pieceMap.get(fTile).isProtectedTile(move2)) {
                System.out.println(pieceMap.get(fTile).getConsoleName());
                return false;
            }
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
