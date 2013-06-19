package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Acm1Reader
        extends AbstractReader {

    private Map<Integer, SystemNode> nodeMap = new LinkedHashMap<Integer, SystemNode>();


    public Acm1Reader(Reader reader) {
        super(reader);
    }


    @Override
    public FileTree read() {

        FileTree tree = new FileTree();
        getNodesNumber();
        SystemNode rootNode = createNode(readLine());
        tree.setRootNode(rootNode);
        nodeMap.put(rootNode.getId(), rootNode);

        growTree(tree);

        return tree;
    }


    private void growTree(FileTree tree) {
        fillNodeMap();
        connectNodes(tree);
    }


    private void fillNodeMap() {
        for (int i = 1; i < getNodesNumber(); i++) {
            SystemNode node = createNode(readLine());
            nodeMap.put(node.getId(), node);
        }
    }


    private void connectNodes(FileTree tree) {
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
