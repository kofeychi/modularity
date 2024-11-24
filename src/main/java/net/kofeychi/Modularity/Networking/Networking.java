package net.kofeychi.Modularity.Networking;

import net.kofeychi.Modularity.Registry.ShakePacket;
import net.kofeychi.Modularity.Util.IU;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;

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
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class Networking {
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityNetworking";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}
    // MODULARITY ADDON LOADER MAIN INFO
    public record bytearraypayload(byte[] data,byte[] sequence) implements CustomPayload {
        public static final CustomPayload.Id<bytearraypayload> ID = new CustomPayload.Id<>(BYTEARRAYPAYLOAD);
        public static final PacketCodec<RegistryByteBuf, bytearraypayload> CODEC = PacketCodec.tuple(
                PacketCodecs.BYTE_ARRAY, bytearraypayload::data,
                PacketCodecs.BYTE_ARRAY, bytearraypayload::sequence,
                bytearraypayload::new);
        @Override
        public CustomPayload.Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
    public static Identifier BYTEARRAYPAYLOAD = IU.of("bytearrayunpackable");
}

