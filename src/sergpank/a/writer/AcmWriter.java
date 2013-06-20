package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AcmWriter extends AbstractWriter {
    protected Set<SystemNode> nodes;

    protected AcmWriter(FileTree tree, PrintStream printStream) {
        super(tree, printStream);
        nodes = new LinkedHashSet<SystemNode>();
    }

    @Override
    public void write() {
        printStream.println(tree.getNodeCount());
        readNodes(tree.getRootNode());
        printNodes();
        printIdentifiers();
        printStream.close();
    }

    protected void readNodes(SystemNode node) {
        nodes.add(node);
        for (SystemNode sn : node.getChildren()) {
            readNodes(sn);
        }
    }


    protected void printNodes() {
        for (SystemNode node : nodes) {
            printStream.println(new StringBuilder().append(node.getName()).append(SEPARATOR).append(node.getId()));
        }
    }

    protected abstract void printIdentifiers();
}
