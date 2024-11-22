package net.kofeychi.Modularity.ScreenShake;

import net.kofeychi.Modularity.Util.Easing;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.joml.Vector3f;

public class PositionedScreenshakeInstance extends ScreenshakeInstance {
    public final Vec3d position;
    public float falloffDistance,BasefalloffDistance;
    public float maxDistance,BasemaxDistance;
    public final Easing falloffEasing;

    //TODO: make falloff affect duration; the further away a player is the less the screenshake lasts
    public PositionedScreenshakeInstance(int duration,int perlin, Vec3d position, float falloffDistance, float maxDistance, Easing falloffEasing,int mod) {
        super(duration,perlin,mod);
        this.position = position;
        this.falloffDistance = falloffDistance;
        this.maxDistance = maxDistance;
        this.falloffEasing = falloffEasing;
    }
    public PositionedScreenshakeInstance setFal(float f) {falloffDistance = f;return this;}
    public PositionedScreenshakeInstance setMax(float f) {maxDistance = f;return this;}
    public float getFal() {return falloffDistance;}
    public float getMax() {return maxDistance;}
    public PositionedScreenshakeInstance setBaseFal(float f) {BasefalloffDistance = f;return this;}
    public PositionedScreenshakeInstance setBaseMax(float f) {BasemaxDistance = f;return this;}
    public float getBaseFal() {return BasefalloffDistance;}
    public float getBaseMax() {return BasemaxDistance;}

    @Override
    public float updateIntensity(Camera camera, Random random) {
        float intensity = super.updateIntensity(camera, random);
        float distance = (float) position.distanceTo(camera.getPos());
        if (distance > maxDistance) {
            return 0;
        }
        float distanceMultiplier = 1;
        if (distance > falloffDistance) {
            float remaining = maxDistance - falloffDistance;
            float current = distance - falloffDistance;
            distanceMultiplier = 1 - current / remaining;
        }
        //Vector3f lookDirection = camera.getRotation().getEulerAnglesXYZ(new Vector3f(1,0,0));
        Vector3f lookDirection = camera.getHorizontalPlane();
        Vec3d directionToScreenshake = position.subtract(camera.getPos()).normalize();
        float angle = Math.max(0, lookDirection.dot(new Vector3f((float) directionToScreenshake.x, (float) directionToScreenshake.y, (float) directionToScreenshake.z)));
        return ((intensity * distanceMultiplier) + (intensity * angle)) * 0.5f;
    }
}