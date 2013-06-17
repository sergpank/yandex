package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PythonReader extends AbstractReader {

    int level = 1;
    List<SystemNode> nodeStack = new ArrayList<SystemNode>();

    @Override
    public FileTree read(String fileName) {

        FileTree tree = new FileTree();

        List<String> data = readFile(new File(fileName));

        int nodesNr = Integer.parseInt(data.get(0));
        String[] rootNodeData = data.get(1).split(" ");
        final SystemNode rootNode = new SystemNode(rootNodeData[0], Integer.parseInt(rootNodeData[1]));
        tree.setRootNode(rootNode);
        nodeStack.add(rootNode);

        growTree(tree, data, nodesNr);

        return tree;
    }

    private void growTree(FileTree tree, List<String> data, int nodesNr) {
        SystemNode previousNode = null;
        for (int i = 2; i <= nodesNr; i++) {
            String nodeLine = data.get(i);
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
        SystemNode node = new SystemNode(split[0], Integer.parseInt(split[1]));
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
