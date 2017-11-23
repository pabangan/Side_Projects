//Ball.java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Ball
{

    private static Bouncer bouncer;
    private static int delay = 10;
    private static ExecutorService executor;
    private static int height = 400;
    private static Timer timer;
    private static int width = 600;

    /**
     * @param args
     */
    public static void main( String[ ] args )
    {
        JFrame frame = new JFrame( "Bouncing Ball" );
        Ball.bouncer = new Bouncer( );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( Ball.bouncer.getBall( ) );
        frame.setSize( Ball.width, Ball.height );

        frame.setVisible( true );
        frame.addMouseListener( new MouseAdapter( )
        {
            @Override
            public void mouseClicked( MouseEvent e )
            {
                System.out.println( "click" );
                Ball.timer.start( );
            }
        } );

        Ball.executor = Executors.newCachedThreadPool( );
        Ball.timer = new Timer( Ball.delay, new ActionListener( )
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                Ball.executor.execute( Ball.bouncer );
            }

        } );

    }

}