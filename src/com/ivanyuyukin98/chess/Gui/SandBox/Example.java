package com.ivanyuyukin98.chess.Gui.SandBox;


import com.ivanyuyukin98.chess.Gui.Events.Dispatcher;
import com.ivanyuyukin98.chess.Gui.Events.Event;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseMotionEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MousePressedEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseReleasedEvent;
import com.ivanyuyukin98.chess.Gui.Layers.Layer;
import com.ivanyuyukin98.chess.Gui.core.ConvertorPxinCoordinate;
import com.ivanyuyukin98.chess.Gui.core.Window;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Example extends Layer {
    private Map<Integer, Example> pieceMap=new HashMap<>();
    private  void addPiece(){
        pieceMap.put(1,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(2,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(3,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(4,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(5,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(6,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(7,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(8,new Example(1,1,"Pawn",Color.black));
        pieceMap.put(1,new Example(1,1,"Rook",Color.black));
        pieceMap.put(1,new Example(1,1,"Horse",Color.black));
        pieceMap.put(1,new Example(1,1,"Bishop",Color.black));
        pieceMap.put(1,new Example(1,1,"Bishop",Color.black));
    }
    private String name;
    private Color color;
    private Rectangle rect;
    private boolean dragging=false;
    private int px,py;
    private static Random random=new Random();
    private int realX=random.nextInt(640);
    private int realY=random.nextInt(640);
    private static int fCoordinateX;
    private static int fCoordinateY;
    private static int lCoordinateX;
    private static int lCoordinateY;
    private boolean activePiece=false;
    public Example(int x, int y, String name, Color color){
        this.name=name;
        this.color=color;
        rect=new Rectangle(x,y, 80,80);
    }
    @Override
    public void onEvent(Event event) {
        Dispatcher dispatcher=new Dispatcher(event);
        dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e)->onPressed((MousePressedEvent)e));
        dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e)->onReleased((MouseReleasedEvent)e));
        dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e)->onMoved((MouseMotionEvent)e));
    }
    public void onRender(Graphics g){
        g.setColor(color);
        g.fillRect(rect.x,rect.y,rect.width,rect.height);
        g.setColor(Color.BLACK);
        g.drawString(name,rect.x+25,rect.y+40);
    }
    private boolean onPressed(MousePressedEvent event){
        if(rect.contains(new Point(event.getX(),event.getY()))){
            fCoordinateX=event.getX();
            fCoordinateY=event.getY();
            dragging=true;
            activePiece=true;
        }
        return dragging;
    }
    private boolean onReleased(MouseReleasedEvent event){
        if(rect.contains(new Point(event.getX(),event.getY()))&&activePiece){
         for(int i=0;i<640;i+=80){
             for(int j=0;j<640;j+=80){
                 if(event.getX()>640||event.getY()>640)
                 {
                     rect.x=realX;
                     rect.y=realY;
                 }
                 if(i<event.getX() && i+80>event.getX() &&j<event.getY()&& j+80>event.getY())
                 {
                     rect.x=i;
                     rect.y=j;
                     realX=i;
                     realY=j;
                 }
             }
             lCoordinateX=event.getX();
             lCoordinateY=event.getY();

         }
            ConvertorPxinCoordinate.convert(fCoordinateX,fCoordinateY,lCoordinateX,lCoordinateY);
        }
        activePiece=false;
        dragging=false;
        return false;
    }
    private boolean onMoved(MouseMotionEvent event){
        if(dragging){
            rect.x+=event.getX()-px;
            rect.y+=event.getY()-py;
        }
        px=event.getX();
        py=event.getY();
        return dragging;
    }
}
