package mod.sin.lib;

import java.util.HashMap;
import java.util.logging.Logger;

public class ArmourAssist {
    public static Logger logger = Logger.getLogger(ArmourAssist.class.getName());

    public static HashMap<String, Integer> armourNameToType = new HashMap<>();
    public static HashMap<Integer, String> armourTypeToName = new HashMap<>();

    public static int getArmourType(String str){
        if(armourNameToType.containsKey(str.toLowerCase())){
            return armourNameToType.get(str.toLowerCase());
        }
        return Integer.parseInt(str);
    }

    public static String getArmourName(int armourType){
        if(armourTypeToName.containsKey(armourType)){
            return armourTypeToName.get(armourType);
        }
        logger.warning(String.format("Armour type %s is unknown to the ArmourAssist system.", armourType));
        return "unknown";
    }

    public static void initializeArmourMaps(){
        logger.info("Initializing Armour Maps.");
        armourNameToType.put("cloth", 6);
        armourNameToType.put("leather", 1);
        armourNameToType.put("studded", 2);
        armourNameToType.put("chain", 3);
        armourNameToType.put("plate", 4);
        armourNameToType.put("drake", 9);
        armourNameToType.put("dragonscale", 10);
        armourNameToType.put("scale", 7);
        armourNameToType.put("ring", 5);
        armourNameToType.put("splint", 8);
        for(String name : armourNameToType.keySet()){
            armourTypeToName.put(armourNameToType.get(name), name);
        }
    }
}
