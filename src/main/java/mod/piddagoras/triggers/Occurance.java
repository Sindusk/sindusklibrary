package mod.piddagoras.triggers;

import java.util.HashMap;
import java.util.Map;

public class Occurance extends HashMap<String, Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7067035822827199587L;
	public Event event;
	
	public Occurance(Event event, Map<String, Object> data){
		super();
		this.event=event;
		this.putAll(data);
	}
	
	public Occurance(Event event){
		super();
		this.event=event;
	}
	
	public Event getEvent(){
		return event;
	}
	@Override
	public Object put(String key, Object value){
		return super.putIfAbsent(key, value);
	}
}
