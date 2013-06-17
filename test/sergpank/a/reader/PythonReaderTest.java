package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;

public class PythonReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        PythonReader reader = new PythonReader();
        FileTree tree = reader.read("samples/fileTree.python");
        Assert.assertEquals(expected, tree.getRootNode().toString());
    }
}
