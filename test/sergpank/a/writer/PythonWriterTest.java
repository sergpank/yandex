package sergpank.a.writer;

import org.junit.Test;
import sergpank.CommonTestData;
import sergpank.a.filesystem.FileTree;
import sergpank.a.reader.PythonReader;

public class PythonWriterTest extends CommonTestData {

    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.python";
        PythonReader reader = new PythonReader(getReader(fileName));
        FileTree tree = reader.read();
        PythonWriter writer = new PythonWriter(tree);
        writer.write();
        verifyOutput(fileName);
    }
}
