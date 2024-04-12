public class Hangman
{
    private static Hangman instance = null;

    private Hangman()
    {
        System.out.println("Hangman Created!");
        EventBus.on("CONTEXT SWITCH", new PrintMenu());
        EventBus.on("GET USER INPUT", new UserInput());

        EventBus.trigger("CONTEXT SWITCH");
    }

    public static Hangman Init()
    {
        if(instance == null)
            instance = new Hangman();
        return(instance);
    }
}
