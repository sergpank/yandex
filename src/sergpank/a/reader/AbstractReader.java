package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public abstract class AbstractReader {

    private int nodeNumber = -1;
    protected BufferedReader reader;

    private int lineCounter;

    protected AbstractReader(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    protected String readLine() throws IOException {
        String line = null;
        if (lineCounter == 0) {
            line = reader.readLine();
            nodeNumber = Integer.parseInt(line);
            ++lineCounter;
        } else if (lineCounter <= nodeNumber) {
            line = reader.readLine();
            ++lineCounter;
        } else{
            reader.close();
        }
        return line;
    }

    public abstract FileTree read() throws IOException;

    protected int getNodesNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(String line) {
        this.nodeNumber = Integer.parseInt(line);
    }

    protected SystemNode createNode(String nodeString) {
        String[] nodeData = nodeString.split(" ");
        return new SystemNode(nodeData[0], Integer.parseInt(nodeData[1]));
    }
}
