package com.ivanyuyukin98.chess.test;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class PawnTest {
    @Test
    public void checkMove(){
        Board board=Board.getBoard();
        Tile fTile=new Tile(6,3);
        Tile dTile=new Tile(5,3);
        Move move=new Move(fTile,dTile);
        System.out.println(board.getPieceMap().get(fTile).getConsoleName());
        boolean exp=board.getPieceMap().get(fTile).checkMove(move);
        assertEquals(true,exp);

    }
}
