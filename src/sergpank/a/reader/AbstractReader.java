package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractReader {

    protected Logger logger = Logger.getLogger(this.getClass().getName());
    private BufferedReader reader;

    protected AbstractReader(File file) {
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Unable to open file");
        }
    }

    protected String readLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to read file");
        }
        return line;
    }

    public abstract FileTree read();
}
