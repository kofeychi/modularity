package net.kofeychi.Modularity.logger;

import net.kofeychi.Modularity.base.Modularity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

import static net.kofeychi.Modularity.logger.ModularityLogger.Util.*;

public class ModularityLogger {
    public Logger LOGGER;

    // MODULARITY ADDON INFO
    public static String ID = "ModularityLogging";
    public static String VERSION = "V1.0 BETA";
    public static String MainMethod = "Setup";
    public static void Setup(Boolean n){}

    public ModularityLogger(String name){
        LOGGER = LoggerFactory.getLogger(name);
    }

    /**
     *  This function makes the start and end text that lines up to the end.
     * @param Messages Input the message in type of arraylist.
     */
    public void LogInOut(ArrayList<String> Messages,LogTypes type){
        if (type == LogTypes.INFO) {LOGGER.info(makeend(findlongest(Messages)));} else
        if (type == LogTypes.ERROR) {LOGGER.error(makeend(findlongest(Messages)));} else
        if (type == LogTypes.WARN) {LOGGER.warn(makeend(findlongest(Messages)));} else
        if (type == LogTypes.DEBUG) {LOGGER.debug(makeend(findlongest(Messages)));} else
        if (type == LogTypes.TRACE) {LOGGER.trace(makeend(findlongest(Messages)));} else {
            LOGGER.error(" LOG TYPE NOT SPECIFIED,ERROR. ");
        }
    }
    /**
     *  This function prints the contents
     * @param MSG Input the message contents.
     */
    public void LogContent(String MSG,LogTypes type){
        //LOGGER.info("|| "+MSG+" ||");
        if (type == LogTypes.INFO) {LOGGER.info("|| "+MSG+" ||");} else
        if (type == LogTypes.ERROR) {LOGGER.error("|| "+MSG+" ||");} else
        if (type == LogTypes.WARN) {LOGGER.warn("|| "+MSG+" ||");} else
        if (type == LogTypes.DEBUG) {LOGGER.debug("|| "+MSG+" ||");} else
        if (type == LogTypes.TRACE) {LOGGER.trace("|| "+MSG+" ||");} else {
            LOGGER.error(" LOG TYPE NOT SPECIFIED,ERROR. ");
        }
    }
    /**
     *  This function fully prints the message in style
     * @param Messages Input the message full in type of arraylist.
     */
    public void LogSMTH(ArrayList<String> Messages,LogTypes type){
        LogInOut(Messages,type);
        int i = 0;
        for(Iterator<String> var2 = Messages.iterator(); var2.hasNext(); ++i) {
            String var = (String) var2.next();
            int lenght = var.length();
            int untilEnd = findlongest(Messages)-lenght;
            LogContent(var+counttoend(untilEnd),type);
        }
        LogInOut(Messages,type);
    }

    public static class Util {
        public static String counttoend(int value) {
            String out = "";
            for (int i = 0; i < value; ++i) {
                out = out + " ";
            }
            return out;
        }

        public static String makeend(int value) {
            value = value + 4;
            String out = "*";
            for (int i = 0; i < value; ++i) {
                out = out + "=";
            }
            out = out + "*";
            return out;
        }

        public static int findlongest(ArrayList<String> list) {
            return list.stream().mapToInt(String::length)
                    .max()
                    .orElse(0);
        }
    }
}