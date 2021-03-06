package com.ivanyuyukin98.chess.test;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan on 03.02.2018.
 */
public class RookTest {
    @Test
    public void checkMove() {
        Board board=Board.getBoard();
        Tile fTile=new Tile(4,4);
        Tile dTile=new Tile(3,2);
        Move move=new Move(fTile,dTile);
        boolean exp=board.getPieceMap().get(fTile).checkMove(move);
        assertEquals(true,exp);

    }
}
