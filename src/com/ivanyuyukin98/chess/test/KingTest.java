package com.ivanyuyukin98.chess.test;
import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan on 05.02.2018.
 */
public class KingTest {
    @Test
    public void checkMove(){
        Board board=Board.getBoard();
        Tile fTile=new Tile(4,4);
        Tile dTIle=new Tile(3,3);
        Move move=new Move(fTile,dTIle);
        boolean expected=board.getPieceMap().get(fTile).checkMove(move);
        assertEquals(true, expected);
    }
}
