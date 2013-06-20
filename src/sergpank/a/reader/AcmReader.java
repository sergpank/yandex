package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AcmReader extends AbstractReader {

    protected Map<Integer, SystemNode> nodeMap = new LinkedHashMap<Integer, SystemNode>();

    private int lineCounter;
    private int linesNumber;

    protected AcmReader(Reader reader) {
        super(reader);
    }

    @Override
    protected String readLine() throws IOException {
        String line = null;
        if (lineCounter == 0) {
            line = reader.readLine();
            linesNumber = Integer.parseInt(line) * 2 + 1;
            ++lineCounter;
        } else if (lineCounter <= linesNumber) {
            line = reader.readLine();
            ++lineCounter;
        } else{
            reader.close();
        }
        return line;
    }

    @Override
    public FileTree read() throws IOException {
        return null;
    }

    protected void readNodes() throws IOException {
        for (int i = 1; i < getNodesNumber(); i++) {
            SystemNode node = createNode(readLine());
            nodeMap.put(node.getId(), node);
        }
    }
}
