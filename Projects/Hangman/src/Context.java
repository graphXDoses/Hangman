import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class Context implements ICallBack
{
    private final HashMap<String, ICallBack> bindings =
                        new HashMap<String, ICallBack>();

    public HashMap<String, ICallBack> getBindings() { return(bindings); }
    private static final ArrayList<Context> _context_pool = new ArrayList<Context>();

    public Context() { _context_pool.add(this); Setup(); }
    public abstract void Setup();

    private void Activate()
    {
        EventBus.off(EventTriggerCase.CONTEXT_SWITCH, this);
        for (Context c : _context_pool)
            c.Deactivate();
        for (Map.Entry<String, ICallBack> entry : bindings.entrySet())
        {
            String     eventName = entry.getKey();
            ICallBack  callback  = entry.getValue();
            EventBus.on(eventName, callback);
        }
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
    public void Respond()
    {
        Activate();
        EventBus.trigger(EventTriggerCase.PRESENT_CONTEXT);
    }
}
