package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class FindWriter extends AbstractWriter {

    Set<SystemNode> nodes;

    public FindWriter(FileTree tree, PrintStream stream) {
        super(tree, stream);
        nodes = new TreeSet<SystemNode>(new Comparator<SystemNode>() {
            @Override
            public int compare(SystemNode node1, SystemNode node2) {
                return node1.getId() - node2.getId();
            }
        });
    }

    @Override
    public void write() {
        printStream.println(tree.getNodeCount());
        dig(tree.getRootNode());
        printNodes();
    }

    private void printNodes() {
        for(SystemNode node : nodes){
            printNode(node, new Stack<String>(), node.getId());
        }
    }

    private void dig(SystemNode node) {
        Set<SystemNode> children = node.getChildren();
        nodes.add(node);
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
