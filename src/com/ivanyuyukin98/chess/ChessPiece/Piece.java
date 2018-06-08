package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.*;

import java.awt.*;
import java.util.Map;

public abstract class Piece {
    public enum ColorPiece{W, B}
    Tile kingPosition;
    private ColorPiece color;
    public Piece(ColorPiece color){
        this.color=color;
    }
    public Piece(ColorPiece color, Tile kingPosition){
        this.color=color;
        this.kingPosition=kingPosition;

    }
    abstract public String getConsoleName();
    public ColorPiece getColor(){
        return color;
    }
    public abstract boolean checkMove(Move move);
    public abstract boolean isProtectedTile(Move move);
    public boolean makeMove(Move move){
        Board board=Board.getBoard();
        Boolean isGood=true;
        Piece p=null;
        if(board.getPieceMap().get(move.getDestinationTile())!=null){
            p=board.getPieceMap().get(move.getDestinationTile());
        }
        board.getPieceMap().put(move.getDestinationTile(),this);
        board.getPieceMap().remove(move.getFirstTile());

        Map<Tile, Piece> pieceMap=board.getPieceMap();
        Tile dTile;
        for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
            Tile fTile=entry.getKey();
            if(ColorQueue.getColorQueue()==ColorPiece.W){
                dTile=LocationKing.getLocationWKing();
            }else{
                dTile=LocationKing.getLocationBKing();
            }

            Move move2=new Move(fTile,dTile);
            if(pieceMap.get(fTile).getColor()==pieceMap.get(dTile).getColor()) continue;
            if(pieceMap.get(fTile).isProtectedTile(move2)) {
                board.getPieceMap().remove(move.getDestinationTile());
                System.out.println("incorrect move!!!!");
                isGood=false;
                break;
            }
        }
        if(!isGood){
            board.getPieceMap().put(move.getFirstTile(),this);
            if(p!=null){
                board.getPieceMap().put(move.getDestinationTile(),p);
            }else{
                board.getPieceMap().remove(move.getDestinationTile());
            }
            board.getPieceMap().put(move.getDestinationTile(),this);

            return false;
        }
        ColorQueue.setColorQueue(getColor());
        return true;
    }
    public boolean checkMoveQueue(){
        if(getColor().equals(ColorQueue.getColorQueue())) return true;
        return false;
    }
    @Override
    public String toString(){
        return getConsoleName();
    }
}
