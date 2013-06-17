package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PythonReader extends AbstractReader {

    int level = 1;
    List<SystemNode> nodeStack = new ArrayList<SystemNode>();

    public PythonReader(File file) {
        super(file);
    }

    @Override
    public FileTree read() {

        FileTree tree = new FileTree();

        int nodesNr = getNodeNumber();
        String[] rootNodeData = readLine().split(" ");
        final SystemNode rootNode = createNode(rootNodeData);
        tree.setRootNode(rootNode);
        nodeStack.add(rootNode);

        growTree(tree, nodesNr);

        return tree;
    }

    private void growTree(FileTree tree, int nodesNr) {
        SystemNode previousNode = null;
        for (int i = 2; i <= nodesNr; i++) {
            String nodeLine = readLine();
            int nodeLevel = getNodeLevel(nodeLine);
            SystemNode node = parseNode(nodeLine);

            if (nodeLevel > level) {
                push(previousNode);
            } else if(nodeLevel < level){
                pop(level - nodeLevel);
            }
            tree.addChild(node, nodeStack);
            previousNode = node;
            level = nodeLevel;
        }
    }

    private SystemNode parseNode(String nodeLine) {
        String trim = nodeLine.trim();
        String[] split = trim.split(" ");
        SystemNode node = createNode(split);
        return node;
    }

    private int getNodeLevel(String nodeLine) {
        int cnt = 0;
        while (nodeLine.charAt(cnt) == ' ') {
            ++cnt;
        }
        return cnt / 4;
    }

    private void push(SystemNode node) {
        nodeStack.add(node);
    }

    private void pop(int levelsNr) {
        nodeStack = nodeStack.subList(0, nodeStack.size() - levelsNr);
    }
}
