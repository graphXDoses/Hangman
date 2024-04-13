public class Hangman
{
    private static Hangman instance = null;
    public  static final Context menu  = new MenuContext();
    public  static final Context game  = new GameContext();
    public  static final Context stats = new StatisticsContext();

    private Hangman()
    {
        EventBus.on(EventTriggerCase.CONTEXT_SWITCH, menu);
        EventBus.trigger(EventTriggerCase.CONTEXT_SWITCH);
    }

    public static Hangman Init()
    {
        if(instance == null)
            instance = new Hangman();
        return(instance);
    }
}
