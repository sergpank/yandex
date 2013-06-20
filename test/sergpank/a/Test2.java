package sergpank.a;

import org.junit.Test;
import sergpank.a.reader.FindReader;
import sergpank.a.writer.FindWriter;

public class Test2 extends CommonTestData{

    @Test
    public void test2() throws Exception {
        String fileName = "samples/test2.find";
        FindReader reader = new FindReader(getReader(fileName));
        FindWriter writer = new FindWriter(reader.read(), printStream);
        writer.write();
        verifyOutput(fileName);
    }
}
