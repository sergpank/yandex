package sergpank.a;

import org.junit.Assert;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonTestData {

    ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
    protected PrintStream printStream = new PrintStream(byteArrayStream);

    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected Reader getReader(final String fileName) {
        Reader reader = null;
        try {
            reader = new FileReader(new File(fileName));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Unable to open file " + fileName);
        }
        return reader;
    }

    protected void refreshStreams() {
        byteArrayStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayStream);
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
        verifyOutput("", fileName);
    }

    protected void verifyOutput(String message, String fileName) throws IOException {
        String fileString = fileToString(fileName);
        Assert.assertEquals(message, fileString, byteArrayStream.toString());
        byteArrayStream = new ByteArrayOutputStream();
    }

    protected String fileToString(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
