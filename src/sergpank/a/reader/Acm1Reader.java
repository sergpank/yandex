package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Acm1Reader
        extends AcmReader {

    private int lineCounter = 0;

    public Acm1Reader(Reader reader) {
        super(reader);
    }

    @Override
    public FileTree read() throws IOException {

        FileTree tree = new FileTree();
        setNodeNumber(readLine());

        SystemNode rootNode = createNode(readLine());
        tree.setRootNode(rootNode);

        nodeMap.put(rootNode.getId(), rootNode);

        growTree(tree);

        return tree;
    }


    private void growTree(FileTree tree) throws IOException {
        readNodes();
        connectNodes(tree);
    }


    private void connectNodes(FileTree tree) throws IOException {
        for (int key : nodeMap.keySet()) {
            String[] split = readLine().split(" ");
            SystemNode currentParent = nodeMap.get(key);
            for (int i = 1; i <= Integer.parseInt(split[0]); i++) {
                SystemNode currentChild = nodeMap.get(Integer.parseInt(split[i]));
                tree.addChild(currentParent, currentChild);
            }
        }
    }
}
