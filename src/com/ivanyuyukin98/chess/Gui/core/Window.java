package com.ivanyuyukin98.chess.Gui.core;

import com.ivanyuyukin98.chess.Board.ColorQueue;
import com.ivanyuyukin98.chess.Board.Tile;
import com.ivanyuyukin98.chess.ChessPiece.Piece;
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

    private Graphics g;
    private JFrame frame;
    private Image image;
    private static ArrayList<LayerPiece> pieceLayer=new ArrayList<LayerPiece>();

    public static ArrayList<LayerPiece> getPieceLayer() {
        return pieceLayer;
    }

    public Window(String name, int width, int height){
        try{
            image = ImageIO.read(new File("D:\\Chess\\img\\chessboard.png"));
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
        g.setColor(Color.BLUE);
        g.fillRect(0,0,1000,1000);
        /*if(CheckListener.getIsLastHorizontalForPawn()==false){
            try{
                Image imageRook= ImageIO.read(new File("D:\\Chess\\img\\rookw.png"));
                Image imageHorse= ImageIO.read(new File("D:\\Chess\\img\\horsew.png"));
                Image imageBishop= ImageIO.read(new File("D:\\Chess\\img\\bishopw.png"));
                Image imageQueen= ImageIO.read(new File("D:\\Chess\\img\\queenw.png"));
                g.drawImage(imageRook,700,0,null);
                g.drawImage(imageHorse,700,80,null);
                g.drawImage(imageBishop,700,160,null);
                g.drawImage(imageQueen,700,240,null);

            }catch (IOException e){
                e.printStackTrace();
            }

        }*/
        if(CheckListener.getCheck()){
            g.setColor(Color.RED);
            g.fillRect(0,0,1000,1000);
        }
        if(ColorQueue.getColorQueue()==Piece.ColorPiece.W) {

            g.setColor(Color.WHITE);
            g.fillRect(0,500,1000,1000);
        }else{

            g.setColor(Color.BLACK);
            g.fillRect(0,500,1000,1000);
        }
        /*g.drawImage(image,0,0,null);*/
        boolean t=true;
        int z=64;
        g.setColor(Color.GREEN);
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if((i+j)%2==0){
                    g.setColor(Color.WHITE);
                }else{
                    g.setColor(Color.GRAY);
                }
                g.fillRect(j*80-80,i*80-80,80,80);
            }

        }
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
