package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;


public class FindWriterTest extends CommonTestData {

    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.find";
        FindReader reader = new FindReader(getReader(fileName));
        FileTree tree = reader.read();
        FindWriter writer = new FindWriter(tree, printStream);
        writer.write();

        verifyOutput(fileName);
    }
}
