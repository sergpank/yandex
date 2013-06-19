package sergpank.a.writer;

import org.junit.Test;
import sergpank.CommonTestData;
import sergpank.a.filesystem.FileTree;
import sergpank.a.reader.Acm3Reader;

public class Acm3WriterTest extends CommonTestData {

    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.acm3";
        Acm3Reader acm3Reader = new Acm3Reader(getReader(fileName));
        FileTree tree = acm3Reader.read();
        new Acm3Writer(tree, printStream).write();
        verifyOutput(fileName);
    }
}
