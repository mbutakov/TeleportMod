package mbutakov.respawnmod;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyRegister {
	
	
	public static KeyBinding KeyOpenTeleportMenu;
	
	
	public static void addKeys() {
	  	KeyOpenTeleportMenu = new KeyBinding("Меню телепорта",Keyboard.KEY_Y, Core.MODID);
	  	ClientRegistry.registerKeyBinding(KeyOpenTeleportMenu);
	}

}
