package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.Arrays;

public class PythonWriter extends AbstractWriter{

    protected PythonWriter(FileTree tree, PrintStream stream) {
        super(tree, stream);
    }

    @Override
    public void write() {
        int level = 0;
        printStream.println(tree.getNodeCount());

        printNode(tree.getRootNode(), level);
    }

    private void printNode(SystemNode node, int level) {
        printStream.println(nodeToString(node, level));
        for(SystemNode child : node.getChildren()){
            printNode(child, level + 1);
        }
    }

    private String nodeToString(SystemNode node, int level) {
        char[] data = new char[level * 4];
        Arrays.fill(data, SEPARATOR);
        StringBuilder sb = new StringBuilder();
        return sb.append(data).append(node.getName()).append(SEPARATOR).append(node.getId()).toString();
    }
}
