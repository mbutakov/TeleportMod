package mbutakov.respawnmod.client;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import ibxm.Player;
import mbutakov.respawnmod.KeyRegister;
import mbutakov.respawnmod.client.gui.RespawnGui;
import mbutakov.respawnmod.common.packet.PacketTeleport;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import ru.xlv.packetapi.common.sender.Sender;

public class ClientEvents {

	@SubscribeEvent
	public void key(KeyInputEvent event) {
		
        if(KeyRegister.KeyOpenTeleportMenu.isPressed()) {
        	   int v = 0;
            Sender.callback(new PacketTeleport(v))
            .send() // sending a callback to the server
            .onResult(result -> { // when the response came back from the server
                if(result.isSuccess()) {
                    Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new RespawnGui());
                } else {
                }
            })
            .onTimeout(() -> System.out.println("TIMEOUT")) // on timeout
            .onError(exception -> System.out.println("EXCEPTION: " + exception)); // if an exception thrown during execution
 
        }
        
	}

}
