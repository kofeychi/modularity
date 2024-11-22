package net.kofeychi.Modularity.API;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kofeychi.Modularity.DataUtil.CODECS;
import net.kofeychi.Modularity.Registry.ShakePacket;
import net.kofeychi.Modularity.base.Modularity;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@ApiStatus.Internal
public class BaseAPI {
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityAPI";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}
    // MODULARITY ADDON LOADER MAIN INFO
    public static class ScreenShakeAPI{
        private static int b2i(boolean val) {int pe=0;if (val) {pe=1;}return pe;}
        public static void SendNormalToAllPlayers(int duration,float intensity1,float intensity2,float intensity3,String easingIn,String easingOut,boolean Perlin,int mode,boolean isRot,boolean isPos){
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
                                iPos
                        )
                ));
            }
        }
        public static void SendNormalToSpecificPlayers(int duration, float intensity1, float intensity2, float intensity3, String easingIn, String easingOut, boolean Perlin, int mode, List<ServerPlayerEntity> target,boolean isRot,boolean isPos){
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
                                iPos
                        )
                ));
            }
        }
        public static void SendPosToAllPlayers(int duration, Vec3d pos,float falloffDistance,float maxDistance,String EasingFallof,float intensity1, float intensity2, float intensity3, String easingIn, String easingOut, boolean Perlin, int mode,boolean isRot,boolean isPos){
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
                                iPos
                        )
                ));
            }
        }
        public static void SendPosToSpecificPlayers(int duration, Vec3d pos,float falloffDistance,float maxDistance,String EasingFallof,float intensity1, float intensity2, float intensity3, String easingIn, String easingOut, boolean Perlin, int mode, List<ServerPlayerEntity> target,boolean isRot,boolean isPos){
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
                                iPos
                        )
                ));
            }
        }
    }
}
