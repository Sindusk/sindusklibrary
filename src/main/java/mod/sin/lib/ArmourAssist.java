package mod.sin.lib;

import com.wurmonline.server.combat.ArmourTypes;

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
        armourNameToType.put("cloth", ArmourTypes.ARMOUR_CLOTH);
        armourNameToType.put("leather", ArmourTypes.ARMOUR_LEATHER);
        armourNameToType.put("studded", ArmourTypes.ARMOUR_STUDDED);
        armourNameToType.put("chain", ArmourTypes.ARMOUR_CHAIN);
        armourNameToType.put("plate", ArmourTypes.ARMOUR_PLATE);
        armourNameToType.put("drake", ArmourTypes.ARMOUR_LEATHER_DRAGON);
        armourNameToType.put("dragonscale", ArmourTypes.ARMOUR_SCALE_DRAGON);
        armourNameToType.put("scale", ArmourTypes.ARMOUR_SCALE);
        armourNameToType.put("ring", ArmourTypes.ARMOUR_RING);
        armourNameToType.put("splint", ArmourTypes.ARMOUR_SPLINT);
        for(String name : armourNameToType.keySet()){
            armourTypeToName.put(armourNameToType.get(name), name);
        }
    }
}
