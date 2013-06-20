package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;

public class PythonWriterTest extends CommonTestData {

    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.python";
        PythonReader reader = new PythonReader(getReader(fileName));
        FileTree tree = reader.read();
        PythonWriter writer = new PythonWriter(tree, printStream);
        writer.write();
        verifyOutput(fileName);
    }
}
