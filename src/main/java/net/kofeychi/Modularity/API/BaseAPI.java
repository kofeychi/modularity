package net.kofeychi.Modularity.API;
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

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kofeychi.Modularity.DataUtil.CODECS;
import net.kofeychi.Modularity.Registry.ShakePacket;
import net.kofeychi.Modularity.base.Modularity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.Vec3d;

import java.util.Iterator;
import java.util.List;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class BaseAPI{
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityAPI";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}
    // MODULARITY ADDON LOADER MAIN INFO
    public static class ScreenShakeAPI{
        private static int b2i(boolean val) {int pe=0;if (val) {pe=1;}return pe;}
        public static void SendNormalToAllPlayers(int duration,float intensity1,float intensity2,float intensity3,String easingIn,String easingOut,boolean Perlin,int mode,boolean isRot,boolean isPos,float pS){
            int pe=b2i(Perlin);
            int iRot=b2i(isRot);
            int iPos=b2i(isPos);
            int i = 0;
            for(Iterator var2 = Modularity.Server.getPlayerManager().getPlayerList().iterator(); var2.hasNext(); ++i) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var2.next();
                ServerPlayNetworking.send(serverPlayerEntity, new ShakePacket.ShakePayload(
                        CODECS.ShakeCODEC.PackShake(
                                duration,
                                intensity1,
                                intensity2,
                                intensity3,
                                easingIn,
                                easingOut,
                                pe,
                                mode,
                                iRot,
                                iPos,
                                pS
                        )
                ));
            }
        }
        public static void SendNormalToSpecificPlayers(int duration, float intensity1, float intensity2, float intensity3, String easingIn, String easingOut, boolean Perlin, int mode, List<ServerPlayerEntity> target,boolean isRot,boolean isPos,float pS){
            int pe=b2i(Perlin);
            int iRot=b2i(isRot);
            int iPos=b2i(isPos);
            int i = 0;
            for(Iterator var2 = target.iterator(); var2.hasNext(); ++i) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var2.next();
                ServerPlayNetworking.send(serverPlayerEntity, new ShakePacket.ShakePayload(
                        CODECS.ShakeCODEC.PackShake(
                                duration,
                                intensity1,
                                intensity2,
                                intensity3,
                                easingIn,
                                easingOut,
                                pe,
                                mode,
                                iRot,
                                iPos,
                                pS
                        )
                ));
            }
        }
        public static void SendPosToAllPlayers(int duration, Vec3d pos,float falloffDistance,float maxDistance,String EasingFallof,float intensity1, float intensity2, float intensity3, String easingIn, String easingOut, boolean Perlin, int mode,boolean isRot,boolean isPos,float pS){
            int pe=b2i(Perlin);
            int iRot=b2i(isRot);
            int iPos=b2i(isPos);
            int i = 0;
            for(Iterator var2 = Modularity.Server.getPlayerManager().getPlayerList().iterator(); var2.hasNext(); ++i) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var2.next();
                ServerPlayNetworking.send(serverPlayerEntity, new ShakePacket.PosShakePayload(
                        CODECS.ShakeCODEC.PackPosShake(
                                duration,
                                pos.x,
                                pos.y,
                                pos.z,
                                falloffDistance,
                                maxDistance,
                                EasingFallof,
                                intensity1,
                                intensity2,
                                intensity3,
                                easingIn,
                                easingOut,
                                pe,
                                mode,
                                iRot,
                                iPos,
                                pS
                        )
                ));
            }
        }
        public static void SendPosToSpecificPlayers(int duration, Vec3d pos,float falloffDistance,float maxDistance,String EasingFallof,float intensity1, float intensity2, float intensity3, String easingIn, String easingOut, boolean Perlin, int mode, List<ServerPlayerEntity> target,boolean isRot,boolean isPos,float pS){
            int pe=b2i(Perlin);
            int iRot=b2i(isRot);
            int iPos=b2i(isPos);
            int i = 0;
            for(Iterator var2 = target.iterator(); var2.hasNext(); ++i) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var2.next();
                ServerPlayNetworking.send(serverPlayerEntity, new ShakePacket.PosShakePayload(
                        CODECS.ShakeCODEC.PackPosShake(
                                duration,
                                pos.x,
                                pos.y,
                                pos.z,
                                falloffDistance,
                                maxDistance,
                                EasingFallof,
                                intensity1,
                                intensity2,
                                intensity3,
                                easingIn,
                                easingOut,
                                pe,
                                mode,
                                iRot,
                                iPos,
                                pS
                        )
                ));
            }
        }
    }
}
