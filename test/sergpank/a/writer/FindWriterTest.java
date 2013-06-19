package sergpank.a.writer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;
import sergpank.CommonTestData;
import sergpank.a.reader.FindReader;

import java.io.*;

public class FindWriterTest extends CommonTestData {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Before
    public void setUpStream(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void testWrite() throws Exception {
        String fileName = "samples/fileTree.find";
        FindReader reader = new FindReader(getReader(fileName));
        FileTree tree = reader.read();
        FindWriter writer = new FindWriter(tree);
        writer.write();

        verifyOutput(fileName);
    }

    private void verifyOutput(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder fileData = new StringBuilder();
        String line;
        while ( (line = reader.readLine()) != null ){
            fileData.append(line);
            fileData.append(System.getProperty("line.separator"));
        }
        Assert.assertEquals(fileData.toString(), byteArrayOutputStream.toString());
    }
}
