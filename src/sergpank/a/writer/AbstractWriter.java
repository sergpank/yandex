package sergpank.a.writer;

import sergpank.a.filesystem.FileTree;

import java.io.PrintStream;

public abstract class AbstractWriter {

    protected final char SEPARATOR = ' ';
    protected FileTree tree;
    protected PrintStream printStream;

    protected AbstractWriter(FileTree tree, PrintStream printStream) {
        this.tree = tree;
        this.printStream = printStream;
    }

    public abstract void write();
}
