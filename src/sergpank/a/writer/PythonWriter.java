package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.util.Arrays;

public class PythonWriter extends AbstractWriter{

    public static final char SPACE = ' ';

    protected PythonWriter(FileTree tree) {
        super(tree);
    }

    @Override
    public void write() {
        int level = 0;
        System.out.println(tree.getNodeCount());

        printNode(tree.getRootNode(), level);
    }

    private void printNode(SystemNode node, int level) {
        System.out.println(nodeToString(node, level));
        for(int i = 0; i < node.getChildren().size(); i++){
            printNode(node.getChildren().get(i), level + 1);
        }
    }

    private String nodeToString(SystemNode node, int level) {
        char[] data = new char[level * 4];
        Arrays.fill(data, SPACE);
        StringBuilder sb = new StringBuilder();
        return sb.append(data).append(node.getName()).append(SPACE).append(node.getId()).toString();
    }
}
