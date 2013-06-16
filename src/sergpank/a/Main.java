package sergpank.a;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;
import sergpank.a.reader.AbstractReader;
import sergpank.a.reader.FindReader;

public class Main {

    public static void main(String[] args) {
        AbstractReader reader = new FindReader();
        FileTree fileTree = reader.read("samples/fileTree.find");
        printFileTree(fileTree.getRootNode());
    }

    private static void printFileTree(SystemNode startNode) {
        System.out.println(startNode.getName() + " " + startNode.getId());
        for (SystemNode node : startNode.getChildren()) {
            printFileTree(node);
        }
    }
}
