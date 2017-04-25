/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author My PC
 */
public class GameWindow extends Frame {

    Image backgroundImage;
    Player player;
    boolean isUpPressed, isDownPressed, isRightPressed, isLeftPressed;
    boolean isSpaceImage;
    BufferedImage backbufferedImage;
    Graphics backBufferedgraphics;

    public GameWindow() {
        player=new Player(200-10, 300-10,Utils.loadImage("res/plane2.png"));
        backbufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferedgraphics = backbufferedImage.getGraphics();
        setVisible(true);
        setSize(600, 800);
        // listener: 
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                //System.exit(0);
                dispose();
                System.out.println("closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("close");
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        isRightPressed = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        isLeftPressed = true;
                        break;
                    case KeyEvent.VK_UP:
                        isUpPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDownPressed = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        isSpaceImage = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        isRightPressed = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        isLeftPressed = false;
                        break;
                    case KeyEvent.VK_UP:
                        isUpPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDownPressed = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        isSpaceImage = false;
                        break;
                }
            }
        });
//
        try {
            backgroundImage = ImageIO.read(new File("res/background.png"));
            //player = ImageIO.read(new File("res/plane2.png"));

        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Step 2: Draw
        // redraw
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {// chay lien tuc
                    try {

                        //To change body of generated methods, choose Tools | Templates.
                        Thread.sleep(17);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //logic
                    player.move(isUpPressed,isDownPressed,isRightPressed,isLeftPressed,isSpaceImage);
                    player.update();
                    //draw
                    repaint();
                }
            }

        });
        thread.start();
    }




    @Override
    public void update(Graphics g) {
        backBufferedgraphics.drawImage(backgroundImage, 0, 0, 600, 800, null);
       player.draw(backBufferedgraphics);
        g.drawImage(backbufferedImage, 0, 0, this);// draw backbuffer on game window
    }

}
