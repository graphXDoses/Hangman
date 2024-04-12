import java.util.ArrayList;

public class EventModel
{
    private String _name;
    private ArrayList<ICallBack> _observers;

    public EventModel(String name)
    {
        _name = name;
        _observers = new ArrayList<ICallBack>();
    }

    public boolean hasObserver(ICallBack observer)
    {
        return(_observers.indexOf(observer) != -1 ? true : false);
    }

    public void addObserver(ICallBack observer)
    {
        if(hasObserver(observer))
            return;
        _observers.add(observer);
    }

    public String               getName()      { return(_name); }
    public ArrayList<ICallBack> getObservers() { return(_observers); }
}
