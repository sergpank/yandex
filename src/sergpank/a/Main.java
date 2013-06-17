package sergpank.a;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;
import sergpank.a.reader.AbstractReader;
import sergpank.a.reader.FindReader;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        AbstractReader reader = new FindReader(new File("samples/fileTree.find"));
        FileTree fileTree = reader.read();
        printFileTree(fileTree.getRootNode());
    }

    private static void printFileTree(SystemNode startNode) {
        System.out.println(startNode.toString());
    }
}
