public abstract class Context implements ICallBack
{
    public Context()
    {
        Setup();
    }

    public abstract void Setup();

    @Override
    public void Present()
    {
        EventBus.trigger(EventTriggerCase.PRESENT_CONTEXT);
    }
}
