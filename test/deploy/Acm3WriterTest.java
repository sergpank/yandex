package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;

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
