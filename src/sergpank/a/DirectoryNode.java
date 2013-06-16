package sergpank.a;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode extends Node {
    private List<Node> nodeList;


    public DirectoryNode() {
        this(new ArrayList<Node>());
    }

    public DirectoryNode(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public NodeType getType() {
        return NodeType.DIRECTORY;
    }

    public List<Node> getNodes(){
        return nodeList;
    }

    public void addNode(Node node){
        nodeList.add(node);
    }
}
