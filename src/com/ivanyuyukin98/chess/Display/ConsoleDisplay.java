package com.ivanyuyukin98.chess.Display;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.ChessPiece.Piece;

import java.util.Map;

public class ConsoleDisplay {
    private final int size=8;
    private Board board=Board.getBoard();
    private String[][] ConsoleBoard;
    public ConsoleDisplay() {
        initBoard();
        putPieceOnBoard();
    }
    private void initBoard(){
        ConsoleBoard=new String[8][8];

        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
               ConsoleBoard[i][j] = "0";
            }
        }
    }
    private void putPieceOnBoard(){
        for(Map.Entry<Tile, Piece> entry: board.getPieceMap().entrySet()){
            Tile til=entry.getKey();
            //board[til.getX()][til.getY()]=entry.getValue().getConsoleName();t
            ConsoleBoard[til.getX()][til.getY()]=board.getPieceMap().get(til).getConsoleName();
        }
    }
    public void showBoard() {
        for(int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                System.out.print(ConsoleBoard[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
