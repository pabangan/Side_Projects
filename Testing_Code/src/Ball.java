import java.awt.*;
import javax.swing.JPanel;


public class Ball extends JPanel {
    private final int m_diameter;
    private final int m_speed;
    private int m_x;
    private int horizSpeed;
    private int m_y;
    private int vertSpeed;
    private Color m_color = new Color((int)(Math.random() * 0x1000000));

    public Ball() {
        m_diameter = 50;
        m_speed = 3;
        m_x = 0;
        horizSpeed = 3;
        m_y = 3;
        vertSpeed = 3;
    }

    public boolean bottomSide() {
        if ((this.m_y + this.m_diameter) >= this.getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean leftSide() {
        if (this.m_x <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean rightSide() {
        if ((this.m_x + this.m_diameter) >= this.getWidth()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean topSide() {
        if (this.m_y <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(m_color);
        g.fillOval(this.m_x, this.m_y, this.m_diameter, this.m_diameter);
    }

    public synchronized void moveBall() {
        if (this.leftSide()) {
            this.horizSpeed = this.m_speed;
        } else if (this.rightSide()) {
            this.horizSpeed = -this.m_speed;
        }

        this.m_x += this.horizSpeed;

        if (this.topSide()) {
            this.vertSpeed = this.m_speed;
        } else if (this.bottomSide()) {
            this.vertSpeed = -this.m_speed;
        }

        this.m_y += this.vertSpeed;
        this.repaint();
    }
}