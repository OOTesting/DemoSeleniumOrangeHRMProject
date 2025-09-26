package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    // Returns a logger instance for the calling class
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    // Optional: Helper methods for custom formatting
    public static void info(Logger log, String message) {
        log.info(message);
    }

    public static void debug(Logger log, String message) {
        log.debug(message);
    }

    public static void error(Logger log, String message, Throwable t) {
        log.error(message, t);
    }
}
