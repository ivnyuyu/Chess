package com.ivanyuyukin98.chess.Gui.core;

import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.Gui.Events.Event;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseMotionEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MousePressedEvent;
import com.ivanyuyukin98.chess.Gui.Events.types.MouseReleasedEvent;
import com.ivanyuyukin98.chess.Gui.SandBox.LayerPiece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Window extends Canvas {
    private BufferStrategy bs;
    private ArrayList<Integer> ss;
    private Graphics g;
    private JFrame frame;
    private Image image;
    private static ArrayList<LayerPiece> pieceLayer=new ArrayList<LayerPiece>();

    public static ArrayList<LayerPiece> getPieceLayer() {
        return pieceLayer;
    }

    public Window(String name, int width, int height){
        try{
            image = ImageIO.read(new File("D:\\Chess\\img\\chessboard.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }

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
        g.drawImage(image,0,0,null);
        /*g.setColor(Color.BLACK);
        for(int i=0; i<getWidth();i+=80){
            g.drawLine(i,0,i,getHeight());
        }
        for(int i=0; i<getHeight();i+=80){
            g.drawLine(0,i,getHeight(),i);
        }*/

        /*int z=2;
        g.setColor(Color.GRAY);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(z%2==0)

                g.fillRect(80*j-80,80*i-80,80,80);
                z++;
            }
        }*/
        onRender(g);
        g.dispose();
        bs.show();
        try{
            Thread.sleep(1);
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
