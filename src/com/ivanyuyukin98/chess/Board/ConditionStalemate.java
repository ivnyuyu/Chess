/*package com.ivanyuyukin98.chess.Board;

import com.ivanyuyukin98.chess.ChessPiece.Piece;
import com.ivanyuyukin98.chess.Display.ConsoleDisplay;

import java.util.ArrayList;
import java.util.Map;

public class ConditionStalemate {
    Board board=Board.getBoard();
    Piece.ColorPiece color;
    public ConditionStalemate(Piece.ColorPiece color){
        this.color=color;
    }
    public boolean checkMate(Tile tile){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board.getPieceMap().get(tile).checkMove(new Move(tile,new Tile(i,j))))
                if(checkMoveMate(new Move(tile,new Tile(i,j)))) return true;

            }
        }
        return false;
    }
    private boolean checkMoveMate(ArrayList<Tile> arrayList){
        for(int z=0;z<arrayList.size();z++){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(board.getPieceMap().get(arrayList.get(z)).checkMove(new Move(arrayList.get(z),new Tile(i,j)))){

                        Boolean isGood=false;
                        Piece p=null;
                        Piece d=null;
                        if(board.getPieceMap().get(new Move(arrayList.get(z),new Tile(i,j)).getFirstTile())!=null){
                            p=board.getPieceMap().get(new Move(arrayList.get(z),new Tile(i,j)).getFirstTile());
                        }
                        if(board.getPieceMap().get(new Move(arrayList.get(z),new Tile(i,j)).getDestinationTile())!=null){
                            d=board.getPieceMap().get(new Move(arrayList.get(z),new Tile(i,j)).getDestinationTile());
                        }
                        board.getPieceMap().put(new Move(arrayList.get(z),new Tile(i,j)).getDestinationTile(),board.getPieceMap().get(new Move(arrayList.get(z),new Tile(i,j)).getFirstTile()));
                        board.getPieceMap().remove(new Move(arrayList.get(z),new Tile(i,j)).getFirstTile());
                        Map<Tile, Piece> pieceMap=board.getPieceMap();
                        Tile dTile;
                        Tile tempCheck;

                        if(ColorQueue.getColorQueue()==Piece.ColorPiece.W){
                            tempCheck=LocationKing.getLocationBKing();
                            dTile=LocationKing.getLocationBKing();
                        }else{
                            tempCheck=LocationKing.getLocationWKing();
                            dTile=LocationKing.getLocationBKing();
                        }
        *//*ConsoleDisplay cd=new ConsoleDisplay();
        cd.showBoard();*//*

                        for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
                            Tile fTile=entry.getKey();
                            Move move2=new Move(fTile,dTile);
                            if(pieceMap.get(fTile).getColor()==pieceMap.get(dTile).getColor()) continue;
                            if(!pieceMap.get(fTile).isProtectedTile(move2)) {
                                isGood=false;
                                break;
                *//*System.out.println("фигура  в безопастности!");
                ConsoleDisplay cd=new ConsoleDisplay();
                cd.showBoard();*//*
                *//*isGood=true;
               // System.out.println(move2.getFirstTile().getX()+""+move2.getFirstTile().getX()+"/"+move2.getDestinationTile().getX()+""+move2.getDestinationTile().getX());
                System.out.println("Есть доступные ходы! fy");
                break;*//*
                            }
                        }

                        if(p!=null){
                            board.getPieceMap().remove(new Move(arrayList.get(z),new Tile(i,j)).getFirstTile());
                            board.getPieceMap().put(new Move(arrayList.get(z),new Tile(i,j)).getFirstTile(), p);
                        }
                        if(d!=null){
                            board.getPieceMap().remove(new Move(arrayList.get(z),new Tile(i,j)).getDestinationTile());
                            board.getPieceMap().put(new Move(arrayList.get(z),new Tile(i,j)).getDestinationTile(),d);
                        }else{
                            board.getPieceMap().remove(new Move(arrayList.get(z),new Tile(i,j)).getDestinationTile());
                        }
                        System.out.println("After:");
                        ConsoleDisplay c=new ConsoleDisplay();
                        c.showBoard();

                    }
                }
            }

        }


        return false;
    }
}*/
