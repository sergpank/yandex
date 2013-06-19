package sergpank.a.reader;

import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

public class Acm2Reader extends AbstractReader {

    Map<Integer, SystemNode> nodeMap = new LinkedHashMap<Integer, SystemNode>();

    public Acm2Reader(Reader reader) {
        super(reader);
    }

    @Override
    public FileTree read() {
        FileTree tree = new FileTree();

        SystemNode rootNode = growTree(tree);
        tree.setRootNode(rootNode);

        return tree;
    }

    private SystemNode growTree(FileTree tree) {
        readNodes();
        SystemNode rootNode = connectNodes(tree);
        return rootNode;
    }

    private void readNodes() {
        for(int i = 1; i <= getNodesNumber(); i++){
            SystemNode node = createNode(readLine());
            nodeMap.put(node.getId(), node);
        }
    }

    private SystemNode connectNodes(FileTree tree) {
        SystemNode rootNode = null;
        for(Entry<Integer, SystemNode> entry : nodeMap.entrySet()){
            int parentId = Integer.parseInt(readLine());
            if(parentId == -1){
                rootNode = entry.getValue();
            } else{
                tree.addChild(nodeMap.get(parentId), entry.getValue());
            }
        }
        return rootNode;
    }
}
