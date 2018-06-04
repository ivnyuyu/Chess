package com.ivanyuyukin98.chess.Board;

/**
 * Created by Ivan on 02.02.2018.
 */
public class Tile {
    private int x;
    private int y;
    public Tile(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (x*1000)+y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null||obj.getClass()!=this.getClass()){
            return false;
        }
        Tile tile=(Tile) obj;
        if(this.x==tile.x&&this.y==tile.y) return true;
        return false;
    }
}
