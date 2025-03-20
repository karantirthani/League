package concepts.encoder;

public class Geohash {
    private static final String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";


    static String encode(double lat, double lon, int precision) {
        double latMin = -90;
        double latMax = 90;
        double longMin = -180;
        double longMax = 180;
        boolean evenBit = true;
        int index = 0;
        int bit =0;
        StringBuilder geoHash = new StringBuilder();
        while (geoHash.length() < precision) {
            if (evenBit) {
                double longMid = (longMin + longMax)/2;
                if (lon > longMid) {
                    index = index*2 + 1;
                    longMin = longMid;
                } else {
                    index = index*2;
                    longMax = longMid;
                }
            } else {
                double latMid = (latMin + latMax)/2;
                if (lat > latMid) {
                    index = index*2 + 1;
                    latMin = latMid;
                } else {
                    index = index*2;
                    latMax = latMid;
                }
            }
            evenBit = !evenBit;
            bit++;
            if (bit == 5) {
                geoHash.append(base32.charAt(index));
                bit = 0;
                index = 0;
            }
        }
        return geoHash.toString();
    }
}
