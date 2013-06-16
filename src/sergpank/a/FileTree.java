package sergpank.a;

public class FileTree {

    private DirectoryNode rootNode = new DirectoryNode("root", null);

    public DirectoryNode getRootNode() {
        return rootNode;
    }

    /**
     * add child to root node
     * @param child
     */
    public void addChild(Node child){
        addChild(child, null);
    }

    /**
     * add child to parent node
     * if parent == null -> add child to root node
     * @param child
     * @param parent
     */
    public void addChild(Node child, DirectoryNode parent){
        if(parent == null){
            rootNode.addChild(child);
        } else{
            parent.addChild(child);
        }
    }
}
