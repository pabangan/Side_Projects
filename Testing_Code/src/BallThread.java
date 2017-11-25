import javax.swing.*;

public class BallThread implements Runnable
{
    @Override
    public void run( )
    {
        try
        {
            //new BallPane();
        }
        catch (Exception e)
        {
            System.out.println("There was an exception in Main Runnable.");
        }
    }
}
