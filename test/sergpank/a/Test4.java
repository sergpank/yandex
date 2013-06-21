package sergpank.a;

import org.junit.Test;
import sergpank.a.reader.FindReader;
import sergpank.a.writer.Acm1Writer;

public class Test4 extends CommonTestData {

    @Test
    public void test()
            throws Exception {
        String input = "samples/test4in.find";
        String output = "samples/test4out.acm1";
        FindReader reader = new FindReader(getReader(input));
        Acm1Writer writer = new Acm1Writer(reader.read(), printStream);
        writer.write();
        verifyOutput(output);
    }
}
