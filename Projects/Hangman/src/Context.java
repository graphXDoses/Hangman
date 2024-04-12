import java.util.Map;
import java.util.HashMap;

public abstract class Context implements ICallBack
{
    private final HashMap<String, ICallBack> bindings =
                        new HashMap<String, ICallBack>();

    public HashMap<String, ICallBack> getBindings() { return(bindings); }

    public Context() { Setup(); }
    public abstract void Setup();

    private void Activate()
    {
        EventBus.off(EventTriggerCase.CONTEXT_SWITCH, this);
        for (Map.Entry<String, ICallBack> entry : bindings.entrySet())
        {
            String     eventName = entry.getKey();
            ICallBack  callback  = entry.getValue();
            EventBus.on(eventName, callback);
        }
        EventBus.on
        (
            EventTriggerCase.CONTEXT_SWITCH,
            new ICallBack()
            {
                private ICallBack self = this;
                @Override
                public void Present()
                {
                    System.out.println("Yolos");
                    Deactivate();
                    EventBus.off(EventTriggerCase.CONTEXT_SWITCH, self);
                }
            }
        );
    }

    private void Deactivate()
    {
        for (Map.Entry<String, ICallBack> entry : bindings.entrySet())
        {
            String     eventName = entry.getKey();
            ICallBack  callback  = entry.getValue();
            EventBus.off(eventName, callback);
        }
    }

    @Override
    public void Present()
    {
        Activate();
        EventBus.trigger(EventTriggerCase.PRESENT_CONTEXT);
    }
}
