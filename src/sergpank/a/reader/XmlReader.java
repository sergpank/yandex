package sergpank.a.reader;

import sergpank.a.filesystem.FileTree;
import sergpank.a.filesystem.SystemNode;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class XmlReader extends AbstractReader{

    private static final String NAME = "name";
    private static final String ID = "id";
    private Stack<SystemNode> nodeStack = new Stack<SystemNode>();
    private boolean isFirstTime = true;

    public XmlReader(Reader reader) {
        super(reader);
    }

    @Override
    protected String readLine() throws IOException {
        String line = null;
        if(nodeStack.isEmpty() || isFirstTime){
            line = reader.readLine();
        }
        return line;
    }

    @Override
    public FileTree read() throws IOException {
        FileTree tree = new FileTree();
        SystemNode rootNode = parseDir(readLine());
        nodeStack.push(rootNode);
        tree.setRootNode(rootNode);
        growTree(tree);
        return tree;
    }

    private void growTree(FileTree tree) throws IOException {
        String line;
        while ( (line = readLine()) != null ){
            if(isFile(line)){
                SystemNode child = parseFile(line);
                tree.addChild(nodeStack.peek(), child);
            } else if(isEndDir(line)){
                nodeStack.pop();
            }
            else{
                SystemNode child = parseDir(line);
                tree.addChild(nodeStack.peek(), child);
                nodeStack.push(child);
            }
        }
    }

    private boolean isFile(String line) {
        return line.contains("<file ");
    }

    private SystemNode parseFile(String line) {
        String propertiesOnly = line.substring(line.indexOf("<file") + 6, line.length() - 2).trim();
        Map<String, String> propertyMap = mapProperties(propertiesOnly);
        return new SystemNode(propertyMap.get(NAME), Integer.parseInt(propertyMap.get(ID)));
    }

    private boolean isEndDir(String line) {
        return line.trim().equals("</dir>");
    }

    private SystemNode parseDir(String line) {
        String propertiesOnly = line.substring(line.indexOf("<dir") + 5, line.length() - 1).trim();
        Map<String, String> propertyMap = mapProperties(propertiesOnly);
        return new SystemNode(propertyMap.get(NAME), Integer.parseInt(propertyMap.get(ID)));
    }

    private Map<String, String> mapProperties(String propertiesOnly) {
        String[] properties = propertiesOnly.split(" ");
        Map<String, String> propertyMap = new HashMap<String, String>();
        String[] property0 = properties[0].split("=");
        String[] property1 = properties[1].split("=");
        propertyMap.put( property0[0], property0[1].substring( 1, property0[1].length() - 1 ) );
        propertyMap.put( property1[0], property1[1].substring( 1, property1[1].length() - 1 ) );
        return propertyMap;
    }
}
