import java.awt.*;
import java.util.Random;

public class Target {
    private int x, y, diameter;
    private int dx, dy;

    public Target() {
        Random rand = new Random();
        diameter = 50;
        x = rand.nextInt(800 - diameter);
        y = rand.nextInt(600 - diameter);
        dx = rand.nextInt(7) - 3; // Random speed between -3 and 3
        dy = rand.nextInt(7) - 3;
    }

    public void update() {
        x += dx;
        y += dy;

        if (x < 0 || x > 800 - diameter) {
            dx = -dx;
        }
        if (y < 0 || y > 600 - diameter) {
            dy = -dy;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }

    public boolean contains(Point p) {
        return new Rectangle(x, y, diameter, diameter).contains(p);
    }
}
