package mod.sin.lib;

import java.util.HashMap;
import java.util.logging.Logger;

public class SkillAssist {
    public static Logger logger = Logger.getLogger(SkillAssist.class.getName());

    public static HashMap<String, Integer> skillNameToId = new HashMap<>();
    public static HashMap<Integer, String> skillIdToName = new HashMap<>();

    public static int getSkill(String name){
        if (skillNameToId.containsKey(name)){
            return skillNameToId.get(name);
        }
        return -1;
    }
    public static String getSkill(int id){
        if (skillIdToName.containsKey(id)){
            return skillIdToName.get(id);
        }
        return "N/A";
    }

    public static void initializeSkillMaps(){
        logger.info("Initializing Skill Maps.");

        skillNameToId.put("body", 1);
        skillNameToId.put("mind", 2);
        skillNameToId.put("soul", 3);
        skillNameToId.put("mind logic", 100);
        skillNameToId.put("mind speed", 101);
        skillNameToId.put("body strength", 102);
        skillNameToId.put("body stamina", 103);
        skillNameToId.put("body control", 104);
        skillNameToId.put("soul strength", 105);
        skillNameToId.put("soul septh", 106);
        skillNameToId.put("swords", 1000);
        skillNameToId.put("knives", 1001);
        skillNameToId.put("shields", 1002);
        skillNameToId.put("axes", 1003);
        skillNameToId.put("mauls", 1004);
        skillNameToId.put("carpentry", 1005);
        skillNameToId.put("woodcutting", 1007);
        skillNameToId.put("mining", 1008);
        skillNameToId.put("digging", 1009);
        skillNameToId.put("firemaking", 1010);
        skillNameToId.put("pottery", 1011);
        skillNameToId.put("tailoring", 1012);
        skillNameToId.put("masonry", 1013);
        skillNameToId.put("ropemaking", 1014);
        skillNameToId.put("smithing", 1015);
        skillNameToId.put("weapon smithing", 1016);
        skillNameToId.put("armour smithing", 1017);
        skillNameToId.put("cooking", 1018);
        skillNameToId.put("nature", 1019);
        skillNameToId.put("miscellaneous items", 1020);
        skillNameToId.put("alchemy", 1021);
        skillNameToId.put("toys", 1022);
        skillNameToId.put("fighting", 1023);
        skillNameToId.put("healing", 1024);
        skillNameToId.put("clubs", 1025);
        skillNameToId.put("religion", 1026);
        skillNameToId.put("hammers", 1027);
        skillNameToId.put("thievery", 1028);
        skillNameToId.put("war machines", 1029);
        skillNameToId.put("archery", 1030);
        skillNameToId.put("bowyery", 1031);
        skillNameToId.put("fletching", 1032);
        skillNameToId.put("polearms", 1033);
        skillNameToId.put("small axe", 10001);
        skillNameToId.put("shovel", 10002);
        skillNameToId.put("hatchet", 10003);
        skillNameToId.put("rake", 10004);
        skillNameToId.put("longsword", 10005);
        skillNameToId.put("medium metal shield", 10006);
        skillNameToId.put("carving knife", 10007);
        skillNameToId.put("saw", 10008);
        skillNameToId.put("pickaxe", 10009);
        skillNameToId.put("blades smithing", 10010);
        skillNameToId.put("weapon heads smithing", 10011);
        skillNameToId.put("chain armour smithing", 10012);
        skillNameToId.put("plate armour smithing", 10013);
        skillNameToId.put("shield smithing", 10014);
        skillNameToId.put("blacksmithing", 10015);
        skillNameToId.put("cloth tailoring", 10016);
        skillNameToId.put("leatherworking", 10017);
        skillNameToId.put("tracking", 10018);
        skillNameToId.put("small wooden shield", 10019);
        skillNameToId.put("medium wooden shield", 10020);
        skillNameToId.put("large wooden shield", 10021);
        skillNameToId.put("small metal shield", 10022);
        skillNameToId.put("large metal shield", 10023);
        skillNameToId.put("large axe", 10024);
        skillNameToId.put("huge axe", 10025);
        skillNameToId.put("hammer", 10026);
        skillNameToId.put("short sword", 10027);
        skillNameToId.put("two handed sword", 10028);
        skillNameToId.put("butchering knife", 10029);
        skillNameToId.put("stone chisel", 10030);
        skillNameToId.put("paving", 10031);
        skillNameToId.put("prospecting", 10032);
        skillNameToId.put("fishing", 10033);
        skillNameToId.put("locksmithing", 10034);
        skillNameToId.put("repairing", 10035);
        skillNameToId.put("coal-making", 10036);
        skillNameToId.put("dairy food making", 10037);
        skillNameToId.put("hot food cooking", 10038);
        skillNameToId.put("baking", 10039);
        skillNameToId.put("milling", 10040);
        skillNameToId.put("metallurgy", 10041);
        skillNameToId.put("natural substances", 10042);
        skillNameToId.put("jewelry smithing", 10043);
        skillNameToId.put("fine carpentry", 10044);
        skillNameToId.put("gardening", 10045);
        skillNameToId.put("sickle", 10046);
        skillNameToId.put("scythe", 10047);
        skillNameToId.put("forestry", 10048);
        skillNameToId.put("farming", 10049);
        skillNameToId.put("yoyo", 10050);
        skillNameToId.put("toymaking", 10051);
        skillNameToId.put("weaponless fighting", 10052);
        skillNameToId.put("aggressive fighting", 10053);
        skillNameToId.put("defensive fighting", 10054);
        skillNameToId.put("normal fighting", 10055);
        skillNameToId.put("first aid", 10056);
        skillNameToId.put("taunting", 10057);
        skillNameToId.put("shield bashing", 10058);
        skillNameToId.put("butchering", 10059);
        skillNameToId.put("milking", 10060);
        skillNameToId.put("large maul", 10061);
        skillNameToId.put("medium maul", 10062);
        skillNameToId.put("small maul", 10063);
        skillNameToId.put("huge club", 10064);
        skillNameToId.put("preaching", 10065);
        skillNameToId.put("prayer", 10066);
        skillNameToId.put("channeling", 10067);
        skillNameToId.put("exorcism", 10068);
        skillNameToId.put("archaeology", 10069);
        skillNameToId.put("warhammer", 10070);
        skillNameToId.put("foraging", 10071);
        skillNameToId.put("botanizing", 10072);
        skillNameToId.put("climbing", 10073);
        skillNameToId.put("stone cutting", 10074);
        skillNameToId.put("stealing", 10075);
        skillNameToId.put("lockpicking", 10076);
        skillNameToId.put("catapult", 10077);
        skillNameToId.put("animal taming", 10078);
        skillNameToId.put("short bow", 10079);
        skillNameToId.put("medium bow", 10080);
        skillNameToId.put("long bow", 10081);
        skillNameToId.put("shipbuilding", 10082);
        skillNameToId.put("beverages", 10083);
        skillNameToId.put("traps", 10084);
        skillNameToId.put("animal husbandry", 10085);
        skillNameToId.put("meditating", 10086);
        skillNameToId.put("puppeteering", 10087);
        skillNameToId.put("long spear", 10088);
        skillNameToId.put("halberd", 10089);
        skillNameToId.put("staff", 10090);
        skillNameToId.put("papyrusmaking", 10091);
        skillNameToId.put("thatching", 10092);
        skillNameToId.put("ballista", 10093);
        skillNameToId.put("trebuchet", 10094);
        skillNameToId.put("restoration", 10095);

        for(String name : skillNameToId.keySet()){
            skillIdToName.put(skillNameToId.get(name), name);
        }
    }
}
