package sergpank.a.reader;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

public class Acm3Reader extends AbstractReader {

    private Map<Integer, SystemNode> nodeMap = new LinkedHashMap<Integer, SystemNode>();

    protected Acm3Reader(File file) {
        super(file);
    }


    @Override
    public FileTree read() {
        FileTree tree = new FileTree();

        SystemNode rootNode = growTree();
        tree.setRootNode(rootNode);

        return tree;
    }


    private SystemNode growTree() {
        getNodesNumber();
        SystemNode rootNode = createNode(readLine());
        nodeMap.put(rootNode.getId(), rootNode);
        readNodes();
        connectNodes();

        return rootNode;
    }


    private void readNodes() {
        for(int i = 1; i < getNodesNumber(); i++){
            SystemNode node = createNode(readLine());
            nodeMap.put(node.getId(), node);
        }
    }


    private void connectNodes() {
        for(int i = 1; i < getNodesNumber(); i++){
            String[] vertexId = readLine().split(" ");
            SystemNode parent = nodeMap.get(Integer.parseInt(vertexId[0]));
            SystemNode child = nodeMap.get(Integer.parseInt(vertexId[1]));
            parent.addChild(child);
            child.setParent(parent);
        }
    }
}
