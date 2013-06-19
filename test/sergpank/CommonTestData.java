package sergpank;

import org.junit.Assert;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonTestData {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Before
    public void setUpStream(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }


    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected Reader getReader(final String fileName){
        Reader reader = null;
        try {
            reader = new FileReader(new File(fileName));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Unable to open file " + fileName);
        }
        return reader;
    }

    protected String expected =
            ". 0\n" +
            "1 download_client.sh <- .\n" +
            "2 random1000_queries_sport.txt <- .\n" +
            "3 times.txt <- .\n" +
            "4 site <- .\n" +
            "5 site_kz_domains_random1000_2011-07-26.txt <- site <- .\n" +
            "6 site_ru_domains_top1000_2011-07-27.txt <- site <- .\n" +
            "7 site_by_domains_top1000_2011-07-27.txt <- site <- .\n" +
            "8 kz <- site <- .\n" +
            "9 random1000 <- kz <- site <- .\n" +
            "10 site_kz_random1000_2011-07-16.xml <- random1000 <- kz <- site <- .\n" +
            "11 ru <- site <- .\n" +
            "12 random1000 <- ru <- site <- .\n";

    protected void verifyOutput(String fileName) throws IOException {
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
