package Commands;

import Logging.MyLogger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Sqrt implements Command{
    @Override
    public void run(Stack<Double> stack, HashMap<String, Double> map, String[] args) throws IOException {
        double result = Math.sqrt(stack.pop());
        stack.push(result);
        MyLogger.LOGGER.info(this.getClass().getSimpleName() + " completed");
    }
}
