package sergpank.a;

public abstract class Node {

    private String name;

    public String getName(){
        return name;
    }

    public abstract NodeType getType();
}
