package mod.piddagoras.triggers;

import java.util.*;
import java.util.logging.Logger;

public class Event {
    public static Logger logger = Logger.getLogger(Event.class.getName());

	private static Deque<Occurance> eventDeque= new LinkedList<>();
	static boolean eventsTriggering=false;

    public static Event DamageTaken = new Event("Damage Taken");
	
	public static void TriggerEvents() throws Exception{
		if(eventsTriggering) throw new Exception("Events are already triggering"); //Protects from triggers calling this method, would have to be stupid to do so though.
		eventsTriggering=true;
		Occurance occ=eventDeque.pollFirst();
		while (occ!=null){
			occ.getEvent().trigger(occ);
			occ=eventDeque.pollFirst();
		} 
		eventsTriggering=false;
	}

	
	public Set<Trigger> eventTriggers;
	public final String eventName;
	
	public Event(String name){
		eventName=name;
		eventTriggers= new HashSet<>();
	}
	
	public boolean register(Trigger trig){
		return eventTriggers.add(trig);
	}
	public boolean remove(Trigger trig){
		return eventTriggers.remove(trig);
	}
	
	public void occur(Map<String, Object> data){
		eventDeque.addLast(new Occurance(this, data));
        if(!eventsTriggering){
            try {
                TriggerEvents();
            } catch (Exception e) {
                logger.info("AHHH WE BROKE IT."); // AHHH
                e.printStackTrace();
            }
        }
	}
	
	public void trigger(Occurance occ) {
		for(Trigger trig: eventTriggers){
			trig.trigger(occ);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		return true;
	}
	

}
