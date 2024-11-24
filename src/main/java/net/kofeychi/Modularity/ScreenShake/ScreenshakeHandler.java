package net.kofeychi.Modularity.ScreenShake;

import net.minecraft.client.render.Camera;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;

import static org.joml.SimplexNoise.noise;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class ScreenshakeHandler {

    public static final ArrayList<ScreenshakeInstance> INSTANCES = new ArrayList<>();
    public static float intensity;
    public static float yawOffset;
    public static float pitchOffset;
    public static float zOffset;
    public static float x,y;
    public static void cameraTick(Camera camera, Random random) {
        if (intensity > 0) {
            double perlinS = INSTANCES.stream().mapToDouble(ScreenshakeInstance::getPerlinSpeed).sum()/10;
            if (x<50) {
                x= (float) (x+perlinS);}
            if (x>=50) {
                y= (float) (y+perlinS);
                x= -50f;}
            if (y>=50) {
                y=-50f;}
            int perlin = INSTANCES.stream().mapToInt(ScreenshakeInstance::getPerlin).max().orElse(0);
            int IsRotation = INSTANCES.stream().mapToInt(ScreenshakeInstance::getIsRotation).max().orElse(1);
            int IsPosition = INSTANCES.stream().mapToInt(ScreenshakeInstance::getIsPosition).max().orElse(0);
            float I1 = (float) INSTANCES.stream().mapToDouble(ScreenshakeInstance::getIntensity2).sum();
            if (perlin >= 0.1) {
                yawOffset = randomizeOffsetx(I1);
                pitchOffset = randomizeOffsety(I1);
                zOffset = randomizeOffsety(I1);
            } else {
                yawOffset = randomizeOffset(random);
                pitchOffset = randomizeOffset(random);
                zOffset = randomizeOffset(random);
            }
            if (IsRotation >= 0.1) {
                camera.setRotation(camera.getYaw() + yawOffset, camera.getPitch() + pitchOffset);
            }
            if (IsPosition >= 0.1) {
                camera.setPos(camera.getPos().add(-yawOffset,pitchOffset,zOffset));
            }
        }
    }

    public static void clientTick(Camera camera, Random random) {
        // NOTE : that is fucking stupid implentation of all this so dont use it.
        /*// init
        intensity = 0;
        int ii = 0;
        int SiNum = 0;
        int SiPosNum = 0;
        ScreenshakeInstance sii = null;
        //
        // apply test instance
        for(Iterator var2 = INSTANCES.iterator(); var2.hasNext(); ++ii) {
            sii = (ScreenshakeInstance) var2.next();
        }
        if (sii == null) {return;} //erm what the sigma return of null?
        //execute if mode is applied
        if (sii.getMode() == 2) {
            //count instances
            for (Iterator var2 = INSTANCES.iterator(); var2.hasNext(); ++ii) {
                ScreenshakeInstance SI = (ScreenshakeInstance) var2.next();
                if (SI instanceof PositionedScreenshakeInstance sipos) {
                    SiPosNum++;
                } else {
                    SiNum++;
                }
            }
            for (Iterator var2 = INSTANCES.iterator(); var2.hasNext(); ++ii) {
                ScreenshakeInstance SI = (ScreenshakeInstance) var2.next();
                if (SI instanceof PositionedScreenshakeInstance sipos) {
                    for (int i = 0; i < SiPosNum; i++) {
                        sipos.setInt2((float) (sipos.getBaseIntensity2() * SiPosNum / Math.pow(SiPosNum,3)));
                        sipos.setDur((int) (sipos.getBaseDur() * SiPosNum / Math.pow(SiPosNum,3)));
                        sipos.setFal((float) (sipos.getBaseFal() * SiPosNum / Math.pow(SiPosNum,3)));
                        sipos.setMax((float) (sipos.getBaseMax()  * SiPosNum / Math.pow(SiPosNum,3)));
                    }
                } else {
                    for (int i = 0; i < SiNum; i++) {
                        SI.setInt2((float) (SI.getBaseIntensity2() * SiNum / Math.pow(SiNum,3)));
                        SI.setDur((int) (SI.getBaseDur() * SiNum / Math.pow(SiNum,3)));
                    }
                }
            }
            double sum = Math.min(INSTANCES.stream().mapToDouble(i1 -> i1.updateIntensity(camera, random)).sum(),1);
            intensity = (float) Math.pow(sum, 3);
            INSTANCES.removeIf(i -> i.progress-0.5f >= i.duration);
        }
         */
            double sum = Math.min(INSTANCES.stream().mapToDouble(i1 -> i1.updateIntensity(camera, random)).sum(), 1);
            intensity = (float) Math.pow(sum, 3);
            INSTANCES.removeIf(i -> i.progress - 0.5f >= i.duration);
    }
    //                double sum = Math.min(SI.updateIntensity(camera, random), 1);
    //                float intensityTwo = (float) Math.pow(sum, 3);

    public static void addScreenshake(ScreenshakeInstance instance) {
        INSTANCES.add(instance);
    }

    public static float randomizeOffsetx(float i1) {
        return noise(
                x,//MathHelper.nextFloat(random, -intensity * 2, intensity * 2),
                y//MathHelper.nextFloat(random, -intensity * 2, intensity * 2)
        )*(-intensity * 2)*(1+i1);
    }
    public static float randomizeOffsety(float i1) {
        return noise(
                -x,//MathHelper.nextFloat(random, -intensity * 2, intensity * 2),
                -y//MathHelper.nextFloat(random, -intensity * 2, intensity * 2)
        )*(intensity * 2)*(1+i1);
    }
    public static float randomizeOffset(Random random) {return MathHelper.nextFloat(random, -intensity * 2, intensity * 2);}
}