package mod.piddagoras.triggers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Demonstration {
	public static Logger logger = Logger.getLogger(Demonstration.class.getName());
	public static Event PrintMessageEvent=new Event("Print Message");
	public static Event testEvent=new Event("Test Event");
	public static void main(String[] args){
		Trigger.Register(new Trigger("Print Message", testEvent, 
			new Circumstances(){
			@Override
			public boolean check(Map<String, Object> data) {
				return (boolean) data.get("doPrint");
			}}, 
			new Consequences(){
			@Override
			public void call(Map<String, Object> data) {
				String message=(String) data.get("message");
				PrintMessage(message);
			}}));
		
		Trigger.Register(new Trigger("Repeat Hello World", PrintMessageEvent, 
			new Circumstances(){
				final String checkString="Hello World";
				@Override
				public boolean check(Map<String, Object> data) {
					String str = (String) data.get("message");
					return str.contains(checkString);
				}
			}, 
			new Consequences(){
				int n=8;
				@Override
				public void call(Map<String, Object> data) {
					if(n<10){
						PrintMessage("Hello World");
						n++;
					} else{
						n=6;
					}
				}
		}));
		Trigger.Register(new Trigger("Check for Goodbye", PrintMessageEvent, 
				new Circumstances(){
					String checkString="goodbye";
					@Override
					public boolean check(Map<String, Object> data) {
						String message=(String) data.get("message");
						return message.toLowerCase().contains(checkString);
					}
				}, 
				new Consequences(){
					boolean me=false;
					@Override
					public void call(Map<String, Object> data) {
						if(!me) {
							me=true;
							PrintMessage("A string contained \"goodbye\" Hello World.");
						} else{
							me=false;
						}
						
					}
			}));
		
		TestEvent(true, "Not Hello World");
		TestEvent(false, "Hello World");
		TestEvent(false, "Nope World");
		TestEvent(true, "Yep World");
		TestEvent(false, "Sorry World");
		TestEvent(true, "Goodbye World");
		TestEvent(true, "Goodbye World");

		
		/*try {
			Event.TriggerEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Event.TriggerEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	public static void TestEvent(boolean doPrint, String message){
		Map<String, Object> data= new HashMap<>();
		data.put("doPrint", doPrint);
		data.put("message", message);
		testEvent.occur(data);
	}
	
	public static void PrintMessage(String message){
		System.out.println(message);
		Map<String, Object> data= new HashMap<>();
		data.put("message", message);
		PrintMessageEvent.occur(data);
	}
}
