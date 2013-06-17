package sergpank.a.reader;

import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;

import java.io.File;

public class Acm1ReaderTest extends CommonTestData {
    @Test
    public void testRead() throws Exception {
        Acm1Reader reader = new Acm1Reader(new File("samples/fileTree.acm1"));
        FileTree actual = reader.read();
        Assert.assertEquals(expected, actual.getRootNode().toString());
    }
}
