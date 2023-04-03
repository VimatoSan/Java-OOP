package Commands;

import Logging.MyLogger;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Pop implements Command{
    @Override
    public void run(Stack<Double> stack, HashMap<String, Double> map, String[] args) throws IOException {
        try {
            stack.pop();
            MyLogger.LOGGER.info(this.getClass().getSimpleName() + " completed");
        } catch (EmptyStackException ex) {
            throw new IOException("Not enough values in stack to do " + this.getClass().getSimpleName() + " operation");
        }
    }
}
