package sergpank.a;

import sergpank.a.filesystem.FileTree;
import sergpank.a.reader.AbstractReader;
import sergpank.a.reader.ReaderFactory;
import sergpank.a.writer.AbstractWriter;
import sergpank.a.writer.WriterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputFormat = br.readLine();
        String outputFormat = br.readLine();

        AbstractReader reader = ReaderFactory.createReader(inputFormat, br);
        FileTree tree = reader.read();
        AbstractWriter writer = WriterFactory.createWriter(outputFormat, tree, System.out);
        writer.write();
    }

}
