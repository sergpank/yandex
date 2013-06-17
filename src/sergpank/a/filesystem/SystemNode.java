package sergpank.a.filesystem;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class SystemNode {

    protected int id;
    protected String name;
    private SystemNode parent;
    private List<SystemNode> childList;

    public SystemNode(String name, int id) {
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
        child.setParent(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemNode that = (SystemNode) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
        StringBuffer line = new StringBuffer(MessageFormat.format("{0} {1}", highNode.getId(), highNode.getName()));
        SystemNode parent = highNode.getParent();
        while(parent != null){
            line.append(" <- ");
            line.append(parent.getName());
            parent = parent.getParent();
        }
        line.append('\n');
        for (SystemNode node : highNode.getChildren()) {
            line.append(toString(node));
        }
        return line;
    }
}
