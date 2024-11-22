package net.kofeychi.Modularity.DataUtil;

import java.util.Arrays;
import java.util.List;

public class CODECS {
    public static class ShakeCODEC {
        public static String PackShake(int dur, float i1, float i2, float i3, String e1, String e2, int p, int mode,int ir,int ip) {
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
                    String.valueOf(ip)
            );
            return String.join(":", strList);
        }

        public static String[] UnPackShake(String base) {
            return base.split(":");
        }

        public static String PackPosShake(int dur, double x, double y, double z, float falloffDistance, float maxDistance, String falloffEasing, float i1, float i2, float i3, String e1, String e2, int p, int mode,int ir,int ip) {
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
                    String.valueOf(ip)
            );
            return String.join(":", strList);
        }

        public static String[] UnPackPosShake(String base) {
            return base.split(":");
        }
    }
}
