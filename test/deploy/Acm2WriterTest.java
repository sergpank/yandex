package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;


public class Acm2WriterTest extends CommonTestData {

    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.acm2";
        Acm2Reader acm2Reader = new Acm2Reader(getReader(fileName));
        FileTree tree = acm2Reader.read();
        new Acm2Writer(tree, printStream).write();
        verifyOutput(fileName);
    }
}
