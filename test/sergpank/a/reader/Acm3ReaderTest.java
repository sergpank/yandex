package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.CommonTestData;
import sergpank.a.filesystem.FileTree;

public class Acm3ReaderTest
        extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new Acm3Reader(getReader("samples/fileTree.acm3"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
