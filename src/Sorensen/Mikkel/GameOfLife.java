package Sorensen.Mikkel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

public class GameOfLife extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;

    /* Sætter framsize */
    public static int frameSize = 360;
    /* Sætter title */
    public static String title = "Game Of Life";

    /* Variabler */
    public BufferedImage image;
    public int[] pixels;
    public int gridSize = 100;
    Random r = new Random();

    /* Constructor */
    public GameOfLife(){
        Dimension d = new Dimension(frameSize, frameSize);
        setMinimumSize(d);
        setMaximumSize(d);
        setPreferredSize(d);


        image = new BufferedImage(gridSize, gridSize, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }



    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            update();
            render();
        }
    }

    public void update() {

    }

    /* Laver en render metode, med en bufferstrategy. Bufferstrategyen hjælper til med at render Canvas / Window */
    public void render() {
    BufferStrategy bs = getBufferStrategy();

    if (bs == null){
        createBufferStrategy(3);
        return;
    }

    Graphics g = bs.getDrawGraphics();



    for (int i = 0; i < pixels.length; i++) {
        pixels[i] = r.nextInt(0xfffffff);
    }

    g.drawImage(image, 0, 0, frameSize, frameSize,  null);
    g.dispose();
    bs.show();
    }
    public static void main(String[] args) {

        /* Laver et nyt Jframe, samt definerer hvad der skal ske */
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        GameOfLife gol = new GameOfLife();
        frame.add(gol);
        frame.pack();

        frame.setVisible(true);

        gol.start();


    }


}
