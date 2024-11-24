package net.kofeychi.Modularity.ScreenShake;

import net.kofeychi.Modularity.Util.Easing;
import net.minecraft.client.render.Camera;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.joml.Vector3f;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class ScreenshakeInstance {
    public int progress;
    public int perlin;
    public int duration,baseDuration;
    public int isRotation = 1;
    public int isPosition = 0;
    public float perlinSpeed;
    public float intensity1, intensity2, intensity3,Baseintensity1, Baseintensity2, Baseintensity3;
    public static Easing intensityCurveStartEasing = Easing.LINEAR, intensityCurveEndEasing = Easing.LINEAR;
    public static int mode;

    public ScreenshakeInstance(int duration,int p,int mod) {
        this.duration = duration;
        perlin = p;
        mode = mod;
    }

    public ScreenshakeInstance setEasing(Easing e1,Easing e2) {
        intensityCurveStartEasing = e1;
        intensityCurveEndEasing = e2;
        return this;
    }

    public ScreenshakeInstance setIntensity(float i1,float i2,float i3) {
        this.intensity1 = i1;
        this.intensity2 = i2;
        this.intensity3 = i3;
        return this;
    }

    public float getPerlinSpeed() {return perlinSpeed;}
    public ScreenshakeInstance setPerlinSpeed(float a) {perlinSpeed = a;return this;}

    public int getIsRotation(){return isRotation;}
    public int getIsPosition() {return isPosition;}

    public ScreenshakeInstance setIs(int a,int b) {isRotation = a;isPosition = b;return this;}
    public ScreenshakeInstance setIsRotation(int m) {isRotation = m;return this;}
    public ScreenshakeInstance setIsPosition(int m) {isPosition = m;return this;}

    public ScreenshakeInstance setDur(int m) {duration = m;return this;}
    public int getDur() {return duration;}

    public ScreenshakeInstance setMode(int m) {mode = m;return this;}
    public int getMode(){return mode;}

    public int getPerlin() {return this.perlin;}

    public float getIntensity1() {return this.intensity1;}
    public float getIntensity2() {return this.intensity2;}
    public float getIntensity3() {return this.intensity3;}
    public ScreenshakeInstance setInt1(float i) {intensity1 = i;return this;}
    public ScreenshakeInstance setInt2(float i) {intensity1 = i;return this;}
    public ScreenshakeInstance setInt3(float i) {intensity1 = i;return this;}
    public ScreenshakeInstance setInt(Vec3d v) {
        intensity1 = (float) v.x;
        intensity2 = (float) v.y;
        intensity3 = (float) v.z;
        return this;
    }

    public ScreenshakeInstance setBaseDur(int m) {baseDuration = m;return this;}
    public ScreenshakeInstance setBaseInt1(float i) {Baseintensity1 = i;return this;}
    public ScreenshakeInstance setBaseInt2(float i) {Baseintensity1 = i;return this;}
    public ScreenshakeInstance setBaseInt3(float i) {Baseintensity1 = i;return this;}
    public ScreenshakeInstance setBases(Vec3d v,int basedur) {
        Baseintensity1 = (float) v.x;
        Baseintensity2 = (float) v.y;
        Baseintensity3 = (float) v.z;
        baseDuration = basedur;
        return this;
    }

    public float getBaseIntensity1() {return this.Baseintensity1;}
    public float getBaseIntensity2() {return this.Baseintensity2;}
    public float getBaseIntensity3() {return this.Baseintensity3;}
    public int getBaseDur() {return baseDuration;}

    public Vector3f getIntensity() {
        return new Vector3f(this.intensity1,this.intensity2,this.intensity3);
    }

    public float updateIntensity(Camera camera, Random random) {
        progress++;
        float percentage = (progress / (float) duration);
        if (mode == 1) {
            if (percentage >= 0.5f) {
                return MathHelper.lerp(intensityCurveEndEasing.ease(percentage - 0.5f, 0, 1, 0.5f), intensity2, intensity1);
            } else {
                return MathHelper.lerp(intensityCurveStartEasing.ease(percentage, 0, 1, 0.5f), intensity1, intensity2);
            }
        } else {
            return MathHelper.lerp(intensityCurveStartEasing.ease(percentage, 0, 1, 1), intensity1, intensity2);
        }
    }
}