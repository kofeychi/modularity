package net.kofeychi.Modularity.Examples;
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

import net.kofeychi.Modularity.API.BaseAPI;
import net.kofeychi.Modularity.DataUtil.EasingSelector;
import net.kofeychi.Modularity.Util.Easing;
import net.kofeychi.Modularity.base.Modularity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.Vec3d;

import java.util.List;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class DataExample {
    public static Easing SelectEasing(String val){
        return EasingSelector.EasingSelectorGet(val);
    }
    public static void SendNormalToAllPlayers() {
        BaseAPI.ScreenShakeAPI.SendNormalToAllPlayers(100, 0, 10/10, 0, Easing.QUAD_IN.name, Easing.QUAD_IN.name, true, 0, true, false, 1/10);
    }
    public static void SendNormalToSpecificPlayers() {
        List<ServerPlayerEntity> Targets = Modularity.Server.getPlayerManager().getPlayerList();
        BaseAPI.ScreenShakeAPI.SendNormalToSpecificPlayers(100, 0, 10/10, 0, Easing.QUAD_IN.name, Easing.QUAD_IN.name, true, 0,Targets, true, false, 1/10);
    }
    public static void SendPosToAllPlayers(){
        BaseAPI.ScreenShakeAPI.SendPosToAllPlayers(100, new Vec3d(0,90,0), 5, 25, Easing.QUAD_IN.name, 0, 10, 0, Easing.QUAD_IN.name, Easing.QUAD_IN.name, true, 1, true, false,5/10);
    }
    public static void SendPosToSpecificPlayers(){
        List<ServerPlayerEntity> Targets = Modularity.Server.getPlayerManager().getPlayerList();
        BaseAPI.ScreenShakeAPI.SendPosToSpecificPlayers(100, new Vec3d(0,90,0), 5, 25, Easing.QUAD_IN.name, 0, 10, 0, Easing.QUAD_IN.name, Easing.QUAD_IN.name, true, 1,Targets, true, false,5/10);
    }
}
