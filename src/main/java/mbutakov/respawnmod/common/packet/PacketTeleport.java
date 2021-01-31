package mbutakov.respawnmod.common.packet;

import java.io.IOException;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBufOutputStream;
import ru.xlv.packetapi.client.packet.ICallbackOut;
import ru.xlv.packetapi.common.packet.registration.Packet;
import ru.xlv.packetapi.common.util.ByteBufInputStream;

@Packet
public class PacketTeleport implements ICallbackOut<PacketTeleport.Result> {

    private final Result result = new Result();

    private int value;

    public PacketTeleport() {}

    public PacketTeleport(int value) {
        this.value = value;
    }

    @Override
    public void write(ByteBufOutputStream bbos) throws IOException {
        bbos.writeInt(value);
    }

    @Override
    public void read(ByteBufInputStream bbis) throws IOException {
        result.success = bbis.readBoolean();
        result.responseMessage = bbis.readUTF();
    }

    @Nullable
    @Override
    public Result getResult() {
        return result;
    }

    public static class Result {

        private boolean success;
        private String responseMessage;

        public boolean isSuccess() {
            return success;
        }

        public String getResponseMessage() {
            return responseMessage;
        }
    }
}