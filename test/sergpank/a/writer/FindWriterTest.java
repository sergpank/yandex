package sergpank.a.writer;

import org.junit.Test;
import sergpank.a.filesystem.FileTree;
import sergpank.a.reader.CommonTestData;
import sergpank.a.reader.FindReader;

import java.io.File;

public class FindWriterTest extends CommonTestData {
    @Test
    public void testWrite() throws Exception {
        FindReader reader = new FindReader(new File("samples/fileTree.find"));
        FileTree tree = reader.read();
        FindWriter writer = new FindWriter(tree);
        writer.write();
    }
}
