package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;

public class Test14 extends CommonTestData{

    @Test
    public void test14() throws Exception {
        String input = "samples/test14input.find";
        String output = "samples/test14output.acm1";
        FindReader reader = new FindReader(getReader(input));
        Acm1Writer writer = new Acm1Writer(reader.read(), printStream);
        writer.write();
        verifyOutput(output);
    }
}
