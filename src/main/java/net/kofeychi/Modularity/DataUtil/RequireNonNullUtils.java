package net.kofeychi.Modularity.DataUtil;

import net.kofeychi.Modularity.Util.Easing;

public class RequireNonNullUtils {
    public static Easing RequireNonNullOrDef(Easing var, Easing def) {
        if (var == null) {
            return def;
        }
        return var;
    }
}
