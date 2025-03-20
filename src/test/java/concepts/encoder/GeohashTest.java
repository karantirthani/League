package concepts.encoder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeohashTest {

    @Test
    public void encode() {
        String encode = Geohash.encode(12.971599, 77.594566, 9);
        Assert.assertEquals("tdr1v9kpc", encode);
    }
}