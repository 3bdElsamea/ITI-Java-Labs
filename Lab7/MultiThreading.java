import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.*;

public class MultiThreading extends JFrame {
    // Date
    JLabel timeLabel = new JLabel();
    Thread dateThread;
    Date date;

    // Moving Text
    JLabel movingTextLabel = new JLabel("Ahmed Abdelsamea");
    Thread movingTextThread;

    // Ball
    JLabel ballLabel = new JLabel();
    Thread ballThread;

    public MultiThreading() {
        this.setTitle("Multi Threading Lab");
        this.setLayout(null);

        // Date
        DateTime dateTime = new DateTime();
        dateThread = new Thread(dateTime);
        dateThread.start();
        // Moving Text
        MovingText movingText = new MovingText();
        movingTextThread = new Thread(movingText);
        movingTextThread.start();

        // Moving Ball
        MovingBall movingBall = new MovingBall();
        ballThread = new Thread(movingBall);
        ballThread.start();

    }

    // For DateTime Thread
    class DateTime implements Runnable {
        DateTime() {
            timeLabel.setBounds(200, 50, 200, 30);
            MultiThreading.this.add(timeLabel);
        }

        @Override
        public void run() {
            while (true) {
                date = new Date();
                timeLabel.setText(date.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // For Moving Text Thread
    class MovingText implements Runnable {
        MovingText() {
            movingTextLabel.setBounds(0, 150, 150, 30);
            MultiThreading.this.add(movingTextLabel);
        }

        @Override
        public void run() {
            int x = 0;
            int xDir = 1;
            while (true) {
                movingTextLabel.setBounds(x, 150, 150, 30);
                x += xDir;
                if (x <= 0 | x >= MultiThreading.this.getWidth() - movingTextLabel.getWidth()) {
                    xDir *= -1;
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // For MovingBall Thread
    class MovingBall implements Runnable {
        MovingBall() {
            ballLabel.setIcon(new ImageIcon("ball.png"));
            ballLabel.setBounds(250, 0, 50, 50);
            MultiThreading.this.add(ballLabel);

        }

        @Override
        public void run() {
            int x = 250;
            int y = 0;
            int xDir = 10;
            int yDir = 10;
            while (true) {
                ballLabel.setBounds(x, y, 50, 50);
                x += xDir;
                y += yDir;
                if (x <= 0 | x >= MultiThreading.this.getWidth() - ballLabel.getWidth()) {
                    xDir *= -1;
                }
                if (y <= 0 | y >= MultiThreading.this.getHeight() - ballLabel.getHeight()) {
                    yDir *= -1;
                }

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Main
    public static void main(String[] args) {

        MultiThreading app = new MultiThreading();
        app.setBounds(50, 50, 700, 700);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
