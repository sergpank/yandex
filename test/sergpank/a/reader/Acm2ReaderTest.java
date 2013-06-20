package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.CommonTestData;
import sergpank.a.filesystem.FileTree;

public class Acm2ReaderTest
        extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new Acm2Reader(getReader("samples/fileTree.acm2"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
