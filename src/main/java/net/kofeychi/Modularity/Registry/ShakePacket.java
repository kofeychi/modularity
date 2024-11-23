package net.kofeychi.Modularity.Registry;
/*
 * ModularityAPI
 * Copyright (c) 2024. Kofeychi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
