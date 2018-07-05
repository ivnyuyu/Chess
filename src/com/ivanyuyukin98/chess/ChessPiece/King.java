package com.ivanyuyukin98.chess.ChessPiece;

import com.ivanyuyukin98.chess.Board.Board;
import com.ivanyuyukin98.chess.Board.LocationKing;
import com.ivanyuyukin98.chess.Board.Move;
import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.SandBox.LayerPiece;
import com.ivanyuyukin98.chess.Gui.core.Window;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Ivan on 02.02.2018.
 */
public class King extends Piece {
    private boolean isFirstMove=true;
    public King(ColorPiece color){
        super(color);
        if(color==ColorPiece.W){
            LocationKing.setLocationWKing(new Tile(7,4));
        }else{
            LocationKing.setLocationBKing(new Tile(0,4));
        }


    }
    private String consoleName="K";
    public String getConsoleName(){
        return consoleName;
    }

    @Override
    public boolean isProtectedTile(Move move) {
        if(move.diffHorizontal()==0&&move.diffVertical()==0) return false;
        if(move.isDiagonal()){
            if(move.diffHorizontal()-move.diffVertical()==0) return true;
            return false;
        }
        if(move.isVertical()||move.isHorizontal()){
            if(Math.abs(move.diffVertical()-move.diffHorizontal())!=1) return false;
            return true;
        }
        return false;
    }
    public boolean isProtectedTiles(Move move){
        Board board=Board.getBoard();
        if(move.isDiagonal()){

            if(move.diffHorizontal()!=1) return false;
            if(move.diffVertical()!=1) return false;

        }
        if(move.isVertical()||move.isHorizontal()){

            if(Math.abs(move.diffVertical()-move.diffHorizontal())!=1) return false;
        }
        Map<Tile, Piece> pieceMap=board.getPieceMap();
        Tile dTile=move.getDestinationTile();
        for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
            Tile fTile=entry.getKey();
            Move move2=new Move(fTile,dTile);
            if(pieceMap.get(fTile).getColor()==this.getColor()) continue;
            if(pieceMap.get(fTile).isProtectedTile(move2)) {
                return false;
            }
        }

        if(getColor()==ColorPiece.W){
            LocationKing.setLocationWKing(move.getDestinationTile());
        }else{
            LocationKing.setLocationBKing(move.getDestinationTile());
        }

