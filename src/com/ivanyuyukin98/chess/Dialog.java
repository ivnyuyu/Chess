package com.ivanyuyukin98.chess;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;

import java.util.Scanner;

/**
 * Created by Ivan on 02.02.2018.
 */
public class Dialog {
    private Tile insertFirstCoordination(){
        System.out.println("Enter start coordination:");
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        return new Tile(x,y);
    }
    private Tile insertDestinationCoordination(){
        System.out.println("Enter destination coordination:");
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        return new Tile(x,y);
    }
    public void test(){
        Board board=Board.getBoard();
        Tile fTile=insertFirstCoordination();
        Tile dTile=insertDestinationCoordination();
        Move move=new Move(fTile, dTile);
        System.out.println(board.getPieceMap().get(fTile).getConsoleName());
        System.out.println(board.getPieceMap().get(fTile).checkMove(move));
    }

}
