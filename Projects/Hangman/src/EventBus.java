import java.util.HashMap;

public class EventBus
{
    private static final HashMap<String, EventModel> _events =
                            new HashMap<String, EventModel>();

    private EventBus() {  }

    public static boolean has(String eventName)
    {
        return(_events.containsKey(eventName));
    }

    public static void on(String eventName, ICallBack callback)
    {
        if(has(eventName))
        {
            _events.get(eventName).addObserver(callback);
            return;
        }
        _events.put(eventName, new EventModel(eventName));
        on(eventName, callback);
    }

    public static void trigger(String eventName)
    {
        if(!has(eventName))
            return;

        for (ICallBack callback : _events.get(eventName).getObservers()) {
            callback.Present();
        }
    }

}
