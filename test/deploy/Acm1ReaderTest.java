package deploy;

import org.junit.Assert;
import org.junit.Test;
import sergpank.a.CommonTestData;

public class Acm1ReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        Acm1Reader reader = new Acm1Reader(getReader("samples/fileTree.acm1"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
