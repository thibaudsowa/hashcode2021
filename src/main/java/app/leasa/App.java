package app.leasa;

import java.io.IOException;

import app.leasa.tools.Graph;
import app.leasa.tools.Reader;
import app.leasa.tools.Writer;

import org.slf4j.Logger;

public class App {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

    public static void main(String[] args)
            throws IOException {
        log.info("Hello hashcode2021");
        new Graph().show( Reader.read("a.txt"));
    
//        writer.
        
        Writer.zipProject(Writer.writeAll(Reader.readAll()));
    }
    
}
