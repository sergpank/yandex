package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PythonReader extends AbstractReader {

    int level = 1;
    private Stack<SystemNode> nodeStack = new Stack<SystemNode>();

    public PythonReader(Reader reader) {
        super(reader);
    }

    @Override
    public FileTree read() throws IOException {

        FileTree tree = new FileTree();

        setNodeNumber(readLine());
        final SystemNode rootNode = createNode(readLine());
        tree.setRootNode(rootNode);
        nodeStack.add(rootNode);

        growTree(tree);

        return tree;
    }

    private void growTree(FileTree tree) throws IOException {
        SystemNode previousNode = null;
        for (int i = 2; i <= getNodesNumber(); i++) {
            String nodeLine = readLine();
            int nodeLevel = getNodeLevel(nodeLine);
            SystemNode node = parseNode(nodeLine);

            if (nodeLevel > level) {
                nodeStack.push(previousNode);
            } else if(nodeLevel < level){
                for(int cnt = 0; cnt < level - nodeLevel; cnt++){
                    nodeStack.pop();
                }
            }
            tree.addChild(node, nodeStack);
            previousNode = node;
            level = nodeLevel;
        }
    }

    private SystemNode parseNode(String nodeLine) {
        String trim = nodeLine.trim();
        SystemNode node = createNode(trim);
        return node;
    }

    private int getNodeLevel(String nodeLine) {
        int cnt = 0;
        while (nodeLine.charAt(cnt) == ' ') {
            ++cnt;
        }
        return cnt / 4;
    }
}
