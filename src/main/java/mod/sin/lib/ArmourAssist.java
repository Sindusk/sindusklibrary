package mod.sin.lib;

import com.wurmonline.server.combat.ArmourTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class ArmourAssist {
    public static Logger logger = Logger.getLogger(ArmourAssist.class.getName());

    public static ArrayList<ArmourTemplate.ArmourType> armourTypes = new ArrayList<>();
    public static HashMap<String, Integer> armourNameToByte = new HashMap<>();
    public static HashMap<Integer, String> armourByteToName = new HashMap<>();

    public static ArmourTemplate.ArmourType getArmourType(String name){
        for (ArmourTemplate.ArmourType type : armourTypes){
            if (type.getName().equals(name)){
                return type;
            }
        }
        return null;
    }

    public static ArmourTemplate.ArmourType getArmourType(int armourType){
        String name = getArmourName(armourType); // Identify the name of the armour first
        return getArmourType(name);
    }

    public static int getArmourByte(String str){
        if(armourNameToByte.containsKey(str.toLowerCase())){
            return armourNameToByte.get(str.toLowerCase());
        }
        return Integer.parseInt(str);
    }

    public static String getArmourName(int armourType){
        if(armourByteToName.containsKey(armourType)){
            return armourByteToName.get(armourType);
        }
        logger.warning(String.format("Armour type %d is unknown to the ArmourAssist system.", armourType));
        return "unknown";
    }

    public static void initializeArmourMaps(){
        logger.info("Initializing Armour Maps.");

        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_NONE.getName(), 0);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_CLOTH.getName(), 6);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_LEATHER.getName(), 1);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_STUDDED.getName(), 2);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_CHAIN.getName(), 3);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_PLATE.getName(), 4);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_LEATHER_DRAGON.getName(), 9);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_SCALE_DRAGON.getName(), 10);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_SCALE.getName(), 7);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_RING.getName(), 5);
        armourNameToByte.put(ArmourTemplate.ARMOUR_TYPE_SPLINT.getName(), 8);

        for(String name : armourNameToByte.keySet()){
            armourByteToName.put(armourNameToByte.get(name), name);
        }

        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_NONE);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_CLOTH);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_LEATHER);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_STUDDED);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_CHAIN);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_PLATE);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_LEATHER_DRAGON);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_SCALE_DRAGON);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_SCALE); // Fake scale
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_RING);
        armourTypes.add(ArmourTemplate.ARMOUR_TYPE_SPLINT);
    }
}
