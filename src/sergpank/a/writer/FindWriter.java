package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.Set;
import java.util.Stack;

public class FindWriter extends AbstractWriter {


    protected FindWriter(FileTree tree, PrintStream stream) {
        super(tree, stream);
    }

    @Override
    public void write() {
        printStream.println(tree.getNodeCount());
        dig(tree.getRootNode());
        printStream.close();
    }

    private void dig(SystemNode node) {
        Set<SystemNode> children = node.getChildren();
        printNode(node, new Stack<String>(), node.getId());
        for (SystemNode child : children) {
            dig(child);
        }
    }

    private void printNode(SystemNode node, Stack<String> children, int id) {
        if (node.getParent() == null) {
            StringBuilder builder = new StringBuilder(node.getName());
            while (!children.isEmpty()) {
                builder.append('/');
                builder.append(children.pop());
            }
            builder.append(SEPARATOR);
            builder.append(id);
            printStream.println(builder);
        } else {
            children.push(node.getName());
            printNode(node.getParent(), children, id);
        }
    }
}
