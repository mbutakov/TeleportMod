package mbutakov.respawnmod.server;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class TeleportConfig {
	
	private static Configuration config;
	public static String safeZoneArenaX;
	public static String safeZoneArenaZ;
	public static String safeZoneArenaX2;
	public static String safeZoneArenaZ2;
	
    public static void load() {
        (TeleportConfig.config = new Configuration(new File(String.format("mbutakov/%s/config/config.cfg", "TeleportMod")))).load();
        if (!TeleportConfig.config.hasCategory("server")) {
            save();
        }
        TeleportConfig.safeZoneArenaX = getString("safeZoneArenaX");
        TeleportConfig.safeZoneArenaZ = getString("safeZoneArenaZ");
        TeleportConfig.safeZoneArenaX2 = getString("safeZoneArenaX2");
        TeleportConfig.safeZoneArenaZ2 = getString("safeZoneArenaZ2");
        
    }
    
    private static void save() {
        setString("safeZoneArenaX",1);
        setString("safeZoneArenaZ", 1);
        setString("safeZoneArenaX2",1);
        setString("safeZoneArenaZ2", 1);
        TeleportConfig.config.save();
    }
    
    private static void setString(final String key,int def) {
    	TeleportConfig.config.get("server", key, key).set(def);
    }
    
    private static String getString(final String key) {
        return TeleportConfig.config.get("server", key, key).getString();
    }

}
