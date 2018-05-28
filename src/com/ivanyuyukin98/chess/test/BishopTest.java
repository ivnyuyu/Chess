package com.ivanyuyukin98.chess.test;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by Ivan on 02.02.2018.
 */
public class BishopTest {
    @Test
    public void checkMove() {
        Board board=Board.getBoard();
        Tile fTile=new Tile(3,3);
        Tile dTile=new Tile(1,1);
        Move move=new Move(fTile,dTile);
        boolean exp=board.getPieceMap().get(fTile).checkMove(move);
        assertEquals(true,exp);
    }
}
