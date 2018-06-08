package com.ivanyuyukin98.chess.Board;

import com.ivanyuyukin98.chess.ChessPiece.Piece;

import static com.ivanyuyukin98.chess.ChessPiece.Piece.ColorPiece.B;
import static com.ivanyuyukin98.chess.ChessPiece.Piece.ColorPiece.W;

public class ColorQueue {
    static Piece.ColorPiece s=W;
    public static Piece.ColorPiece getColorQueue(){
        return s;
    }
    public static void setColorQueue(Piece.ColorPiece cq){
        if(cq==W){
            s=B;
        }else{
            s=W;
        }
    }
}
