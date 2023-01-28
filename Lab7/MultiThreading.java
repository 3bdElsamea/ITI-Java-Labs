import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.*;

public class MultiThreading {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi Threading Lab");
        frame.setLayout(null);
        frame.setBounds(50, 50, 700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Time
        JLabel timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setBounds(200, 50, 200, 30);
        frame.add(timeLabel);

        // Moving text
        JLabel movingTextLabel = new JLabel("Ahmed Abdelsamea");
        movingTextLabel.setBounds(0, 150, 150, 30);
        frame.add(movingTextLabel);

        // Image
        JLabel imageLabel = new JLabel();
        ImageIcon image = new ImageIcon("ball.png");
        imageLabel.setIcon(image);
        imageLabel.setBounds(200, 200, 50, 50);
        frame.add(imageLabel);

        // Threads susing run Method
        Thread timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date d = new Date();
                    timeLabel.setText(d.toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timeThread.start();

        Thread movingTextThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 0;
                int xDir = 1;
                while (true) {
                    movingTextLabel.setBounds(x, 150, 150, 30);
                    x += xDir;
                    if (x <= 0 | x >= frame.getWidth() - movingTextLabel.getWidth()) {
                        xDir *= -1;
                    }

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        movingTextThread.start();

        Thread imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 250;
                int y = 0;
                int xDir = 10;
                int yDir = 10;
                while (true) {
                    imageLabel.setBounds(x, y, 50, 50);
                    x += xDir;
                    y += yDir;
                    if (x <= 0 | x >= frame.getWidth() - imageLabel.getWidth()) {
                        xDir *= -1;
                    }
                    if (y <= 0 | y >= frame.getHeight() - imageLabel.getHeight()) {
                        yDir *= -1;
                    }

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        imageThread.start();
    }
}
