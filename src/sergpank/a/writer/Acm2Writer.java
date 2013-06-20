package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;

public class Acm2Writer extends AcmWriter {

    public Acm2Writer(FileTree tree, PrintStream printStream) {
        super(tree, printStream);
    }

    @Override
    protected void printIdentifiers() {
        for (SystemNode node : nodes) {
            if (node.getParent() == null) {
                printStream.println(-1);
            } else {
                printStream.println(node.getParent().getId());
            }
        }
    }
}
