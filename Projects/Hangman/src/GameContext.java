public class GameContext extends Context
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
        public void Present()
        {
            System.out.println("Game Starts!");
            System.out.println("Give me some input..");

            EventBus.trigger(EventTriggerCase.GET_USER_INPUT);
        }
    }

    static class HandleUserInput implements ICallBack
    {
        @Override
        public void Present()
        {
            System.out.println("User said -> \'" + InputManager.getLastUserInput().toUpperCase() + "\'");
        }
    }
}
