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

    public boolean[] cGrid;
    public boolean[] pGrid;

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

        cGrid = new boolean[pixels.length];
        pGrid = new boolean[pixels.length];
        for (int i = 0; i < cGrid.length; i++){
            cGrid[i] = r.nextInt() / 100.0 > 70.0 ? true : false;
        }

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

    // Disse forloops ændre graphics / hvordan pixels ser ud i GameOfLife
    for (int i = 0; i < pixels.length; i++) {
        pixels[i] = 0;
    }
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = cGrid[i] ? 0xffffff : 0;
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
