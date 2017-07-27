/**
 * Created by reecemartin on 2017-07-16.
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
    int x = 0;
    int y = 0;
    private boolean xplus = true;
    private boolean yplus = true;

    private void moveBall() {
        if (xplus) {
            x++;
            if (x > 300) {
                xplus = false;
            }
        } else {
            x--;
            if (x < 0) {
                xplus = true;
            }
        }
        if (yplus) {
            y++;
            if (y > 400) {
                yplus = false;
            }
        } else {
            y--;
            if (y < 0) {
                yplus = true;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Sample Frame");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(1);
        }
    }
}


