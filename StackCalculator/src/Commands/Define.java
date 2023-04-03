package Commands;

import Logging.MyLogger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Define implements Command{
    @Override
    public void run(Stack<Double> stack, HashMap<String, Double> map, String[] args) throws IOException {
        if (args.length != 2)
            throw new IOException("Incorrect number of arguments");
        double value;
        try  {
            Double.parseDouble(args[0]);
            throw new IOException("Incorrect argument: " + args[0]);
        }
        catch (NumberFormatException ex1) {
            try {
                value = Double.parseDouble(args[1]);
            }
            catch (NumberFormatException ex2) {
                throw new IOException("Incorrect argument: " + args[1]);
            }
        }

        map.put(args[0], value);
        MyLogger.LOGGER.info(this.getClass().getSimpleName() + " completed");
    }
}
