package net.kofeychi.Modularity.Registry;

import net.kofeychi.Modularity.Util.IU;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class ShakePacket {
    public record ShakePayload(String data) implements CustomPayload {
        public static final CustomPayload.Id<ShakePayload> ID = new CustomPayload.Id<>(SHAKE_PACKET_ID);
        public static final PacketCodec<RegistryByteBuf, ShakePayload> CODEC = PacketCodec.tuple(
                PacketCodecs.STRING, ShakePayload::data,
                ShakePayload::new);
        @Override
        public CustomPayload.Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
    public record PosShakePayload(String data) implements CustomPayload {
        public static final CustomPayload.Id<PosShakePayload> ID = new CustomPayload.Id<>(POS_SHAKE_PACKET_ID);
        public static final PacketCodec<RegistryByteBuf, PosShakePayload> CODEC = PacketCodec.tuple(
                PacketCodecs.STRING, PosShakePayload::data,
                PosShakePayload::new);
        @Override
        public CustomPayload.Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
    public static Identifier SHAKE_PACKET_ID = IU.of("screenshake_normal");
    public static Identifier POS_SHAKE_PACKET_ID = IU.of("screenshake_pos");
}
