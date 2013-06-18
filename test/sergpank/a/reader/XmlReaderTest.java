package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;

import java.io.File;

public class XmlReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        XmlReader reader = new XmlReader(new File("samples/fileTree.xml"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
    }
}
