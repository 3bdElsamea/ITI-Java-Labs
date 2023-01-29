import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;

class MovingText extends JFrame implements Runnable {
    JLabel movingTextLabel = new JLabel("Ahmed Abdelsamea");
    Thread movingTextThread;
    int x = 0;
    int y = 150;
    int xDir = 1;

    MovingText() {
        movingTextLabel.setBounds(x, y, 100, 30);
        this.setTitle("Moving Text");
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(movingTextLabel);
        movingTextThread = new Thread(this);
        movingTextThread.start();
    }

    @Override
    public void run() {
        while (true) {
            x += xDir;
            movingTextLabel.setBounds(x, y, 100, 30);
            if ( x > this.getWidth()) {
                x = 0;
            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main
    public static void main(String[] args) {
        MovingText movingText = new MovingText();
    }
}