package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.util.List;
import java.util.Stack;

public class FindWriter extends AbstractWriter {


    protected FindWriter(FileTree tree) {
        super(tree);
    }

    @Override
    public void write() {
        System.out.println(tree.getNodeCount());
        dig(tree.getRootNode());
    }

    private void dig(SystemNode node) {
        List<SystemNode> children = node.getChildren();
        printNode(node, new Stack<String>(), node.getId());
        for (int i = 0; i < children.size(); i++) {
            dig(children.get(i));
        }
    }

    private void printNode(SystemNode node, Stack<String> children, int id) {
        if (node.getParent() == null) {
            StringBuilder builder = new StringBuilder(node.getName());
            while (!children.isEmpty()) {
                builder.append('/');
                builder.append(children.pop());
            }
            builder.append(' ');
            builder.append(id);
            System.out.println(builder);
        } else {
            children.push(node.getName());
            printNode(node.getParent(), children, id);
        }
    }
}
