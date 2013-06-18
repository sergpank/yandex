package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;

public abstract class AbstractWriter {

    protected FileTree tree;

    protected AbstractWriter(FileTree tree) {
        this.tree = tree;
    }

    public abstract void write();
}
