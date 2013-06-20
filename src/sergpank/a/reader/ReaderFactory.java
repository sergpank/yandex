package sergpank.a.reader;

import sergpank.a.FormatType;

import java.io.Reader;

public class ReaderFactory {

    public static AbstractReader createReader(String type, Reader reader) {
        FormatType readerType = FormatType.valueOf(type);

        AbstractReader necessaryReader;

        switch (readerType) {
            case find:
                necessaryReader = new FindReader(reader);
                break;
            case python:
                necessaryReader = new PythonReader(reader);
                break;
            case acm1:
                necessaryReader = new Acm1Reader(reader);
                break;
            case acm2:
                necessaryReader = new Acm2Reader(reader);
                break;
            case acm3:
                necessaryReader = new Acm3Reader(reader);
                break;
            case xml:
                necessaryReader = new XmlReader(reader);
                break;
            default:
                throw new IllegalArgumentException("Unsupported reader type: " + type);
        }
        return necessaryReader;
    }
}
