package mod.piddagoras.triggers;

public class Trigger {


	public static boolean Register(Trigger trig){
		return trig.event.register(trig);
	}
	public static boolean Remove(Trigger trig) throws Exception{
		return trig.event.remove(trig);
	}
	
	final String name;
	final Event event;
	final Circumstances circumstances;
	final Consequences consequences;
	
	public Trigger(String name, Event event, Circumstances circumstances, Consequences consequences) {
		this.name = name;
		this.event = event;
		this.circumstances = circumstances;
		this.consequences = consequences;
	}
	public boolean trigger(Occurance occ){
		if(!circumstances.check(occ)) return false;
		consequences.call(occ);
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((circumstances == null) ? 0 : circumstances.hashCode());
		result = prime * result + ((consequences == null) ? 0 : consequences.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Trigger other = (Trigger) obj;
		if (circumstances == null) {
			if (other.circumstances != null)
				return false;
		} else if (!circumstances.equals(other.circumstances))
			return false;
		if (consequences == null) {
			if (other.consequences != null)
				return false;
		} else if (!consequences.equals(other.consequences))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
