package net.kofeychi.Modularity.Util;

import net.kofeychi.Modularity.base.Modularity;
import net.minecraft.util.Identifier;

public class IU {
    public static Identifier of(String name){return Identifier.of(Modularity.MODID,name);}
}
