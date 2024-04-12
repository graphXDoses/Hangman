public class Hangman
{
    private static Hangman instance = null;

    private Hangman()
    {
        System.out.println("Hangman Created!");
    }

    public static Hangman Init()
    {
        if(instance == null)
            instance = new Hangman();
        return(instance);
    }
}
