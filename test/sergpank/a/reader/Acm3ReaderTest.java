package sergpank.a.reader;

import java.io.File;

import junit.framework.Assert;
import org.junit.Test;

public class Acm3ReaderTest
        extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new Acm3Reader(new File("samples/fileTree.acm3"));
        Assert.assertEquals(expected, reader.read().getRootNode().toString());
    }
}
