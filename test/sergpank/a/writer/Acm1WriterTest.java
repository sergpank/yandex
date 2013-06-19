package sergpank.a.writer;

import org.junit.Test;
import sergpank.CommonTestData;
import sergpank.a.filesystem.FileTree;
import sergpank.a.reader.Acm1Reader;
import sergpank.a.reader.PythonReader;

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
