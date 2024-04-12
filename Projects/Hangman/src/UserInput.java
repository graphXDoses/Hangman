public class UserInput implements ICallBack
{
    @Override
    public void Present()
    {
        InputManager.read();
    }
}
