package com.ivanyuyukin98.chess.Board;

/**
 * Created by Ivan on 02.02.2018.
 */
public class Move {
    private Tile firstTile;
    private Tile destinationTile;
    public Move(Tile firstTile,Tile destinationTile){
        this.firstTile=firstTile;
        this.destinationTile=destinationTile;
    }
    public Tile getFirstTile(){
        return firstTile;
    }
    public Tile getDestinationTile(){
        return destinationTile;
    }
    public boolean isDiagonal(){
        if(Math.abs(firstTile.getX()-destinationTile.getX())==Math.abs(firstTile.getY()-destinationTile.getY())) return true;
        return false;
    }
    public boolean isVertical(){
        if(firstTile.getY()==destinationTile.getY()) return true;
            return false;
    }
    public boolean isHorizontal(){
        if(firstTile.getX()==destinationTile.getX()) return true;
        return false;
    }
    public boolean isColorSame(){
        Board board=Board.getBoard();
        if(board.getPieceMap().get(destinationTile)!=null)
            if(board.getPieceMap().get(destinationTile).getColor()==board.getPieceMap().get(firstTile).getColor()) return true;
            return false;
    }
    public boolean isValidPathDiagonal(){
        Board board=Board.getBoard();
        int x0=firstTile.getX();
        int y0=firstTile.getY();
        int x1=destinationTile.getX();
        int y1=destinationTile.getY();
        if((x0>x1) &&(y0<y1)){
            x1++;
            y1--;
            while(x0!=x1&&y0!=y1){
                x0--;
                y0++;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }
        }
        if((x0<x1) &&(y0<y1)){
            x1--;
            y1--;
            while(x0!=x1&&y0!=y1){
                x0++;
                y0++;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }
        }
        if((x0>x1) &&(y0>y1)){
            x1++;
            y1++;
            while(x0!=x1&&y0!=y1){
                x0--;
                y0--;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }
        }
        if((x0<x1) &&(y0>y1)){
            x1--;
            y1++;
            while(x0!=x1&&y0!=y1){
                x0++;
                y0--;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidPathVerticalOrHorizontal(){
        Board board=Board.getBoard();
        int x0=firstTile.getX();
        int y0=firstTile.getY();
        int x1=destinationTile.getX();
        int y1=destinationTile.getY();
        if((x0==x1)&&(y0>y1)){
            y1++;
            while(y0!=y1){
                y0--;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }
        }
        if((x0==x1)&&(y0<y1)){
            y1--;
            while (y0!=y1){
                y0++;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }

            }

        }
        if((x0>x1)&&(y0==y1)){
            x1++;
            while (x0!=x1){
                x0--;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }

        }
        if((x0<x1)&&(y0==y1)){
            x1--;
            while (x0!=x1){
                x0++;
                if(board.getPieceMap().get(new Tile(x0,y0))!=null){
                    System.out.println(board.getPieceMap().get(new Tile(x0,y0)));
                    return false;
                }
            }

        }
        return true;
    }
    public int diffVertical(){
        return Math.abs(firstTile.getY()-destinationTile.getY());
    }
    public int diffHorizontal(){
        return Math.abs(firstTile.getX()-destinationTile.getX());
    }


}
