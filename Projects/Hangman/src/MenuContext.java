public class MenuContext extends Context
{
    private static final InputManager    getuserinput    = new InputManager();
    private static final PrintMenu       printmenu       = new PrintMenu();
    private static final HandleUserInput handleuserinput = new HandleUserInput();

    @Override
    public void Setup()
    {
        getBindings().put
        ( EventTriggerCase.PRESENT_CONTEXT,   printmenu );
        getBindings().put
        ( EventTriggerCase.GET_USER_INPUT,    getuserinput );
        getBindings().put
        ( EventTriggerCase.HANDLE_USER_INPUT, handleuserinput );
    }

    static class PrintMenu implements ICallBack
    {
        @Override
        public void Respond()
        {
            System.out.println("Main Menu:");
            System.out.println("- New Game   (N)");
            System.out.println("- Statistics (S)");
            System.out.println("- Exit       (E)");

            EventBus.trigger(EventTriggerCase.GET_USER_INPUT);
        }
    }

    static class HandleUserInput implements ICallBack
    {
        @Override
        public void Respond()
        {
            switch (InputManager.getLastUserInput().toUpperCase())
            {
                case("N"):
                {
                    EventBus.on(EventTriggerCase.CONTEXT_SWITCH, Hangman.game);
                    EventBus.trigger(EventTriggerCase.CONTEXT_SWITCH);
                    return;
                }
                case("S"):
                {
                    EventBus.on(EventTriggerCase.CONTEXT_SWITCH, Hangman.stats);
                    EventBus.trigger(EventTriggerCase.CONTEXT_SWITCH);
                    return;
                }
                case("E"):
                {
                    System.exit(0);
                    return;
                }
                default:
                {
                    EventBus.trigger(EventTriggerCase.PRESENT_CONTEXT);
                    return;
                }
            }
        }
    }
}
