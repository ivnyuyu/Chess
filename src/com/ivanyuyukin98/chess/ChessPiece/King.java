package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

import java.util.Map;

/**
 * Created by Ivan on 02.02.2018.
 */
public class King extends Piece {
    public King(ColorPiece color){
        super(color);
    }
    private String consoleName="K";
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public boolean isProtectedTile(Move move){
        Board board=Board.getBoard();

        if(!(move.diffHorizontal()-move.diffVertical()<2)) return false;
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

        if (move.isColorSame()) return false;
        if (isProtectedTile(move)) return false;
        return true;
    }

}
