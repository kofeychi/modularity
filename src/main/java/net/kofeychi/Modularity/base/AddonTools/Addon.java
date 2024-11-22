package net.kofeychi.Modularity.base.AddonTools;

import net.kofeychi.Modularity.logger.LogTypes;
import net.kofeychi.Modularity.logger.ModularityLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Addon {
    public Class Target;
    public String ID;
    public String VERSION;
    public Method SETUP_METHOD;
    private ModularityLogger LOGGER = new ModularityLogger("modularity");;
    private static ArrayList<String> ID_E = new ArrayList<>();
    private static ArrayList<String> V_E = new ArrayList<>();
    private static ArrayList<String> M_E = new ArrayList<>();
    private static void initMSGS(){
        ID_E.add("No ID Field found for addon.");
        V_E.add("No VERSION Field found for addon.");
        M_E.add("No METHOD Field found for addon: ");
    }
    public Addon(Class target) throws NoSuchFieldException, IllegalAccessException {
        initMSGS();
        Target = target;
        try {
            ID = (String) Target.getDeclaredField("ID").get(null);
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            LOGGER.LogSMTH(ID_E, LogTypes.WARN);
        }
        try {
            VERSION = (String) Target.getDeclaredField("VERSION").get(null);
        } catch (NoSuchFieldException | IllegalAccessException exc) {
            LOGGER.LogSMTH(V_E, LogTypes.WARN);
        }
        try {
            SETUP_METHOD = Target.getDeclaredMethod((String) Target.getDeclaredField("MainMethod").get(null), Boolean.class);
        } catch (NoSuchMethodException exc) {
            SETUP_METHOD = null;
            ArrayList<String> M_EE = M_E;
            M_EE.add(ID+" "+VERSION);
            LOGGER.LogSMTH(M_EE, LogTypes.WARN);
        }
    }
    public String getID(){return ID;}
    public String getVERSION(){return VERSION;}
    public Method getMethod(){return SETUP_METHOD;}
}
