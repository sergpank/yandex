package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class XmlWriter extends AbstractWriter {

    public static final String FILE_OPEN = "<file name='";
    public static final String ID = "' id='";
    public static final String FILE_CLOSE = "'/>";
    public static final String DIR_OPEN = "<dir name='";
    public static final String DIR_END = "'>";
    public static final String DIR_CLOSE = "</dir>";
    Set<SystemNode> sortedNodes;

    public XmlWriter(FileTree tree, PrintStream printStream) {
        super(tree, printStream);
        sortedNodes = new TreeSet<SystemNode>(new Comparator<SystemNode>() {
            @Override
            public int compare(SystemNode node1, SystemNode node2) {
                int parent1id = node1.getParent() == null ? 0 : node1.getParent().getId();
                int parent2id = node2.getParent() == null ? 0 : node2.getParent().getId();
                int diff = parent1id - parent2id;
                return diff != 0 ? diff : node1.getId() - node2.getId();
            }
        });
    }


    @Override
    public void write() {
        sortNodes(tree.getRootNode());
        int level = 0;
        printTree(tree.getRootNode(), level);
        printStream.close();
    }


    private void printTree(SystemNode node, int level) {
        if (node.getChildren().size() > 0) {
            printDirectory(node, level);
            for (SystemNode child : node.getChildren()) {
                printTree(child, level + 1);
            }
            closeDirectory(level);
        } else {
            printFolder(node, level);
        }
    }


    private void printDirectory(SystemNode node, int level) {
        char[] spaces = createIndent(level);
        StringBuilder sb = new StringBuilder().append(createIndent(level)).append(DIR_OPEN).append(node.getName()).append(ID)
                .append(node.getId()).append(DIR_END);
        printStream.println(sb.toString());
    }


    private void closeDirectory(int level) {
        printStream.println(new StringBuilder().append(createIndent(level)).append(DIR_CLOSE).toString());
    }


    private void printFolder(SystemNode node, int level) {
        StringBuilder sb = new StringBuilder().append(createIndent(level)).append(FILE_OPEN)
                .append(node.getName()).append(ID).append(node.getId()).append(FILE_CLOSE);
        printStream.println(sb.toString());
    }


    private char[] createIndent(int level) {
        char[] spaces = new char[level * 2];
        Arrays.fill(spaces, SEPARATOR);
        return spaces;
    }


    private void sortNodes(SystemNode node) {
        sortedNodes.add(node);
        for (SystemNode child : node.getChildren()) {
            sortNodes(child);
        }
    }
}
