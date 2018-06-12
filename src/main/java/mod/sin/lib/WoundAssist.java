package mod.sin.lib;

import java.util.HashMap;
import java.util.logging.Logger;

public class WoundAssist {
    public static Logger logger = Logger.getLogger(WoundAssist.class.getName());

    public static HashMap<String, Byte> woundNameToType = new HashMap<>();
    public static HashMap<Byte, String> woundTypeToName = new HashMap<>();

    public static byte getWoundType(String str){
        if(woundNameToType.containsKey(str.toLowerCase())){
            return woundNameToType.get(str.toLowerCase());
        }
        return Byte.parseByte(str);
    }

    public static String getWoundName(int woundType){
        return getWoundName((byte) woundType);
    }
    public static String getWoundName(byte woundType){
        if(woundTypeToName.containsKey(woundType)){
            return woundTypeToName.get(woundType);
        }
        logger.warning(String.format("Wound type %s is unknown to the WoundAssist system.", woundType));
        return "unknown";
    }

    public static void initializeWoundMaps(){
        logger.info("Initializing Wound Maps.");
        woundNameToType.put("crush", (byte) 0);
        woundNameToType.put("slash", (byte) 1);
        woundNameToType.put("pierce", (byte) 2);
        woundNameToType.put("bite", (byte) 3);
        woundNameToType.put("burn", (byte) 4);
        woundNameToType.put("poison", (byte) 5);
        woundNameToType.put("infection", (byte) 6);
        woundNameToType.put("water", (byte) 7);
        woundNameToType.put("cold", (byte) 8);
        woundNameToType.put("internal", (byte) 9);
        woundNameToType.put("acid", (byte) 10);
        for(String name : woundNameToType.keySet()){
            woundTypeToName.put(woundNameToType.get(name), name);
        }
    }
}