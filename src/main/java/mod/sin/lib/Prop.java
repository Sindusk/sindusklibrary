package mod.sin.lib;

import java.util.Properties;

public class Prop {
    public static Properties properties;
    public static boolean getBooleanProperty(String field, boolean def){
        return Boolean.parseBoolean(properties.getProperty(field, Boolean.toString(def)));
    }
    public static String getStringProperty(String field, String def){
        return properties.getProperty(field, def);
    }
    public static int getIntegerProperty(String field, int def){
        return Integer.parseInt(properties.getProperty(field, Integer.toString(def)));
    }
    public static long getLongProperty(String field, long def){
        return Long.parseLong(properties.getProperty(field, Long.toString(def)));
    }
    public static float getFloatProperty(String field, float def){
        return Float.parseFloat(properties.getProperty(field, Float.toString(def)));
    }
}
