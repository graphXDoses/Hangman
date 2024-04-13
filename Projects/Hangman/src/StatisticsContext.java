public class StatisticsContext extends Context
{
    private static final PrintMenu       printmenu       = new PrintMenu();

    @Override
    public void Setup()
    {
        getBindings().put
        ( EventTriggerCase.PRESENT_CONTEXT,   printmenu );
    }

    static class PrintMenu implements ICallBack
    {
        @Override
        public void Respond()
        {
            System.out.println("Showing game statistics here..");
            EventBus.on(EventTriggerCase.CONTEXT_SWITCH, Hangman.menu);
            EventBus.trigger(EventTriggerCase.CONTEXT_SWITCH);
        }
    }
}
