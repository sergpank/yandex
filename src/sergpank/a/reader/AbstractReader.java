package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractReader {

    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected List<String> readFile(File file){
        List<String> data = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Unable to open file");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to read file");
        }
        return data;
    }


    public abstract FileTree read(String fileName);
}
