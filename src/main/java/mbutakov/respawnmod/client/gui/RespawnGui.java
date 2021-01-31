package mbutakov.respawnmod.client.gui;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.respawnmod.common.packet.PacketTeleport;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import ru.xlv.packetapi.common.sender.Sender;

@SideOnly(Side.CLIENT)
public class RespawnGui extends GuiScreen
{
    public static RespawnGui gui;
    private static final ResourceLocation rs;
    public static final ArrayList<Slot> spawnsClient;
    int id;
    Random rand;
    private static int timer;
    
    public RespawnGui() {
        this.rand = new Random();
    }
    
    public void initGui() {
        final RespawnGui gui = RespawnGui.gui;
        RespawnGui.spawnsClient.clear();
        RespawnGui.spawnsClient.add(new Slot(-43, 0, -11, "SZ"));
        RespawnGui.spawnsClient.add(new Slot(-2500, 1, 3000, "\u041f\u0430\u0432\u043b\u043e\u0432\u043e"));
        RespawnGui.spawnsClient.add(new Slot(-800, 2, 6000, "Hotel"));
        RespawnGui.spawnsClient.add(new Slot(-1100, 3, -585, "\u041f\u0430\u043b\u0430\u0442\u043a\u0438"));
        RespawnGui.spawnsClient.add(new Slot(-2000, 4, -2500, "\u0411\u0438\u0433\u0430"));
        RespawnGui.spawnsClient.add(new Slot(1544, 5, -2957, "\u0428\u0430\u0445\u0442\u0430"));
        RespawnGui.spawnsClient.add(new Slot(1500, 6, 6000, "\u042d\u043b\u0435\u043a\u0442\u0440\u043e"));
        RespawnGui.spawnsClient.add(new Slot(3300, 7, 5200, "Собор"));
        RespawnGui.spawnsClient.add(new Slot(-1900, 8, 5650, "Малое Аэро"));
        
        this.buttonList.clear();
        spawnsClient.forEach(s -> {
            int a2 = this.fontRendererObj.getStringWidth(s.text);
            this.buttonList.add(new GuiButton(s.id, (int)((double)this.width / 2.05 + (double)(this.width * s.x) / 250.0) - a2 / 2, (int)((double)this.height / 2.05 + (double)(this.height * s.z) / 250.0), a2 + 10, 20, s.text));
        }
        );

        super.initGui();
    }
    
    public static int compareToMap(final int module) {
        return module / 60;
    }
    
    protected void mouseClicked(final int par1, final int par2, final int par3) {
        super.mouseClicked(par1, par2, par3);
        
    }
    
    public void actionPerformed(final GuiButton b) {
    	
    	if(timer <= 0) {
    		timer =+ 20;
        
        Sender.callback(new PacketTeleport(b.id))
        .send() // sending a callback to the server
        ;
    	}
    }
    
    public void drawScreen(final int x, final int y, final float pT) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        drawRect(0, 0, this.width, this.height, -14540254);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(RespawnGui.rs);
        final Tessellator t;
        (t = Tessellator.instance).startDrawingQuads();
        timer--;
        t.addVertexWithUV(this.width / 2.0 - this.height / 2.0 * 1.0985567010309278, (double)this.height, 0.0, 0.0, 1.0);
        t.addVertexWithUV(this.width / 2.0 + this.height / 2.0 * 1.0985567010309278, (double)this.height, 0.0, 1.0, 1.0);
        t.addVertexWithUV(this.width / 2.0 + this.height / 2.0 * 1.0985567010309278, 0.0, 0.0, 1.0, 0.0);
        t.addVertexWithUV(this.width / 2.0 - this.height / 2.0 * 1.0985567010309278, 0.0, 0.0, 0.0, 0.0);
        t.draw();
        super.drawScreen(x, y, pT);
    }
    
    public void updateScreen() {
        if (Minecraft.getMinecraft().thePlayer == null) {
            return;
        }
        final double x = Math.abs(Minecraft.getMinecraft().thePlayer.posX);
        final double y = Math.abs(Minecraft.getMinecraft().thePlayer.posY);
        final double z = Math.abs(Minecraft.getMinecraft().thePlayer.posZ);
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    static {
        RespawnGui.gui = new RespawnGui();
        rs = new ResourceLocation("jsc:textures/gui/map.png");
        spawnsClient = new ArrayList<Slot>();
    }
    
    public class Slot
    {
        int x;
        int id;
        int z;
        String text;
        
        public Slot(final int x, final int id, final int z, final String text) {
            this.text = text;
            this.x = RespawnGui.compareToMap(x);
            this.z = RespawnGui.compareToMap(z);
            this.id = id;
        }
    }
}
