package sergpank.a.reader;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

public class FindReaderTest {


    private String expected;


    @Before
    public void setUp()
            throws Exception {
        expected = ". 0\n" +
                   "download_client.sh 1\n" +
                   "random1000_queries_sport.txt 2\n" +
                   "times.txt 3\n" +
                   "site 4\n" +
                   "site_kz_domains_random1000_2011-07-26.txt 5\n" +
                   "site_ru_domains_top1000_2011-07-27.txt 6\n" +
                   "site_by_domains_top1000_2011-07-27.txt 7\n" +
                   "kz 8\n" +
                   "random1000 9\n" +
                   "site_kz_random1000_2011-07-16.xml 10\n" +
                   "ru 11\n" +
                   "random1000 12\n";
    }


    @Test
    public void testRead()
            throws Exception {
        AbstractReader reader = new FindReader();
        FileTree actual = reader.read("samples/fileTree.find");
        Assert.assertEquals(expected, actual.getRootNode().toString());
    }
}
