package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;


public class Acm1WriterTest extends CommonTestData {
    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.acm1";
        Acm1Reader reader = new Acm1Reader(getReader(fileName));
        FileTree tree = reader.read();
        Acm1Writer writer = new Acm1Writer(tree, printStream);
        writer.write();
        verifyOutput(fileName);
    }
}
