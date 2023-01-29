import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;

class DateTime extends JFrame implements Runnable {
    JLabel timeLabel;
    Thread dateThread;
    Date date;

    DateTime() {
        timeLabel = new JLabel();
        timeLabel.setBounds(200, 50, 200, 30);
        this.add(timeLabel);
        dateThread = new Thread(this);
        dateThread.start();
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

    // Main
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        dateTime.setTitle("Date Time");
        dateTime.setSize(500, 500);
        dateTime.setLayout(null);
        dateTime.setVisible(true);
        //Exit on close
        dateTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}