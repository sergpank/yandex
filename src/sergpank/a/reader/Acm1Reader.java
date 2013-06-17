package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class Acm1Reader extends AbstractReader {

    private Map<Integer, SystemNode> nodeMap = new LinkedHashMap<Integer, SystemNode>();

    protected Acm1Reader(File file) {
        super(file);
    }

    @Override
    public FileTree read() {

        FileTree tree = new FileTree();
        int nodeNumber = getNodeNumber();
        SystemNode rootNode = createNode(readLine().split(" "));
        tree.setRootNode(rootNode);
        nodeMap.put(rootNode.getId(), rootNode);

        growTree(tree, nodeNumber);

        return tree;
    }

    private void growTree(FileTree tree, int nodeNumber) {
        fillNodeMap(nodeNumber);

        for(int key : nodeMap.keySet()){
            String[] split = readLine().split(" ");
            SystemNode currentParent = nodeMap.get(key);
            for(int i = 1; i <= Integer.parseInt(split[0]); i++){
                SystemNode currentChild = nodeMap.get(Integer.parseInt(split[i]));
                currentParent.addChild(currentChild);
                currentChild.setParent(currentParent);
            }
        }
    }

    private void fillNodeMap(int nodeNumber) {
        for(int i = 1; i < nodeNumber; i++){
            SystemNode node = createNode(readLine().split(" "));
            nodeMap.put(node.getId(), node);
        }
    }
}
