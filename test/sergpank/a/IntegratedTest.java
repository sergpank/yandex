package sergpank.a;


import junit.framework.Assert;
import org.junit.Test;
import sergpank.a.reader.AbstractReader;
import sergpank.a.reader.ReaderFactory;
import sergpank.a.writer.AbstractWriter;
import sergpank.a.writer.WriterFactory;

public class IntegratedTest extends CommonTestData{

    @Test
    public void integratedTest() throws Exception{
        String[] types = new String[] {"find", "python", "acm1", "acm2", "acm3", "xml"};
        String[] files = new String[] {"samples/fileTree.find",
                                       "samples/fileTree.python",
                                       "samples/fileTree.acm1",
                                       "samples/fileTree.acm2",
                                       "samples/fileTree.acm3",
                                       "samples/fileTree.xml",};

        for(int i = 0; i < types.length; i++){
            for(int j = 0; j < types.length; j++){
                AbstractReader reader = ReaderFactory.createReader(types[i], getReader(files[i]));
                AbstractWriter writer = WriterFactory.createWriter(types[j], reader.read(), printStream);
                writer.write();
                verifyOutput(types[i] + " -> " + types[j], files[j]);
                refreshStreams();
            }
        }
    }
}
