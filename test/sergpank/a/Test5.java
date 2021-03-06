package sergpank.a;

import org.junit.Test;
import sergpank.a.reader.FindReader;
import sergpank.a.writer.Acm2Writer;

public class Test5 extends CommonTestData{

    @Test
    public void test()
            throws Exception {
        String input = "samples/test5in.find";
        String output = "samples/test5out.acm2";
        FindReader reader = new FindReader(getReader(input));
        Acm2Writer writer = new Acm2Writer(reader.read(), printStream);
        writer.write();
        verifyOutput(output);
    }
}
