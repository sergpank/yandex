package deploy;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.CommonTestData;


public class XmlReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        XmlReader reader = new XmlReader(getReader("samples/fileTree.xml"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
