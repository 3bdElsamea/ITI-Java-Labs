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

        // Thread for time
        Thread timeThread = new Thread(() -> {
            while (true) {
                Date d = new Date();
                timeLabel.setText(d.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timeThread.start();

        // Thread for moving text
        Thread textThread = new Thread(() -> {
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
        });
        textThread.start();

        // Thread for moving image
        Thread imageThread = new Thread(() -> {
            int ballX = 100;
            int ballY = 0;
            int ballXDir = 5;
            int ballYDir = 5;
            while (true) {
                imageLabel.setBounds(ballX, ballY, 50, 50);
                ballX += ballXDir;
                ballY += ballYDir;
                if (ballX <= 0 | ballX >= frame.getWidth() - imageLabel.getWidth()) {
                    ballXDir *= -1;
                } else if (ballY <= 0 | ballY >= frame.getHeight() - imageLabel.getHeight()) {
                    ballYDir *= -1;
                }
                // if (ballX == 500) {
                //     ballXDir = -5;
                // } else if (ballX == 0) {
                //     ballXDir = 5;
                // }
                // if (ballY == 500) {
                //     ballYDir = -5;
                // } else if (ballY == 0) {
                //     ballYDir = 5;
                // }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
