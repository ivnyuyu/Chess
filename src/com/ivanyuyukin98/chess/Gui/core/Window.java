package com.ivanyuyukin98.chess.Gui.core;

import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.Events.Event;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseMotionEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MousePressedEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseReleasedEvent;
import com.ivanyuyukin98.chess.Gui.SandBox.LayerPiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Window extends Canvas {
    private BufferStrategy bs;
    private ArrayList<Integer> ss;
    private Graphics g;
    private JFrame frame;
    private static ArrayList<LayerPiece> pieceLayer=new ArrayList<LayerPiece>();

    public static ArrayList<LayerPiece> getPieceLayer() {
        return pieceLayer;
    }

    public Window(String name, int width, int height){
        setPreferredSize(new Dimension(width,height));
        init(name);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                MousePressedEvent event=new MousePressedEvent(e.getButton(),e.getX(),e.getY());
                onEvent(event);

            }
            public void mouseReleased(MouseEvent e){
                MouseReleasedEvent event=new MouseReleasedEvent(e.getButton(),e.getX(),e.getY());
                onEvent(event);
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MouseMotionEvent event= new MouseMotionEvent(e.getX(),e.getY(),true);
                onEvent(event);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                MouseMotionEvent event= new MouseMotionEvent(e.getX(),e.getY(),false);
                onEvent(event);
            }
        });
        render();

    }
    public void init(String name){
        frame=new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    private void render(){
        if(bs==null){
            createBufferStrategy(3);
        }
        bs=getBufferStrategy();
        g=bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        for(int i=0; i<getWidth();i+=80){
            g.drawLine(i,0,i,getHeight());
        }
        for(int i=0; i<getHeight();i+=80){
            g.drawLine(0,i,getHeight(),i);
        }
        onRender(g);
        g.dispose();
        bs.show();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
        }
        EventQueue.invokeLater(()->render());

    }
    private void onRender(Graphics g){
        for(int i=0;i<pieceLayer.size();i++){
            pieceLayer.get(i).onRender(g);
        }
    }
    private void onEvent(Event event){
        for(int i=pieceLayer.size()-1;i>=0;i--){
            pieceLayer.get(i).onEvent(event);
        }
    }
    public static void addLayer(LayerPiece layer){
        pieceLayer.add(layer);
    }
    public static void deleteLayer(Tile tile){
        for(int i=0;i<pieceLayer.size();i++){
            if(pieceLayer.get(i).getTile().equals(tile)){
                pieceLayer.remove(pieceLayer.get(i));

            }
        }
    }

}
