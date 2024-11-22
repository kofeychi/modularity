package net.kofeychi.Modularity.Event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.ActionResult;

public class EventModule {
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityEvents";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n) {}
    // MODULARITY ADDON LOADER MAIN INFO
    public interface OnRenderCallback {
    }
}
