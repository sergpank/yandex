package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Acm3Writer extends AcmWriter {

    protected Acm3Writer(FileTree tree, PrintStream stream) {
        super(tree, stream);
    }

    @Override
    protected void printIdentifiers() {
        Set<SystemNode> properlySortedNodes = sortNodes();
        Iterator<SystemNode> iterator = properlySortedNodes.iterator();
        iterator.next();
        while(iterator.hasNext()){
            SystemNode node = iterator.next();
            printStream.println(new StringBuilder().append(node.getParent().getId()).append(SEPARATOR).append(node.getId()));
        }
    }

    private Set<SystemNode> sortNodes() {
        Set<SystemNode> properlySortedNodes = new TreeSet<SystemNode>(new Comparator<SystemNode>() {
            @Override
            public int compare(SystemNode node1, SystemNode node2) {
                int parent1id = node1.getParent() == null ? 0 : node1.getParent().getId();
                int parent2id = node2.getParent() == null ? 0 : node2.getParent().getId();
                int diff = parent1id - parent2id;
                return diff != 0 ? diff : node1.getId() - node2.getId();
            }
        });
        for(SystemNode node : nodes){
            properlySortedNodes.add(node);
        }
        return properlySortedNodes;
    }
}
