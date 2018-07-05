package com.ivanyuyukin98.chess.Board;

import com.ivanyuyukin98.chess.ChessPiece.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan on 02.02.2018.
 */
public class Board {
    private static Board board=new Board();
    private  Map<Tile, Piece> pieceMap=new HashMap<>();
    private final int size=8;
    public static Board getBoard(){
        return board;
    }

    public Map<Tile, Piece> getPieceMap()
    {
        return this.pieceMap;
    }
    private Board(){
        beginWhite();
        beginBlack();
    }
    private void beginWhite(){
        pieceMap.put(new Tile(7,0), new Rook(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,1), new Horse(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,2), new Bishop(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,3), new Queen(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,4), new King(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,5), new Bishop(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,6), new Horse(Piece.ColorPiece.W));
        pieceMap.put(new Tile(7,7), new Rook(Piece.ColorPiece.W));
        for(int hS=0;hS<size;hS++){
            pieceMap.put(new Tile(6,hS), new Pawn(Piece.ColorPiece.W));
        }
    }
    private void beginBlack(){
        pieceMap.put(new Tile(1,6),new Horse(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,0),new Bishop(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,0), new Rook(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,1), new Horse(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,2), new Bishop(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,3), new Queen(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,4), new King(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,5), new Bishop(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,6), new Horse(Piece.ColorPiece.B));
        pieceMap.put(new Tile(0,7), new Rook(Piece.ColorPiece.B));
        for(int hS=0;hS<size;hS++){
            pieceMap.put(new Tile(1,hS), new Pawn(Piece.ColorPiece.B));
        }
    }



}
