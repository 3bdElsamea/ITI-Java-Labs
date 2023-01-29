import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.*;

class MovingBall extends JFrame implements Runnable {
    JLabel ballLabel;
    Thread ballThread;
    int x = 200;
    int y = 0;
    int xDir = 10;
    int yDir = 10;

    MovingBall() {
        ballLabel = new JLabel();
        this.setTitle("Moving Ball");
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ballLabel.setBounds(x, y, 50, 50);
        ballLabel.setIcon(new ImageIcon("ball.png"));
        this.add(ballLabel);
        ballThread = new Thread(this);
        ballThread.start();
    }

    @Override
    public void run() {
        while (true) {
            x += xDir;
            y += yDir;
            ballLabel.setBounds(x, y, 50, 50);
            if (x <= 0 | x >= this.getWidth() - ballLabel.getWidth()) {
                xDir *= -1;
            }
            if (y <= 0 | y >= this.getHeight() - ballLabel.getHeight()) {
                yDir *= -1;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main
    public static void main(String[] args) {
        MovingBall movingBall = new MovingBall();

    }
}