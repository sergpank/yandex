package sergpank.a.writer;

import org.junit.Test;
import sergpank.a.CommonTestData;
import sergpank.a.filesystem.FileTree;
import sergpank.a.reader.XmlReader;

public class XmlWriterTest
        extends CommonTestData {

    @Test
    public void testWrite()
            throws Exception {
        String fileName = "samples/fileTree.xml";
        XmlReader reader = new XmlReader(getReader(fileName));
        FileTree tree = reader.read();
        new XmlWriter(tree, printStream).write();
        verifyOutput(fileName);
    }
}
