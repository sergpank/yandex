package sergpank.a;

import org.junit.Test;
import sergpank.a.reader.FindReader;
import sergpank.a.writer.Acm3Writer;

public class Test6
        extends CommonTestData{

    @Test
    public void test()
            throws Exception {
        String input = "samples/test6in.find";
        String output = "samples/test6out.acm3";
        FindReader reader = new FindReader(getReader(input));
        Acm3Writer writer = new Acm3Writer(reader.read(), printStream);
        writer.write();
        verifyOutput(output);
    }
}
