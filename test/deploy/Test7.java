package deploy;

import org.junit.Test;
import sergpank.a.CommonTestData;

public class Test7
        extends CommonTestData{

    @Test
    public void test()
            throws Exception {
        String input = "samples/test7in.find";
        String output = "samples/test7out.xml";
        FindReader reader = new FindReader(getReader(input));
        XmlWriter writer = new XmlWriter(reader.read(), printStream);
        writer.write();
        verifyOutput(output);
    }
}
