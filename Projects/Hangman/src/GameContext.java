public class GameContext extends Context
{
    @Override
    public void Setup()
    {
        System.out.println("\'Setup\' from GameContext");
    }

    @Override
    public void Present()
    {
        System.out.println("\'Present\' from GameContext");
    }
}
