package app.leasa;

import app.leasa.tools.Reader;
import app.leasa.tools.Writer;
import org.slf4j.Logger;

import java.io.IOException;

public class App {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

    public static void main(String[] args)
            throws IOException {
        log.info("Hello hashcode2021");
        
        Writer.zipProject(Writer.writeAll(Reader.readAll()));
    }
    
}
