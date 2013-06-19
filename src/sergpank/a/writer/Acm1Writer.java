package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;

public class Acm1Writer extends AcmWriter {

    protected Acm1Writer(FileTree tree, PrintStream stream) {
        super(tree, stream);
    }

    @Override
    public void write() {
        printStream.println(tree.getNodeCount());
        readNodes(tree.getRootNode());
        printNodes();
        printIdentifiers();
    }

    private void printIdentifiers() {
        for(SystemNode node : nodes){
            StringBuilder sb = new StringBuilder().append(node.getChildren().size());
            for(SystemNode child : node.getChildren()){
                sb.append(SEPARATOR).append(child.getId());
            }
            printStream.println(sb);
        }
    }

    private void readNodes(SystemNode node) {
        nodes.add(node);
        for(SystemNode sn : node.getChildren()){
            readNodes(sn);
        }
    }

}
