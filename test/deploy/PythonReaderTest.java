package deploy;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.CommonTestData;


public class PythonReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        PythonReader reader = new PythonReader(getReader("samples/fileTree.python"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
