import org.apache.log4j.Logger;

public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        logger.debug("This is debug message.");

        logger.info("This is info message.");
        logger.error("This is error message.");
    }
}