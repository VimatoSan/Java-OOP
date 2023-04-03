package Logging;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyLogger {
    public static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
    static {
        try (FileInputStream ins = new FileInputStream("./log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
