package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AcmWriter extends AbstractWriter {
    protected List<SystemNode> nodes = new ArrayList<SystemNode>();

    @Override
    public void write() {
        printStream.println(tree.getNodeCount());
        readNodes(tree.getRootNode());
        printNodes();
        printIdentifiers();
    }

    private void readNodes(SystemNode node) {
        nodes.add(node);
        for (SystemNode sn : node.getChildren()) {
            readNodes(sn);
        }
    }

    protected AcmWriter(FileTree tree, PrintStream printStream) {
        super(tree, printStream);
    }


    protected void printNodes() {
        for (SystemNode node : nodes) {
            printStream.println(new StringBuilder().append(node.getName()).append(SEPARATOR).append(node.getId()));
        }
    }

    protected abstract void printIdentifiers();
}
