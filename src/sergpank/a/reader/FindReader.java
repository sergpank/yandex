package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class FindReader extends AbstractReader {

    private String[] parents;

    public FindReader(Reader reader) {
        super(reader);
    }

    @Override
    public FileTree read() throws IOException {

        FileTree tree = new FileTree();

        setNodeNumber(readLine());
        SystemNode rootNode = parseNode(readLine());
        tree.setRootNode(rootNode);

        for (int lineNr = 2; lineNr <= getNodesNumber(); lineNr++) {
            SystemNode node = parseNode(readLine());
            tree.addChild(node, parents);
        }

        return tree;
    }

    private SystemNode parseNode(String line) {
        String[] pathAndId = line.split(" ");
        int id = Integer.parseInt(pathAndId[1]);

        String[] nodes = pathAndId[0].split("/");
        parents = null;
        String name;
        if (nodes.length == 1) {
            name = nodes[0];
        } else {
            name = nodes[nodes.length - 1];
            parents = Arrays.copyOf(nodes, nodes.length - 1);
        }
        return new SystemNode(name, id);
    }
}
