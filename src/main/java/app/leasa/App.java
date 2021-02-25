package app.leasa;

import java.io.IOException;

import app.leasa.tools.Reader;
import app.leasa.tools.Writer;

public class App {
    
    public static void main(String[] args)
            throws IOException {
        System.out.println("Hello hashcode2021");
        
        Writer.zipProject(Writer.writeAll(Reader.readAll()));
    }
    
}
