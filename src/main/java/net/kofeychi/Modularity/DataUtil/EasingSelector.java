package net.kofeychi.Modularity.DataUtil;
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
import net.kofeychi.Modularity.Util.Easing;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;

import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("All")
@MethodsReturnNonnullByDefault
public class EasingSelector {
    public static Easing EasingSelectorGet(String arg) {
        return RequireNonNullUtils.RequireNonNullOrDef(EasingSelector.EasingValues().get(arg),Easing.LINEAR);
    }
    public static final String[] EStringValues = EasingValues().keySet().toArray(new String[0]);
    public static Map<String, Easing> EasingValues(){
        Map<String, Easing> EasingValues = new HashMap<>();
        EasingValues.put("LINEAR",Easing.LINEAR);
        //cubic
        EasingValues.put("CUBIC_IN",Easing.CUBIC_IN);
        EasingValues.put("CUBIC_IN_OUT",Easing.CUBIC_IN_OUT);
        EasingValues.put("CUBIC_OUT",Easing.CUBIC_OUT);
        //circ
        EasingValues.put("CIRC_IN",Easing.CIRC_IN);
        EasingValues.put("CIRC_IN_OUT",Easing.CIRC_IN_OUT);
        EasingValues.put("CIRC_OUT",Easing.CIRC_OUT);
        //back
        EasingValues.put("BACK_IN",Easing.BACK_IN);
        EasingValues.put("BACK_IN_OUT",Easing.BACK_IN_OUT);
        EasingValues.put("BACK_OUT",Easing.BACK_OUT);
        //bounce
        EasingValues.put("BOUNCE_IN",Easing.BOUNCE_IN);
        EasingValues.put("BOUNCE_IN_OUT",Easing.BOUNCE_IN_OUT);
        EasingValues.put("BOUNCE_OUT",Easing.BOUNCE_OUT);
        //expo
        EasingValues.put("EXPO_IN",Easing.EXPO_IN);
        EasingValues.put("EXPO_IN_OUT",Easing.EXPO_IN_OUT);
        EasingValues.put("EXPO_OUT",Easing.EXPO_OUT);
        //quad
        EasingValues.put("QUAD_IN",Easing.QUAD_IN);
        EasingValues.put("QUAD_IN_OUT",Easing.QUAD_IN_OUT);
        EasingValues.put("QUAD_OUT",Easing.QUAD_OUT);
        //quartic
        EasingValues.put("QUARTIC_IN",Easing.QUARTIC_IN);
        EasingValues.put("QUARTIC_IN_OUT",Easing.QUARTIC_IN_OUT);
        EasingValues.put("QUARTIC_OUT",Easing.QUARTIC_OUT);
        //quintic
        EasingValues.put("QUINTIC_IN",Easing.QUINTIC_IN);
        EasingValues.put("QUINTIC_IN_OUT",Easing.QUINTIC_IN_OUT);
        EasingValues.put("QUINTIC_OUT",Easing.QUINTIC_OUT);
        //sine
        EasingValues.put("SINE_IN",Easing.SINE_IN);
        EasingValues.put("SINE_IN_OUT",Easing.SINE_IN_OUT);
        EasingValues.put("SINE_OUT",Easing.SINE_OUT);
        return EasingValues;
    }
}
