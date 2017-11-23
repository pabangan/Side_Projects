//Bouncer.java

public class Bouncer implements Runnable
{
    private final BouncingBall ball;

    public Bouncer( )
    {
        this.ball = new BouncingBall( );
    }

    public BouncingBall getBall( )
    {
        return this.ball;
    }

    /*
    * (non-Javadoc)
    * @see java.lang.Runnable#run()
    */
    @Override
    public void run( )
    {
        this.ball.step( );
    }

}