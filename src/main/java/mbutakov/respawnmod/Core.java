package mbutakov.respawnmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import mbutakov.respawnmod.common.CommonProxy;
import mbutakov.respawnmod.common.packet.PacketTeleport;
import mbutakov.respawnmod.common.packet.PacketTeleportServer;
import mbutakov.respawnmod.server.TeleportConfig;
import ru.xlv.packetapi.common.packet.registration.PacketSubscriber;

@PacketSubscriber(channelName = Core.MODID, packets = {
	    PacketTeleport.class,
	    PacketTeleportServer.class,
	})

@Mod(modid = "mbTeleportMod", name = "mbTeleportMod", version = "0.1")
public class Core {

	public static final String VERSION = "0.1";
	public static final String MODID = "mbTeleportMod";
	public static SimpleNetworkWrapper network;
	@SidedProxy(clientSide = "mbutakov.respawnmod.client.ClientProxy", serverSide = "mbutakov.respawnmod.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance("jscV2")
	public static Core instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void Init(FMLInitializationEvent e){
		proxy.Init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		TeleportConfig.load();
	}
	
	
	
}
