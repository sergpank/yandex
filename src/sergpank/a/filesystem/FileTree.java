package sergpank.a.filesystem;

import java.util.List;

public class FileTree {

    private SystemNode rootNode;

    public void setRootNode(SystemNode rootNode) {
        this.rootNode = rootNode;
    }

    public SystemNode getRootNode() {
        return rootNode;
    }

    /**
     * add child to parent node
     * if parent == null -> add child to root node
     * @param child
     * @param parents
     */
    public void addChild(SystemNode child, String[] parents){
        if(parents == null){
            rootNode = child;
        } else{
            SystemNode parentNode = findOrCreateParentNode(parents);
            child.setParent(parentNode);
            parentNode.addChild(child);
        }
    }

    private SystemNode findOrCreateParentNode(String[] parents) {
        SystemNode parentNode = rootNode;
        List<SystemNode> prevChildren = rootNode.getChildren();
        ParentLoop: for(String parentName : parents){
            for(int i = 0; i < prevChildren.size(); i++){
                SystemNode node = prevChildren.get(i);
                if(node.getName().equals(parentName)){
                    parentNode = node;
                    break ParentLoop;
                }
                SystemNode currentNode = new SystemNode(parentName);
                parentNode.addChild(currentNode);
                parentNode = currentNode;
            }
        }
        return parentNode;
    }
}
