package sergpank.a.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FileTree {

    private SystemNode rootNode;
    private int nodeCount;

    public SystemNode getRootNode() {
        return rootNode;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setRootNode(SystemNode rootNode) {
        this.rootNode = rootNode;
        nodeCount++;
    }

    /**
     * add child to parent node
     * FIND format
     *
     * @param child
     * @param parents
     */
    public void addChild(SystemNode child, String[] parents) {
        if (parents != null) {
            SystemNode parentNode = findParentNode(new TreeSet<SystemNode>() {{
                add(rootNode);
            }}, parents);
            child.setParent(parentNode);
            parentNode.addChild(child);
            nodeCount++;
        }
    }

    private SystemNode findParentNode(Set<SystemNode> currentLevelNodes, String[] parents) {
        SystemNode parentNode = null;
        for(SystemNode node : currentLevelNodes){
            if(node.getName().equals(parents[0])){
                parentNode = node;
                break;
            }
        }
        if(parents.length > 1){
            int length = parents.length - 1;
            String[] restParents = new String[length];
            System.arraycopy(parents, 1, restParents, 0, length);
            parentNode = findParentNode(parentNode.getChildren(), restParents);
        }

        return parentNode;
    }

    /**
     * Add child to file tree
     * PYTHON format
     *
     * @param node
     * @param nodeStack
     */
    public void addChild(SystemNode node, List<SystemNode> nodeStack) {
        SystemNode parentNode = findParentNode(nodeStack);
        parentNode.addChild(node);
        nodeCount++;
    }

    private SystemNode findParentNode(List<SystemNode> nodeStack) {
        SystemNode parentNode = rootNode;
        for(int i = 1; i < nodeStack.size(); i++){
            SystemNode necessaryNode = nodeStack.get(i);
            for(SystemNode sn : parentNode.getChildren()){
                if(sn.equals(necessaryNode)){
                    parentNode = sn;
                }
            }
        }
        return parentNode;
    }

    public void addChild(SystemNode parent, SystemNode child) {
        parent.addChild(child);
        child.setParent(parent);
        nodeCount++;
    }
}
