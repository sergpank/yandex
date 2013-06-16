package sergpank.a.filesystem;

import java.util.ArrayList;
import java.util.List;

public class SystemNode {

    protected int id;
    protected String name;
    private SystemNode parent;
    private List<SystemNode> childList;

    public SystemNode(String name) {
        this(-1, name);
    }

    public SystemNode(int id, String name) {
        this.id = id;
        this.name = name;
        childList = new ArrayList<SystemNode>();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public SystemNode getParent(){
        return parent;
    }

    public void setParent(SystemNode parent) {
        this.parent = parent;
    }

    public List<SystemNode> getChildren() {
        return childList;
    }

    public void addChild(SystemNode child){
        childList.add(child);
    }
}