        return true;
    }
    public  boolean checkMove(Move move) {
        if(!checkMoveQueue()) return false;
        if (move.isColorSame()) return false;
        if(checkRoque(move)){
            if(getColor()==ColorPiece.W){
                LocationKing.setLocationWKing(move.getDestinationTile());
            }else{
                LocationKing.setLocationBKing(move.getDestinationTile());
            }
            return true;
        }

        if (!isProtectedTiles(move)) return false;
        isFirstMove=false;
        return true;
    }
    private boolean checkRoque(Move move){
        Board board=Board.getBoard();
        Map<Tile, Piece> pieceMap=board.getPieceMap();
        if(!move.isHorizontal()) return false;
        if(!isFirstMove) return false;
        //roque for white king
        if(getColor()==ColorPiece.W){
            if(move.getDestinationTile().equals(new Tile(7,6))){
                if(board.getPieceMap().get(new Tile(7,7))instanceof Rook){
                if(board.getPieceMap().get(new Tile(7,6))==null){
                    if(board.getPieceMap().get(new Tile(7,5))==null){
                        for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
                            Tile fTile=entry.getKey();
                            Move move2=new Move(fTile,new Tile(7,6));
                            if(pieceMap.get(fTile).getColor()==pieceMap.get(move.getFirstTile()).getColor()) continue;
                            if(pieceMap.get(fTile).isProtectedTile(move2)) {
                                return false;
                            }
                        }
                        Window.deleteLayer(new Tile(7,7));
                        try {
                            Window.addLayer(new LayerPiece(400, 560, "rookw", new Tile(5, 7)));
                            Board.getBoard().getPieceMap().put(new Tile(7,5),new Rook(ColorPiece.W));
                            Board.getBoard().getPieceMap().remove(new Tile(7,7));
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                        return true;
                    }

                }
                }



            }

                if(move.getDestinationTile().equals(new Tile(7,2))){
                    if(board.getPieceMap().get(new Tile(7,0))instanceof Rook){
                        if(board.getPieceMap().get(new Tile(7,1))==null){
                            if(board.getPieceMap().get(new Tile(7,2))==null &&board.getPieceMap().get(new Tile(7,3))==null){
                                for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
                                    Tile fTile=entry.getKey();
                                    Move move2=new Move(fTile,new Tile(7,2));
                                    if(pieceMap.get(fTile).getColor()==pieceMap.get(move.getFirstTile()).getColor()) continue;
                                    if(pieceMap.get(fTile).isProtectedTile(move2)) {
                                        return false;
                                    }
                                }
                                Window.deleteLayer(new Tile(0,7));
                                try {

                                    Window.addLayer(new LayerPiece(240, 560, "rookw", new Tile(3, 7)));
                                    Board.getBoard().getPieceMap().put(new Tile(7,3),new Rook(ColorPiece.W));
                                    Board.getBoard().getPieceMap().remove(new Tile(7,0));
                                }catch (IOException e){
                                    e.printStackTrace();
                                }

                                return true;
                            }

                        }
                    }





            }
        }
        //roque for black king
        if(getColor()==ColorPiece.B){
            if(move.getDestinationTile().equals(new Tile(0,6))){
                if(board.getPieceMap().get(new Tile(0,7))instanceof Rook){
                    if(board.getPieceMap().get(new Tile(0,6))==null){
                        if(board.getPieceMap().get(new Tile(0,5))==null){
                            for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
                                Tile fTile=entry.getKey();
                                Move move2=new Move(fTile,new Tile(0,6));
                                if(pieceMap.get(fTile).getColor()==pieceMap.get(move.getFirstTile()).getColor()) continue;
                                if(pieceMap.get(fTile).isProtectedTile(move2)) {
                                    return false;
                                }
                            }
                            Window.deleteLayer(new Tile(7,0));
                            try {
                                Window.addLayer(new LayerPiece(400, 0, "rookb", new Tile(5, 0)));
                                Board.getBoard().getPieceMap().put(new Tile(0,5),new Rook(ColorPiece.B));
                                Board.getBoard().getPieceMap().remove(new Tile(0,7));
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                            return true;
                        }

                    }
                }



            }

            if(move.getDestinationTile().equals(new Tile(0,2))){
                if(board.getPieceMap().get(new Tile(0,0))instanceof Rook){
                    if(board.getPieceMap().get(new Tile(0,1))==null){
                        if(board.getPieceMap().get(new Tile(0,2))==null &&board.getPieceMap().get(new Tile(0,3))==null){
                            for(Map.Entry<Tile, Piece> entry: pieceMap.entrySet()){
                                Tile fTile=entry.getKey();
                                Move move2=new Move(fTile,new Tile(0,2));
                                if(pieceMap.get(fTile).getColor()==pieceMap.get(move.getFirstTile()).getColor()) continue;
                                if(pieceMap.get(fTile).isProtectedTile(move2)) {
                                    return false;
                                }
                            }
                            Window.deleteLayer(new Tile(0,0));
                            try {


                                Window.addLayer(new LayerPiece(240, 0, "rookb", new Tile(3, 0)));
                                Board.getBoard().getPieceMap().put(new Tile(0,3),new Rook(ColorPiece.B));
                                Board.getBoard().getPieceMap().remove(new Tile(0,0));
                            }catch (IOException e){
                                e.printStackTrace();
                            }

                            return true;
                        }

                    }
                }





            }
        }

        return false;
    }

}
