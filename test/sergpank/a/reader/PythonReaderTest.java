package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;

import java.io.File;

public class PythonReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        PythonReader reader = new PythonReader(new File("samples/fileTree.python"));
        FileTree tree = reader.read();
        Assert.assertEquals(expected, tree.getRootNode().toString());
    }
}
