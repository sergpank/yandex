package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FindReader extends AbstractReader {

    private String[] parents;

    @Override
    public FileTree read(String fileName) {

        FileTree tree = new FileTree();

        List<String> data = readFile(new File(fileName));

        int nodesNr = Integer.parseInt(data.get(0));
        SystemNode rootNode = parseNode(data.get(1));
        tree.setRootNode(rootNode);

        for(int lineNr = 2; lineNr <= nodesNr; lineNr++){
            SystemNode node = parseNode(data.get(lineNr));
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
        if(nodes.length == 1){
            name = nodes[0];
        } else{
            name = nodes[nodes.length - 1];
            parents = Arrays.copyOf(nodes, nodes.length - 1);
        }
        return new SystemNode(name, id);
    }
}
