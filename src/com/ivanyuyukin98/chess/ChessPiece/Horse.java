package com.ivanyuyukin98.chess.ChessPiece;


import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

/**
 * Created by Ivan on 07.01.2018.
 */
public class Horse extends Piece {
    private  String consoleName="N";
    @Override
    public boolean isProtectedTile(Move move){
        int[] xM={-2,-2,-1,-1,1,1,2,2};
        int[] yM={1,-1,2,-2,2,-2,1,-1};
        //Board board=Board.getBoard();
        Tile fTile=move.getFirstTile();
        Tile destinationTile=move.getDestinationTile();
        for(int i=0; i<xM.length;i++){
            int x=xM[i]+fTile.getX();
            int y=yM[i]+fTile.getY();
            if((x<0||x>7)||(y<0||y>7)) continue;
            if((x==destinationTile.getX())&&(y==destinationTile.getY()))
                return true;
        }
        return false;
    }

    public Horse(ColorPiece color){
        super(color);
    }
    public String getConsoleName(){
        return consoleName;
    }
    @Override
    public boolean checkMove(Move move){
        if(move.isColorSame()) return false;
        if (isProtectedTile(move)) return true;
        return false;
    }


}
