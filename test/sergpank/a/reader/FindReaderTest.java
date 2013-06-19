package sergpank.a.reader;


import org.junit.Assert;
import org.junit.Test;
import sergpank.CommonTestData;
import sergpank.a.filesystem.FileTree;

public class FindReaderTest extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new FindReader(getReader("samples/fileTree.find"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
        Assert.assertEquals("node count error", 13, tree.getNodeCount());
    }
}
