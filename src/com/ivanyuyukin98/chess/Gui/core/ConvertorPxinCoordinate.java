package com.ivanyuyukin98.chess.Gui.core;
import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.SandBox.LayerPiece;

public class ConvertorPxinCoordinate {
    private static int firstX, firstY, lastX, lastY;
    private static Move lastMove;
    private static int arr[]=new int[4];

    public static int[] getArr() {
        return arr;
    }

    public static void convert(int fx, int fy, int lx, int ly, LayerPiece ex){
        for(int i=0,x=0;i<640;i+=80,x++){
            for (int j=0,y=0; j<640;j+=80,y++){
                if(i<fx && i+80>fx &&j<fy&& j+80>fy){
                    firstX=x;
                    firstY=y;
                }
                if(i<lx && i+80>lx &&j<ly&& j+80>ly){
                    lastX=x;
                    lastY=y;
                }
            }
        }
        arr[0]=firstX;
        arr[1]=firstY;
        arr[2]=lastX;
        arr[3]=lastY;

        System.out.println(firstX+" ,"+firstY);
        System.out.print("/");
        System.out.println(lastX+" ,"+lastY);

        Board board=Board.getBoard();
        Move move=new Move(new Tile(firstY,firstX),new Tile(lastY,lastX));
        if(!move.equals(lastMove)) {
            if (board.getPieceMap().get(new Tile(firstY, firstX)).checkMove(move)) {
                Window.deleteLayer(new Tile(lastX, lastY));
                board.getPieceMap().get(new Tile(firstY, firstX)).makeMove(move);
                lastMove = move;
            }
        }

    }
}

