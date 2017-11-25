public class BouncingBall implements Runnable
{
    private final Ball ball;

    public BouncingBall( )
    {
        this.ball = new Ball();
    }

    public Ball getBall( )
    {
        this.run();
        return this.ball;
    }

    @Override
    public void run( )
    {
        try
        {
            ball.moveBall();
        }
        catch (Exception e)
        {
            System.out.println("There was an exception in Bouncing Ball runnable.");
        }
    }

}