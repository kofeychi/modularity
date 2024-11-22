package net.kofeychi.Modularity.Networking;

import net.kofeychi.Modularity.Registry.ShakePacket;
import net.kofeychi.Modularity.Util.IU;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class Networking {
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityNetworking";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}
    // MODULARITY ADDON LOADER MAIN INFO
    /*public record bytearraypayload(byte[] data,byte[] sequence,String TargetClassAcceptor) implements CustomPayload {
        public static final CustomPayload.Id<ShakePacket.ShakePayload> ID = new CustomPayload.Id<>(SHAKE_PACKET_ID);
        public static final PacketCodec<RegistryByteBuf, bytearraypayload> CODEC = PacketCodec.tuple(
                PacketCodecs.BYTE_ARRAY, bytearraypayload::data,
                PacketCodecs.BYTE_ARRAY, bytearraypayload::sequence,
                PacketCodecs.STRING, bytearraypayload::TargetClassAcceptor,
                bytearraypayload::new);
        @Override
        public CustomPayload.Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
    public static Identifier SHAKE_PACKET_ID = IU.of("bytearrayunpackable");
     */
}

