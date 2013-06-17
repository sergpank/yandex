package sergpank.a.reader;


import org.junit.Assert;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;

import java.io.File;

public class FindReaderTest extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new FindReader(new File("samples/fileTree.find"));
        FileTree actual = reader.read();
        Assert.assertEquals(expected, actual.getRootNode().toString());
    }
}
