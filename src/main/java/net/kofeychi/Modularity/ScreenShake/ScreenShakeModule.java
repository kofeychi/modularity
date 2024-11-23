package net.kofeychi.Modularity.ScreenShake;
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
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.kofeychi.Modularity.DataUtil.CODECS;
import net.kofeychi.Modularity.DataUtil.EasingSelector;
import net.kofeychi.Modularity.Registry.ShakePacket;
import net.kofeychi.Modularity.base.Modularity;
import net.kofeychi.Modularity.logger.LogTypes;
import net.kofeychi.Modularity.logger.ModularityLogger;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;

public class ScreenShakeModule implements ClientModInitializer {
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityScreenShake";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}
    public static ModularityLogger ModularityNetwork = new ModularityLogger("ModularityNetwork");
    // MODULARITY ADDON LOADER MAIN INFO
    public static final Random RANDOM = Random.create();
    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register((minecraft) -> {
            if (minecraft.world != null) {
                if (minecraft.isPaused()) {
                    return;
                }
                Camera camera = minecraft.gameRenderer.getCamera();
                ScreenshakeHandler.clientTick(camera, RANDOM);
            }
        });
        ClientPlayNetworking.registerGlobalReceiver(ShakePacket.ShakePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                String[] data = CODECS.ShakeCODEC.UnPackShake(payload.data());
                ScreenshakeHandler.addScreenshake(
                        new ScreenshakeInstance(
                                Integer.parseInt(data[0]), //dur
                                Integer.parseInt(data[6]), //perlin
                                Integer.parseInt(data[7])  //mode
                        ).setEasing(
                                EasingSelector.EasingSelectorGet(data[4]), //start
                                EasingSelector.EasingSelectorGet(data[5])  //end
                        ).setIntensity(
                                Float.parseFloat(data[1]),  //in1
                                Float.parseFloat(data[2]),  //in2
                                Float.parseFloat(data[3])   //in3
                        ).setBases(
                                new Vec3d(Float.parseFloat(data[1]),  //in1
                                        Float.parseFloat(data[2]),  //in2
                                        Float.parseFloat(data[3])),
                                Integer.parseInt(data[0])
                        ).setIs(
                                Integer.parseInt(data[8]),
                                Integer.parseInt(data[9])
                        ).setPerlinSpeed(Float.parseFloat(data[10]))
                );
                if (Modularity.isDevelopment) {
                    ArrayList<String> msg = new ArrayList<>();
                    msg.add("Received ScreenShakeInstance on ShakeChannel! data:");
                    msg.add(data[0]);
                    msg.add(data[1]);
                    msg.add(data[2]);
                    msg.add(data[3]);
                    msg.add(data[4]);
                    msg.add(data[5]);
                    msg.add(data[6]);
                    msg.add(data[7]);
                    msg.add(data[8]);
                    msg.add(data[9]);
                    msg.add(data[10]);
                    ModularityNetwork.LogSMTH(msg, LogTypes.INFO);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(ShakePacket.PosShakePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                String[] data =  CODECS.ShakeCODEC.UnPackPosShake(payload.data());
                ScreenshakeHandler.addScreenshake(
                        new PositionedScreenshakeInstance(
                                Integer.parseInt(data[0]), //dur
                                Integer.parseInt(data[12]), //perlin

                                new Vec3d(Double.parseDouble(data[1]),
                                        Double.parseDouble(data[2]),
                                        Double.parseDouble(data[3])),

                                Float.parseFloat(data[4]),
                                Float.parseFloat(data[5]),

                                EasingSelector.EasingSelectorGet(data[6]),
                                Integer.parseInt(data[13])
                        ).setIntensity(
                                Float.parseFloat(data[7]),
                                Float.parseFloat(data[8]),
                                Float.parseFloat(data[9])
                        ).setEasing(
                                EasingSelector.EasingSelectorGet(data[10]),
                                EasingSelector.EasingSelectorGet(data[11])
                        ).setBases(
                                new Vec3d(Float.parseFloat(data[7]),
                                        Float.parseFloat(data[8]),
                                        Float.parseFloat(data[9])),
                                Integer.parseInt(data[0])
                        ).setIs(
                                Integer.parseInt(data[14]),
                                Integer.parseInt(data[15])
                        ).setPerlinSpeed(Float.parseFloat(data[16]))
                );
                if (Modularity.isDevelopment) {
                    ArrayList<String> msg = new ArrayList<>();
                    msg.add("Received PositionalScreenShakeInstance on PosShakeChannel! data:");
                    msg.add(data[0]);
                    msg.add(data[1]);
                    msg.add(data[2]);
                    msg.add(data[3]);
                    msg.add(data[4]);
                    msg.add(data[5]);
                    msg.add(data[6]);
                    msg.add(data[7]);
                    msg.add(data[8]);
                    msg.add(data[9]);
                    msg.add(data[10]);
                    msg.add(data[11]);
                    msg.add(data[12]);
                    msg.add(data[13]);
                    msg.add(data[14]);
                    msg.add(data[15]);
                    msg.add(data[16]);
                    ModularityNetwork.LogSMTH(msg, LogTypes.INFO);
                }
            });
        });
    }
}
