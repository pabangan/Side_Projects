import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.Timer;

public class BallPane
{
    private static BouncingBall m_bounce;
    private ArrayList<BouncingBall> ballList = new ArrayList<BouncingBall>();
    private static int m_sleep = 10;
    private static ExecutorService executor;
    private int numBalls;
    private static int m_height = 400;
    private static Timer timer;
    private static int m_width = 600;

    public BallPane()
    {
        numBalls = 0;
        JFrame frame = new JFrame( "Bouncing Ball" );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(m_width,m_height);
        frame.setVisible(true);

        frame.addMouseListener( new MouseAdapter( )
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    System.out.println("creating new bouncing ball");
                    m_bounce = new BouncingBall();
                    ballList.add(m_bounce);
                    frame.add(m_bounce.getBall());
                    frame.setVisible(true);
                    BallThread t = new BallThread();
                    Thread test = new Thread(t);
                    test.start();
                    System.out.println("clicked");
                    numBalls++;
                    BallPane.timer.start();
                }
                catch (Exception i)
                {
                    i.printStackTrace();
                    System.out.println("There was an exception at the MouseEvent.");
                }
            }
        } );
    }
}