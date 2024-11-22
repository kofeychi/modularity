package net.kofeychi.Modularity.base.AddonTools;

import net.fabricmc.loader.api.FabricLoader;
import net.kofeychi.Modularity.base.Modularity;
import net.kofeychi.Modularity.logger.LogTypes;
import net.kofeychi.Modularity.logger.ModularityLogger;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
@SuppressWarnings("All")
public class Loader {
    // MODULARITY ADDON LOADER MAIN INFO
    public static String ID = "ModularityLoader";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}
    // MODULARITY ADDON LOADER MAIN INFO

    // MODULARITY MAIN INFO
    public static ArrayList<String> Authors = new ArrayList<>();
    public static ArrayList<String> CodeFrom = new ArrayList<>();
    // MODULARITY MAIN INFO

    // MODULARITY LOADER
    public static ArrayList<Addon> AddonList = new ArrayList<>();
    public static ArrayList<String> AddonListNames = new ArrayList<>();
    public static ModularityLogger prettylog = new ModularityLogger("Modularity");
    private static String Lmsg = "   |>-";
    /**
     *  PLEASE DO NOT USE THIS.
     */
    public static void InitAddons() throws InvocationTargetException, IllegalAccessException {
        int i = 0;
        for(Iterator<Addon> var2 = Loader.AddonList.iterator(); var2.hasNext(); ++i) {
            Addon var = (Addon) var2.next();
            var.getMethod().invoke(null, Modularity.isDevelopment);
        }
        int j = 0;
        for(Iterator<Addon> var2 = Loader.AddonList.iterator(); var2.hasNext(); ++j) {
            Addon var = (Addon) var2.next();
            AddonListNames.add(Lmsg+" "+var.getID()+" "+var.getVERSION()+" Loader: "+var.getMethod().getName());
        }
    }
    /**
     *  PLEASE DO NOT USE THIS.
     */
    private static String mixin(){
        String mixin = "null";
        try {
            mixin = (String) Class.forName("org.spongepowered.asm.launch.MixinBootstrap").getDeclaredField("VERSION").get(null);
        } catch (Throwable ignored) {
        }
        return mixin;
    }
    /**
     *  PLEASE DO NOT USE THIS.
     */
    private static String intro() {
        List<String> text = new ArrayList<>();
        Random random = new Random();
        text.add("UwU");
        text.add(":3");
        text.add("MEOW");
        text.add("prrrr");
        return text.get(random.nextInt(0, text.size()));
    }
    /**
     *  PLEASE DO NOT USE THIS.
     */
    public static void INIT(){
        Authors.add(Lmsg+" "+"Kofeychi");
        CodeFrom.add(Lmsg+" "+"LodestoneLib");
        CodeFrom.add(Lmsg+" "+"FluffyFur");
        try {
            InitAddons();
            LogInfo();
        } catch (InvocationTargetException | IllegalAccessException e) {
            ArrayList<String> err = new ArrayList<>();
            err.add("Something gone wrong! exc: "+e.getCause()+" "+Arrays.toString(e.getStackTrace()));
            prettylog.LogSMTH(err,LogTypes.ERROR);
        }
    }
    private static void LogInfo(){
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Total Loaded Addons: "+AddonListNames.size());
        msg.addAll(AddonListNames);
        msg.add("Minecraft: "+ FabricLoader.getInstance().getModContainer("minecraft").get().getMetadata().getVersion().getFriendlyString());
        msg.add("Mixin: "+mixin());
        msg.add("OS: " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " (" + System.getProperty("os.arch") + ")");
        msg.add("Java: " + System.getProperty("java.version") + " (" + System.getProperty("java.vendor") + ")");
        msg.add("Authors:");
        msg.addAll(Authors);
        msg.add("Parts of code used from:");
        msg.addAll(CodeFrom);
        msg.add(intro());
        prettylog.LogSMTH(msg, LogTypes.INFO);
    }
}
