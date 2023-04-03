package Commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import Logging.MyLogger;

public class Push implements Command{
    @Override
    public void run(Stack<Double> stack, HashMap<String, Double> map, String[] args) throws IOException {
        if (args.length != 1)
            throw new IOException("Incorrect number of arguments");
        double value;
        try {
            value = Double.parseDouble(args[0]);
        }
        catch (NumberFormatException ex) {
            if (map.get(args[0]) == null)
                throw new IOException("Incorrect argument: " + args[0]);
            value = map.get(args[0]);
        }
        stack.push(value);
        MyLogger.LOGGER.info(this.getClass().getSimpleName() + " completed");
    }
}
