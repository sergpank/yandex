package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Acm3Reader
        extends AcmReader {

    public Acm3Reader(Reader reader) {
        super(reader);
    }

    @Override
    public FileTree read() throws IOException {
        setNodeNumber(readLine());
        FileTree tree = new FileTree();

        SystemNode rootNode = growTree(tree);
        tree.setRootNode(rootNode);

        return tree;
    }

    private SystemNode growTree(FileTree tree) throws IOException {
        getNodesNumber();
        SystemNode rootNode = createNode(readLine());
        nodeMap.put(rootNode.getId(), rootNode);
        readNodes();
        connectNodes(tree);

        return rootNode;
    }

    private void connectNodes(FileTree tree) throws IOException {
        for (int i = 1; i < getNodesNumber(); i++) {
            String[] vertexId = readLine().split(" ");
            SystemNode parent = nodeMap.get(Integer.parseInt(vertexId[0]));
            SystemNode child = nodeMap.get(Integer.parseInt(vertexId[1]));
            tree.addChild(parent, child);
        }
    }
}
