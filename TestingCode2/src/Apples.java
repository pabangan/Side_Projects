public class Apples
{
    public static void main(String[] args)
    {
        ReadFile r = new ReadFile();
        r.openFile();
        r.readFile();


        /*
        System.out.println("Now I'm going to see if the add file will work.\n");
        r.modifyFile();
        r.readFile();
        */



        r.closeFile();
    }
}
