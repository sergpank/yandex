package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;

public class PythonWriter extends AbstractWriter{

    protected PythonWriter(FileTree tree) {
        super(tree);
    }

    @Override
    public void write() {
        int level = 0;
        System.out.println(tree.getNodeCount());

    }
}
