package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.CommonTestData;
import sergpank.a.filesystem.FileTree;

public class XmlReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        XmlReader reader = new XmlReader(getReader("samples/fileTree.xml"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
