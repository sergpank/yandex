package sergpank.a;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode extends Node {

    private List<Node> nodeList;
    private DirectoryNode parent;

    public DirectoryNode(String directoryName, DirectoryNode parent) {
        this(directoryName, parent, new ArrayList<Node>());
    }

    public DirectoryNode(String directoryName, DirectoryNode parent, List<Node> nodeList) {
        this.name = directoryName;
        this.parent = parent;
        this.nodeList = nodeList;
    }

    @Override
    public DirectoryNode getParent() {
        return parent;
    }

    @Override
    public NodeType getType() {
        return NodeType.DIRECTORY;
    }

    public List<Node> getNodes(){
        return nodeList;
    }

    public void addChild(Node node){
        nodeList.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectoryNode)) return false;

        DirectoryNode that = (DirectoryNode) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
