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
import java.util.Arrays;
import java.util.List;

public class CODECS {
    public static class ShakeCODEC {
        public static String PackShake(int dur, float i1, float i2, float i3, String e1, String e2, int p, int mode,int ir,int ip,float pS) {
            List<String> strList = Arrays.asList(
                    String.valueOf(dur),
                    String.valueOf(i1),
                    String.valueOf(i2),
                    String.valueOf(i3),
                    e1,
                    e2,
                    String.valueOf(p),
                    String.valueOf(mode),
                    String.valueOf(ir),
                    String.valueOf(ip),
                    String.valueOf(pS)
            );
            return String.join(":", strList);
        }

        public static String[] UnPackShake(String base) {
            return base.split(":");
        }

        public static String PackPosShake(int dur, double x, double y, double z, float falloffDistance, float maxDistance, String falloffEasing, float i1, float i2, float i3, String e1, String e2, int p, int mode,int ir,int ip,float pS) {
            List<String> strList = Arrays.asList(
                    String.valueOf(dur),
                    String.valueOf(x),
                    String.valueOf(y),
                    String.valueOf(z),
                    String.valueOf(falloffDistance),
                    String.valueOf(maxDistance),
                    falloffEasing,
                    String.valueOf(i1),
                    String.valueOf(i2),
                    String.valueOf(i3),
                    e1,
                    e2,
                    String.valueOf(p),
                    String.valueOf(mode),
                    String.valueOf(ir),
                    String.valueOf(ip),
                    String.valueOf(pS)
            );
            return String.join(":", strList);
        }

        public static String[] UnPackPosShake(String base) {
            return base.split(":");
        }
    }
}
