public class PrintMenu implements ICallBack
{
    @Override
    public void Present()
    {
        System.out.println("Main Menu:");
        System.out.println("- New Game   (N)");
        System.out.println("- Statistics (S)");
        System.out.println("- Exit       (E)");

        EventBus.trigger("GET USER INPUT");
    }
}
