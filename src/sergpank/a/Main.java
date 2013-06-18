package sergpank.a;

import sergpank.a.filesystem.SystemNode;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        AbstractReader reader = new FindReader(new File("samples/fileTree.find"));
//        FileTree fileTree = reader.read();
//        printFileTree(fileTree.getRootNode());

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

    }

    private static void printFileTree(SystemNode startNode) {
        System.out.println(startNode.toString());
    }
}
