package com.ivanyuyukin98.chess.Board;

public class LocationKing {

    static Tile locationWKing;
    static Tile locationBKing;
    public  LocationKing(){

    }
    public static void setLocationWKing(Tile tile){
        locationWKing=tile;
    }
    public static void setLocationBKing(Tile tile){
        locationBKing=tile;
    }
    public static Tile getLocationWKing(){
        return locationWKing;
    }
    public static Tile getLocationBKing(){
        return locationBKing;
    }
}
