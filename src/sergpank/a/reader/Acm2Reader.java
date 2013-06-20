package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.IOException;
import java.io.Reader;
import java.util.Map.Entry;

public class Acm2Reader
        extends AcmReader {

    public Acm2Reader(Reader reader) {
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
        readNodes();
        SystemNode rootNode = connectNodes(tree);
        return rootNode;
    }

    protected void readNodes() throws IOException {
        for(int i = 1; i <= getNodesNumber(); i++){
            SystemNode node = createNode(readLine());
            nodeMap.put(node.getId(), node);
        }
    }

    private SystemNode connectNodes(FileTree tree) throws IOException {
        SystemNode rootNode = null;
        for (Entry<Integer, SystemNode> entry : nodeMap.entrySet()) {
            int parentId = Integer.parseInt(readLine());
            if (parentId == -1) {
                rootNode = entry.getValue();
            } else {
                tree.addChild(nodeMap.get(parentId), entry.getValue());
            }
        }
        return rootNode;
    }
}
