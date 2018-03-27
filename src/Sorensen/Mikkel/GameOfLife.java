package Sorensen.Mikkel;



import javax.swing.*;
import java.awt.*;

public class GameOfLife extends Canvas implements Runnable{

    public static int frameSize = 360;
    public static String title = "Game Of Life";

    public GameOfLife(){
        Dimension d = new Dimension(frameSize, frameSize);
        setMinimumSize(d);
        setMaximumSize(d);
        setPreferredSize(d);
    }

    @Override
    public void run() {
        while (true){

        }
    }

    public void start(){
        new Thread(this).start();
    }

    public static void main(String[] args) {
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
