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

import net.kofeychi.Modularity.Examples.DataExample;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.List;

/**
 * The base API package that allows you to use the API of this mod with proper java-doc.
 *
 * @author Kofeychi
 * @version 1.0 BETA
 * @since 1.0-BETA-1.21
 */
public abstract class API {
    public abstract static class ScreenShakeAPI {
    /**
     * Sends the ScreenShake packet to the all clients on the server,then applies it after creating the Screenshake effect.
     * Make sure you execute this on the server thread so there is no duplicate from render thread.
     *<p>
     * @see DataExample#SendNormalToAllPlayers()  Example of parameters
     * @param Duration Duration of Screenshake.
     *<p>
     * @param Intensity1 Intensity start point (mainly just 0).
     * <p>
     * @param Intensity2 Intensity curve mid-point (If mode parameter is 0 then its used as end point).
     *<p>
     * @param Intensity3 Intensity end point.
     *<p>
     * @param EasingIn The Easing for start-to-mid-point curve. If mode parameter is 0 then this easing is for start-to-mid. {@link net.kofeychi.Modularity.Util.Easing Easings that are available here.}If you wish to select Easings dynamically,i recomend using this: {@link DataExample#SelectEasing(String) Easing selector with invalid string protection.}
     *<p>
     * @param EasingOut The Easing for mid-to-end curve.
     *<p>
     * @param IsPerlin Enables perlin.
     *<p>
     * @param Mode Mode of Screenshake. Commonly just 1 for start-to-end shake. (values: 0,1)
     *<p>
     * @param IsRot Is rotational shake.
     *<p>
     * @param IsPos Is Positional shake.
     *<p>
     * @param PerlinSpeed Speed of the Perlin parameter if enabled.
     *<p>
     */
    public static void SendNormalToAllPlayers(int Duration,
    float Intensity1,
    float Intensity2,
    float Intensity3,
    String EasingIn,
    String EasingOut,
    boolean IsPerlin,
    int Mode,
    boolean IsRot,
    boolean IsPos,
    float PerlinSpeed
    ) {
        BaseAPI.ScreenShakeAPI.SendNormalToAllPlayers(Duration, Intensity1, Intensity2, Intensity3, EasingIn, EasingOut, IsPerlin, Mode, IsRot, IsPos, PerlinSpeed);
    }
    /**
     * Sends the ScreenShake packet to the all Listed clients on the server,then applies it after creating the Screenshake effect.
     * Make sure you execute this on the server thread so there is no duplicate from render thread.
     *<p>
     * @see DataExample#SendNormalToSpecificPlayers()  Example of parameters
     * @param Duration Duration of Screenshake.
     *<p>
     * @param Intensity1 Intensity start point (mainly just 0).
     * <p>
     * @param Intensity2 Intensity curve mid-point (If mode parameter is 0 then its used as end point).
     *<p>
     * @param Intensity3 Intensity end point.
     *<p>
     * @param EasingIn The Easing for start-to-mid-point curve. If mode parameter is 0 then this easing is for start-to-mid. {@link net.kofeychi.Modularity.Util.Easing Easings that are available here.}If you wish to select Easings dynamically,i recomend using this: {@link DataExample#SelectEasing(String) Easing selector with invalid string protection.}
     *<p>
     * @param EasingOut The Easing for mid-to-end curve.
     *<p>
     * @param IsPerlin Enables perlin.
     *<p>
     * @param Mode Mode of Screenshake. Commonly just 1 for start-to-end shake. (values: 0,1)
     *<p>
     * @param Targets {@link List List} of the targets who will get the packet.
     *<p>
     * @param IsRot Is rotational shake.
     *<p>
     * @param IsPos Is Positional shake.
     *<p>
     * @param PerlinSpeed Speed of the Perlin parameter if enabled.
     *<p>
     */
    public static void SendNormalToSpecificPlayers(int Duration,
    float Intensity1,
    float Intensity2,
    float Intensity3,
    String EasingIn,
    String EasingOut,
    boolean IsPerlin,
    int Mode,
    boolean IsRot,
    boolean IsPos,
    float PerlinSpeed,
    List<ServerPlayerEntity> Targets
    ) {
        BaseAPI.ScreenShakeAPI.SendNormalToSpecificPlayers(Duration, Intensity1, Intensity2, Intensity3, EasingIn, EasingOut, IsPerlin, Mode, Targets,IsRot, IsPos, PerlinSpeed);
    }
    /**
     * Sends the ScreenShake packet to the all clients on the server,then applies it after creating the Screenshake effect.
     * Make sure you execute this on the server thread so there is no duplicate from render thread.
     *<p>
     * @see DataExample#SendPosToAllPlayers()  Example of parameters
     * @param Duration Duration of Screenshake.
     *<p>
     * @param Position Position of Screenshake in {@link Vec3d Vec3d}
     *<p>
     * @param FalloffDistance Distance in blocks from which the Screenshake will shake less.
     *<p>
     * @param MaxDistance Maximal distance in blocks from which the Screenshake effect is not visible.
     *<p>
     * @param Intensity1 Intensity start point (mainly just 0).
     *<p>
     * @param Intensity2 Intensity curve mid-point (If mode parameter is 0 then its used as end point).
     *<p>
     * @param Intensity3 Intensity end point.
     *<p>
     * @param EasingIn The Easing for start-to-mid-point curve. If mode parameter is 0 then this easing is for start-to-mid. {@link net.kofeychi.Modularity.Util.Easing Easings that are available here.}If you wish to select Easings dynamically,i recomend using this: {@link DataExample#SelectEasing(String) Easing selector with invalid string protection.}
     *<p>
     * @param EasingOut The Easing for mid-to-end curve.
     *<p>
     * @param IsPerlin Enables perlin.
     *<p>
     * @param Mode Mode of Screenshake. Commonly just 1 for start-to-end shake. (values: 0,1)
     *<p>
     * @param IsRot Is rotational shake.
     *<p>
     * @param IsPos Is Positional shake.
     *<p>
     * @param PerlinSpeed Speed of the Perlin parameter if enabled.
     *<p>
     */
    public static void SendPosToAllPlayers(
            int Duration,
            Vec3d Position,
            float FalloffDistance,
            float MaxDistance,
            String EasingFallof,
            float Intensity1,
            float Intensity2,
            float Intensity3,
            String EasingIn,
            String EasingOut,
            boolean IsPerlin,
            int Mode,
            boolean IsRot,
            boolean IsPos,
            float PerlinSpeed
    ){
        BaseAPI.ScreenShakeAPI.SendPosToAllPlayers(Duration, Position, FalloffDistance, MaxDistance, EasingFallof, Intensity1, Intensity2, Intensity3, EasingIn, EasingOut, IsPerlin, Mode, IsRot, IsPos, PerlinSpeed);
    }
        /**
         * Sends the ScreenShake packet to the all Listed clients on the server,then applies it after creating the Screenshake effect.
         * Make sure you execute this on the server thread so there is no duplicate from render thread.
         *<p>
         * @see DataExample#SendPosToSpecificPlayers()  Example of parameters
         * @param Duration Duration of Screenshake.
         *<p>
         * @param Position Position of Screenshake in {@link Vec3d Vec3d}
         *<p>
         * @param FalloffDistance Distance in blocks from which the Screenshake will shake less.
         *<p>
         * @param MaxDistance Maximal distance in blocks from which the Screenshake effect is not visible.
         *<p>
         * @param Intensity1 Intensity start point (mainly just 0).
         *<p>
         * @param Intensity2 Intensity curve mid-point (If mode parameter is 0 then its used as end point).
         *<p>
         * @param Intensity3 Intensity end point.
         *<p>
         * @param EasingIn The Easing for start-to-mid-point curve. If mode parameter is 0 then this easing is for start-to-mid. {@link net.kofeychi.Modularity.Util.Easing Easings that are available here.}If you wish to select Easings dynamically,i recomend using this: {@link DataExample#SelectEasing(String) Easing selector with invalid string protection.}
         *<p>
         * @param EasingOut The Easing for mid-to-end curve.
         *<p>
         * @param IsPerlin Enables perlin.
         *<p>
         * @param Mode Mode of Screenshake. Commonly just 1 for start-to-end shake. (values: 0,1)
         *<p>
         * @param Targets {@link List List} of the targets who will get the packet.
         *<p>
         * @param IsRot Is rotational shake.
         *<p>
         * @param IsPos Is Positional shake.
         *<p>
         * @param PerlinSpeed Speed of the Perlin parameter if enabled.
         *<p>
         */
        public static void SendPosToSpecificPlayers(
                int Duration,
                Vec3d Position,
                float FalloffDistance,
                float MaxDistance,
                String EasingFallof,
                float Intensity1,
                float Intensity2,
                float Intensity3,
                String EasingIn,
                String EasingOut,
                boolean IsPerlin,
                int Mode,
                boolean IsRot,
                boolean IsPos,
                float PerlinSpeed,
                List<ServerPlayerEntity> Targets
        ){
            BaseAPI.ScreenShakeAPI.SendPosToSpecificPlayers(Duration, Position, FalloffDistance, MaxDistance, EasingFallof, Intensity1, Intensity2, Intensity3, EasingIn, EasingOut, IsPerlin, Mode, Targets,IsRot, IsPos, PerlinSpeed);
        }
}
}
