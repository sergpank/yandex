package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractReader {

    protected Logger logger = Logger.getLogger(this.getClass().getName());
    int nodeNumber = -1;
    private BufferedReader reader;

    protected AbstractReader(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    protected String readLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Read error");
        }
        return line;
    }

    public abstract FileTree read();

    protected int getNodesNumber() {
        if (nodeNumber == -1) {
            nodeNumber = Integer.parseInt(readLine());
        }
        return nodeNumber;
    }

    protected SystemNode createNode(String nodeString) {
        String[] nodeData = nodeString.split(" ");
        return new SystemNode(nodeData[0], Integer.parseInt(nodeData[1]));
    }
}
