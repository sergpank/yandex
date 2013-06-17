package sergpank.a.filesystem;

import java.text.MessageFormat;
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


    @Override
    public String toString() {
        StringBuffer line = new StringBuffer(MessageFormat.format("{0} {1}\n", this.getName(), this.getId()));
        for (SystemNode node : this.getChildren()) {
            line.append(toString(node));
        }
        return line.toString();
    }

    private StringBuffer toString(SystemNode highNode) {
        StringBuffer line = new StringBuffer(MessageFormat.format("{0} {1}\n",highNode.getName(), highNode.getId()));
        for (SystemNode node : highNode.getChildren()) {
            line.append(toString(node));
        }
        return line;
    }
}
