import Commands.ObjectFactory;
import Logging.MyLogger;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            MyLogger.LOGGER.info("Get input stream using program args from command line");
            InputHeader reader = new InputHeader(args);
            MyLogger.LOGGER.info( "Init object factory");
            ObjectFactory.init();
            StackCalculator.setStream(reader.get());
            MyLogger.LOGGER.info("Start calculating...");
            StackCalculator.work();
        } catch (FileNotFoundException ex) {
            MyLogger.LOGGER.warning("File not found");
            System.err.println(ex.getMessage());
            return;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return;
        } catch (Exception ex) {
            MyLogger.LOGGER.warning("Program error");
            System.err.println(ex.getMessage());
            return;
        }
        MyLogger.LOGGER.info("Calculating successfully completed");
    }
}