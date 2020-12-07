package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {

    public static Logger logger;

    public static Logger getLogger(){
        if (logger == null){
            logger = LoggerFactory.getLogger(MyLogger.class);
        }
        return logger;
    }
}
