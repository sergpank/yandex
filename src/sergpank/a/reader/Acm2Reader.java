package sergpank.a.reader;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

public class Acm2Reader extends AbstractReader {

    Map<Integer, SystemNode> nodeMap = new LinkedHashMap<Integer, SystemNode>();

    protected Acm2Reader(File file) {
        super(file);
    }


    @Override
    public sergpank.a.filesystem.FileTree read() {
        FileTree tree = new FileTree();

        SystemNode rootNode = growTree();
        tree.setRootNode(rootNode);

        return tree;
    }


    private SystemNode growTree() {
        readNodes();
        SystemNode rootNode = connectNodes();
        return rootNode;
    }


    private void readNodes() {
        for(int i = 1; i <= getNodesNumber(); i++){
            SystemNode node = createNode(readLine());
            nodeMap.put(node.getId(), node);
        }
    }


    private SystemNode connectNodes() {
        SystemNode rootNode = null;
        for(Entry<Integer, SystemNode> entry : nodeMap.entrySet()){
            int parentId = Integer.parseInt(readLine());
            if(parentId == -1){
                rootNode = entry.getValue();
            } else{
                SystemNode parent = nodeMap.get(parentId);
                entry.getValue().setParent(parent);
                parent.addChild(entry.getValue());
            }
        }
        return rootNode;
    }
}
