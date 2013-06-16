package sergpank.a;

public class FileNode extends Node {

    private DirectoryNode parent;

    public FileNode(String fileName, DirectoryNode parent) {
        this.parent = parent;
        this.name = fileName;
    }

    @Override
    public DirectoryNode getParent() {
        return parent;
    }

    @Override
    public NodeType getType() {
        return NodeType.FILE;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FileNode fileNode = (FileNode) o;

        if (name != null ? !name.equals(fileNode.name) : fileNode.name != null) return false;
        if (parent != null ? !parent.equals(fileNode.parent) : fileNode.parent != null) return false;

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
