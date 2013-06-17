package sergpank.a.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileTree {

    private SystemNode rootNode;

    public SystemNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(SystemNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * add child to parent node
     * if parent == null -> add child to root node
     *
     * @param child
     * @param parents
     */
    public void addChild(SystemNode child, String[] parents) {
        if (parents != null) {
            SystemNode parentNode = findParentNode(new ArrayList<SystemNode>() {{
                add(rootNode);
            }}, parents);
            child.setParent(parentNode);
            parentNode.addChild(child);
        }
    }

    private SystemNode findParentNode(List<SystemNode> currentLevelNodes, String[] parents) {
        SystemNode parentNode = currentLevelNodes.get(0);
        for(int i = 0; i < currentLevelNodes.size(); i++){
            if(currentLevelNodes.get(i).getName().equals(parents[0])){
                parentNode = currentLevelNodes.get(i);
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
}
