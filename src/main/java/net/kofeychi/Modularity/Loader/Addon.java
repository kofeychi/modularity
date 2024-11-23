package net.kofeychi.Modularity.Loader;
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

import net.kofeychi.Modularity.logger.LogTypes;
import net.kofeychi.Modularity.logger.ModularityLogger;

import java.lang.reflect.Method;
import java.util.ArrayList;
@SuppressWarnings("Unsafe")
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
