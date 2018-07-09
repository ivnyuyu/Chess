package com.ivanyuyukin98.chess.Gui.SandBox;

import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.Events.Dispatcher;
import com.ivanyuyukin98.chess.Gui.Events.Event;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseMotionEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MousePressedEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseReleasedEvent;
import com.ivanyuyukin98.chess.Gui.Layers.Layer;
import com.ivanyuyukin98.chess.Gui.core.ConvertorPxinCoordinate;
import com.ivanyuyukin98.chess.controller.ChessMove;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class LayerPiece extends Layer {
    final private int sizeScreen=640;
    final private int sizeTile=80;
    private int firstX, firstY;
    private Image image;
    private int x,y;
    private Tile tile;
    private boolean dragging=false;
    private int px,py;
    private int realX;
    private int realY;
    private final String filename;
    public LayerPiece(int x, int y, String name, Tile tile) throws IOException {
        this.x=x;
        this.y=y;
        this.tile=tile;
        realX=x;
        realY=y;
        filename=typeName(name);
        image = ImageIO.read(new File(filename));
    }

    private String typeName(String name) {
        switch (name){
            case "pawnb":
                return "D:\\Chess\\img\\pawnb.png";
            case "pawnw":
                return "D:\\Chess\\img\\pawnw.png";

            case "rookb":
                return "D:\\Chess\\img\\rookb.png";
            case "rookw":
                return "D:\\Chess\\img\\rookw.png";

            case "horseb":
                return "D:\\Chess\\img\\horseb.png";
            case "horsew":
                return "D:\\Chess\\img\\horsew.png";

            case "bishopb":
                return "D:\\Chess\\img\\bishopb.png";
            case "bishopw":
                return "D:\\Chess\\img\\bishopw.png";

            case "queenb":
                return "D:\\Chess\\img\\queenb.png";
            case "queenw":
                return "D:\\Chess\\img\\queenw.png";

            case "kingb":
                return "D:\\Chess\\img\\kingb.png";
            case "kingw":
                return "D:\\Chess\\img\\kingw.png";
                default:
                    System.out.println("err");

        }
        return "";
    }

    public Tile getTile() {
        return tile;
    }
    public boolean contain(int xd, int yd){
        if((x<xd&&x+sizeTile>=xd)&&(y<yd&&y+sizeTile>=yd))
            return true;
        return false;
    }
    @Override
    public void onEvent(Event event) {
        Dispatcher dispatcher=new Dispatcher(event);
        dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e)->onPressed((MousePressedEvent)e));
        dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e)->onReleased((MouseReleasedEvent)e));
        dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e)->onMoved((MouseMotionEvent)e));
    }
    @Override
    public void onRender(Graphics g){
        g.drawImage(image,x,y,null);
    }
    private boolean onPressed(MousePressedEvent event){
        if(contain(event.getX(),event.getY())){
            firstX=event.getX();
            firstY=event.getY();
            dragging=true;

        }
        return dragging;
    }
    private boolean onReleased(MouseReleasedEvent event){
        if(contain(event.getX(),event.getY()))
        if(event.getX()>sizeScreen||event.getY()>sizeScreen){
            x=realX;
            y=realY;
        }

        if(dragging){
            ConvertorPxinCoordinate.convert(firstX,firstY,event.getX(),event.getY());
            int arr[]=ConvertorPxinCoordinate.getArr();
            ChessMove cm= new ChessMove();
            if(cm.checkMove(arr)){
                tile=new Tile(arr[2],arr[3]);
                if(contain(event.getX(),event.getY())) {
                    for (int i = 0; i < sizeScreen; i += sizeTile) {
                        for (int j = 0; j < sizeScreen; j += sizeTile) {
                            if (i < event.getX() && i + sizeTile > event.getX() && j < event.getY() && j + sizeTile > event.getY()) {
                                x = i;
                                y = j;
                                realX = i;
                                realY = j;
                            }
                        }
                    }
                }
            }else{
                x=realX;
                y=realY;
            }
        }
        dragging=false;
        return false;
    }
    private boolean onMoved(MouseMotionEvent event){
        if(dragging){
            x+=event.getX()-px;
            y+=event.getY()-py;
        }
        px=event.getX();
        py=event.getY();
        return dragging;
    }
}