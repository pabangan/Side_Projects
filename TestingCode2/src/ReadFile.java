import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class ReadFile
{
    private int line=0;
    private Scanner x;

    public void openFile()
    {
        try
        {
         x = new Scanner(new File("chinese.txt"));
         //modify = new Formatter("chinese.txt");
        }
        catch (Exception e)
        {
            System.out.println("Not able to connect to the text file. ");
        }
    }

    public void readFile()
    {
        while(x.hasNext())
        {
            String num = x.next();
            String word = x.next();
            System.out.printf("%s %s\n\n", num, word);
            line++;
        }
    }


    public void closeFile()
    {
        x.close();
    }

}
