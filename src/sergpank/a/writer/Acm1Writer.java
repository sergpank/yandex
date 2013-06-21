package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.TreeSet;

public class Acm1Writer extends AcmWriter {

    public Acm1Writer(FileTree tree, PrintStream stream) {
        super(tree, stream);
    }

    @Override
    protected void printIdentifiers() {
        for (SystemNode node : nodes) {
            StringBuilder sb = new StringBuilder().append(node.getChildren().size());
            for (SystemNode child : node.getChildren()) {
                sb.append(SEPARATOR).append(child.getId());
            }
            printStream.println(sb);
        }
    }
}
