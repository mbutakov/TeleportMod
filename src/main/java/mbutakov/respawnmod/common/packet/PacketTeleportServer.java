package mbutakov.respawnmod.common.packet;


import io.netty.buffer.ByteBufOutputStream;
import mbutakov.respawnmod.server.TeleportConfig;
import net.minecraft.entity.player.EntityPlayer;
import ru.xlv.packetapi.common.packet.registration.Packet;
import ru.xlv.packetapi.common.util.ByteBufInputStream;
import ru.xlv.packetapi.server.ControllablePacket;
import ru.xlv.packetapi.server.forge.packet.ICallbackInServer;
import ru.xlv.packetapi.server.forge.packet.PacketCallbackSender;

import java.io.IOException;
import java.util.Random;

@Packet
@ControllablePacket(period = 200L, callWriteAnyway = true)
public class PacketTeleportServer implements ICallbackInServer {

    private Integer value;

    @Override
    public void read(EntityPlayer entityPlayer, ByteBufInputStream bbis, PacketCallbackSender packetCallbackSender) throws IOException {
        value = bbis.readInt();
    }

    @Override
    public void write(EntityPlayer entityPlayer, ByteBufOutputStream bbos) throws IOException {
        boolean success = false;
        if(entityPlayer != null) {
            if(entityPlayer.posX > Integer.parseInt(TeleportConfig.safeZoneArenaX) && entityPlayer.posX < Integer.parseInt(TeleportConfig.safeZoneArenaX2) && entityPlayer.posZ > Integer.parseInt(TeleportConfig.safeZoneArenaZ) && entityPlayer.posZ < Integer.parseInt(TeleportConfig.safeZoneArenaZ2)) {
        		success = true;
        		if(value != 0) {
        			  final Random r = new Random();
      	            switch (value) {
      	                case 0: {
      	                	entityPlayer.setPositionAndUpdate(49.0, 71.0, 60.0);
      	                    break;
      	                }
      	                case 1: {//Павлово
      	                	final int i0 = r.nextInt(4);
      	                	if (i0 == 0) {
      	                		entityPlayer.setPositionAndUpdate(-3377.0, 65.0, 2031.0);
      	                	}
      	                	if (i0 == 1) {
      	                		entityPlayer.setPositionAndUpdate(-3210.0, 65.0, 1965.0);
      	                	}
      	                	if (i0 == 2) {
      	                		entityPlayer.setPositionAndUpdate(-3218.0, 65.0, 2085.0);
      	                	}
      	                	if (i0 == 3) {
      	                		entityPlayer.setPositionAndUpdate(-3377.0, 65.0, 2083.0);
      	                	}
      	                	break;
      	                	}
      	                	case 2: {
      	                	final int j = r.nextInt(3);
      	                	if (j == 0) {//Отель
      	                		entityPlayer.setPositionAndUpdate(-475.0, 65.0, 3032.0);
      	                	}
      	                	if (j == 1) {
      	                		entityPlayer.setPositionAndUpdate(-496.0, 65.0, 2936.0);
      	                	}
      	                	if (j == 2) {
      	                		entityPlayer.setPositionAndUpdate(-599.0, 65.0, 2927.0);
      	                	break;
      	                	}
      	                	break;
      	                	}
      	                	case 3: {
      	                	final int i2 = r.nextInt(3);
      	                	if (i2 == 0) {//Палатки
      	                		entityPlayer.setPositionAndUpdate(-489.0, 69.0, -390.0);
      	                	}
      	                	if (i2 == 1) {
      	                		entityPlayer.setPositionAndUpdate(-425.0, 67.0, -223.0);
      	                	}
      	                	if (i2 == 2) {
      	                		entityPlayer.setPositionAndUpdate(-605.0, 69.0, -292.0);
      	                	break;
      	                	}
      	                	break;
      	                	}
      	                	case 4: {
      	                	final int i3 = r.nextInt(3);
      	                	if (i3 == 0) {//Бига
      	                		entityPlayer.setPositionAndUpdate(-1661.0, 65.0, -1432.0);
      	                	}
      	                	if (i3 == 1) {
      	                		entityPlayer.setPositionAndUpdate(-1578.0, 65.0, -1922.0);
      	                	}
      	                	if (i3 == 2) {
      	                		entityPlayer.setPositionAndUpdate(-1510.0, 65.0, -1722.0);
      	                	break;
      	                	}
      	                	break;
      	                	}
      	                	case 5: {
      	                	final int i4 = r.nextInt(3);
      	                	if (i4 == 0) {//Шахта
      	                		entityPlayer.setPositionAndUpdate(2521.0, 65.0, -1135.0);
      	                	}
      	                	if (i4 == 1) {
      	                		entityPlayer.setPositionAndUpdate(2439.0, 78.0, -1038.0);
      	                	}
      	                	if (i4 == 2) {
      	                		entityPlayer.setPositionAndUpdate(2384.0, 106.0, -1089.0);
      	                	break;
      	                	}
      	                	break;
      	                	}
      	                	case 6: {
      	                	final int i5 = r.nextInt(3);
      	                	if (i5 == 0) {//Электро
      	                		entityPlayer.setPositionAndUpdate(1752.0, 65.0, 3120.0);
      	                	}
      	                	if (i5 == 1) {
      	                		entityPlayer.setPositionAndUpdate(1785.0, 65.0, 3078.0);
      	                	}
      	                	if (i5 == 2) {
      	                		entityPlayer.setPositionAndUpdate(1706.0, 65.0, 3085.0);
      	                	break;
      	                	}
      	                	break;
      	                	}
      	                	case 7: {
      	                	final int i6 = r.nextInt(3);
      	                	if (i6 == 0) {//Собор
      	                		entityPlayer.setPositionAndUpdate(-553.0, 65.0, -1337.0);
      	                	}
      	                	if (i6 == 1) {
      	                		entityPlayer.setPositionAndUpdate(-589.0, 66.0, -1426.0);
      	                	}
      	                	if (i6 == 2) {
      	                		entityPlayer.setPositionAndUpdate(-517.0, 66.0, -1419.0);
      	                	}
      	                	break;
      	                	}
      	                	case 8: {
      	                	final int i6 = r.nextInt(3);
      	                	if (i6 == 0) {//Малое
      	                		entityPlayer.setPositionAndUpdate(-1660.0, 67.0, 2935.0);
      	                	}
      	                	if (i6 == 1) {
      	                		entityPlayer.setPositionAndUpdate(-1484.0, 67.0, 2913.0);
      	                	}
      	                	if (i6 == 2) {
      	                		entityPlayer.setPositionAndUpdate(-1427.0, 67.0, 2987.0);
      	                	break;
      	                	}
      	                	break;
      	                	}
      	            }
        		}
        	}
        }
        bbos.writeBoolean(success);
        System.out.println("The result was sent.");
    }
}
