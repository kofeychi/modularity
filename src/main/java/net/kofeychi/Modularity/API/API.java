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

/**
 * The base API package that allows you to use the API of this mod with proper java-doc.
 *
 * @author Kofeychi
 * @version 1.0 BETA
 * @since 1.0-BETA-1.21
 */
public abstract class API {
    /**
     * Sends the ScreenShake packet to the client and applies it after creating the Screenshake effect.
     * @see DataExample#SendNormalToAllPlayers()  Example of parameters
     * @param Duration Duration of Screenshake.
     * @param Intensity1 Intensity start point (mainly just 0).
     * @param Intensity2 Intensity curve mid-point (If mode parameter is 0 then its used as end point).
     * @param Intensity3 Intensity end point.
     * @param EasingIn The Easing for start-to-mid-point curve. If mode parameter is 0 then this easing is for start-to-mid.
     * @param EasingOut The Easing for mid-to-end curve.
     * @param IsPerlin Enables perlin.
     * @param Mode Mode of Screenshake. Commonly just 1 for start-to-end shake. (values: 0,1)
     * @param IsRot Is rotational shake.
     * @param IsPos Is Positional shake.
     * @param PerlinSpeed Speed of the Perlin parameter if enabled.
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
}
