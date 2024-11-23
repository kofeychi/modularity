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

import net.fabricmc.api.ModInitializer;
import net.kofeychi.Modularity.Loader.Addon;
import net.kofeychi.Modularity.Loader.Loader;
import net.kofeychi.Modularity.logger.LogTypes;
import net.kofeychi.Modularity.logger.ModularityLogger;

import java.util.ArrayList;

/**
 * Example of the Modularity Addon. PLEASE DONT USE IT LIKE THIS.
 * <p>
 * Addon base should impliment {@link ModInitializer Fabric mod initialiser} and be in the fabric.mod.json entrypoint!
 */
public class AddonExample implements ModInitializer {
    // MODULARITY ADDON LOADER MAIN INFO
    /**
     * String of the id of the addon.
     */
    public static String ID = "ModularityExamples";
    /**
     * String of the Version of the addon.
     */
    public static String VERSION = "DONT USE!";
    /**
     * String of the name of the initialiser of addon,PLEASE MAKE SURE IT EXISTS IN CURRENT CLASS WITH SPECIFIED NAME AND BOOLEAN!
     */
    public static String MainMethod = "Setup";
    /**
     * Example logger.
     */
    public static ModularityLogger modularityLogger = new ModularityLogger("ExampleAddon");
    /**
     * Example initialiser method that initialises with all addons and brings up in the Loading MainFrame
     */
    public static void Setup(Boolean n){
        ArrayList<String> msg = new ArrayList<>(); // My logging uses arraylists to show data,so idk.
        String dev = "Error?"; // init var
        if (n) dev = "Development mode!"; //get isDev
        if (!n) dev = "not in Development mode..";
        msg.add("Hayo! im initialised in "+dev); // add to the arraylist
        modularityLogger.LogSMTH(msg, LogTypes.INFO); // Print it!
    }

    /**
     *  This is where you say to loader that your mod is addon,you can just copy this but idk,leave the expression after catch just blank because it never happened to me?
     */
    @Override
    public void onInitialize() {
        try {
            Loader.AddonList.add(new Addon(AddonExample.class)); // Say to the loader that this is the addon
        } catch (NoSuchFieldException | IllegalAccessException e) { // If err,then this comes up.
            ArrayList<String> msg = new ArrayList<>();
            msg.add("Ohno! error");
            modularityLogger.LogSMTH(msg, LogTypes.ERROR);
        }
    }
    // MODULARITY ADDON LOADER MAIN INFO
}
