package sergpank.a.reader;

import java.io.File;

import junit.framework.Assert;
import org.junit.Test;

public class Acm2ReaderTest
        extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new Acm2Reader(new File("samples/fileTree.acm2"));
        Assert.assertEquals(expected, reader.read().getRootNode().toString());
    }
}
