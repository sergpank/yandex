package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;

public class Acm1Reader extends AbstractReader{
    protected Acm1Reader(File file) {
        super(file);
    }

    @Override
    public FileTree read() {

        FileTree tree = new FileTree();
        int nodeNumber = getNodeNumber();
        SystemNode rootNode = createNode(readLine().split(" "));
        tree.setRootNode(rootNode);

        growTree(tree, nodeNumber);

        return tree;
    }

    private void growTree(FileTree tree, int nodeNumber) {

    }
}
