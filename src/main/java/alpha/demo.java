package alpha;

import org.apache.logging.log4j.*;

public class demo {

    private static Logger log = LogManager.getLogger(demo.class.getName());

    public static void main(String[] args) {
        log.debug("I am debugging");
    }
    
}
