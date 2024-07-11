//Preston Willis
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class AimTrainer extends JPanel implements ActionListener {
    private Timer timer;
    private int score;
    private int timeLeft; // Instance variable
    private Target target;
    private main mainFrame;

    public AimTrainer(main mainFrame) {
        this.mainFrame = mainFrame;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);

        startGame();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (target.contains(e.getPoint())) {
                    score++;
                    target = new Target();
                    repaint();
                }
            }
        });

        timer = new Timer(1000 / 60, this); // 60 FPS
        timer.start();

        new Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
                if (timeLeft == 0) {
                    timer.stop();
                    mainFrame.showGameOverPanel(); // Show the game over panel when time is up
                }
            }
        }).start();
    }

    public void startGame() {
        score = 0;
        timeLeft = 60; // Reset timeLeft to 60 seconds
        timer = new Timer(1000 / 60, this);
        target = new Target();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        target.update();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        target.draw(g);

        g.setColor(Color.WHITE);
        int scoreX = getWidth() - 100;
        int scoreY = 20;
        int timerX = getWidth() - 100;
        int timerY = 40;

        g.drawString("Score: " + score, scoreX, scoreY);
        g.drawString("Time Left: " + timeLeft, timerX, timerY);
    }

    public int getScore() {
        return score;
    }
}

