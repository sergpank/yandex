package sergpank.a.writer;

import sergpank.a.FormatType;
import sergpank.a.filesystem.FileTree;

import java.io.PrintStream;

public class WriterFactory {

    public static AbstractWriter createWriter(String type, FileTree tree, PrintStream stream){
        FormatType writerType = FormatType.valueOf(type);

        AbstractWriter necessaryWriter = null;
        switch (writerType){
            case find:
                necessaryWriter = new FindWriter(tree, stream);
                break;
            case python:
                necessaryWriter = new PythonWriter(tree, stream);
                break;
            case acm1:
                necessaryWriter = new Acm1Writer(tree, stream);
                break;
            case acm2:
                necessaryWriter = new Acm2Writer(tree, stream);
                break;
            case acm3:
                necessaryWriter = new Acm3Writer(tree, stream);
                break;
            case xml:
                necessaryWriter = new XmlWriter(tree, stream);
                break;
            default:
                throw new IllegalArgumentException("Unsupported writer type: " + type);
        }
        return necessaryWriter;
    }
}
