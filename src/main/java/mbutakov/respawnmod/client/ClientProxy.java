package mbutakov.respawnmod.client;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.respawnmod.KeyRegister;
import mbutakov.respawnmod.common.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);

	}

	public void Init() {
		super.Init();
		KeyRegister.addKeys();
		final ClientEvents cevents = new ClientEvents();
		MinecraftForge.EVENT_BUS.register(cevents);
		FMLCommonHandler.instance().bus().register(cevents);
	}

}
