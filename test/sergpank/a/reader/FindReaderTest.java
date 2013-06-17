package sergpank.a.reader;


import org.junit.Assert;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;

public class FindReaderTest extends CommonTestData {

    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new FindReader();
        FileTree actual = reader.read("samples/fileTree.find");
        Assert.assertEquals(expected, actual.getRootNode().toString());
    }
}
