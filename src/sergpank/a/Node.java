package sergpank.a;

public abstract class Node {

    protected String name;

    public String getName(){
        return name;
    }

    public abstract DirectoryNode getParent();

    public abstract NodeType getType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (name != null ? !name.equals(node.name) : node.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
