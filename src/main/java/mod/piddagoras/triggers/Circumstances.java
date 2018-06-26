package mod.piddagoras.triggers;

import java.util.Map;

public abstract class Circumstances {
	public abstract boolean check(Map<String, Object> data);
	
	public static Circumstances ANY=new Circumstances(){
		@Override
		public boolean check(Map<String, Object> data) {
			return true;
		}
	};
	public static Circumstances NONE=new Circumstances(){
		@Override
		public boolean check(Map<String, Object> data) {
			return false;
		}
	};
}