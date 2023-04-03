package Commands;

import Logging.MyLogger;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Sub implements Command {
    @Override
    public void run(Stack<Double> stack, HashMap<String, Double> map, String[] args) throws IOException {
        try {
            stack.push(stack.pop() - stack.pop());
            MyLogger.LOGGER.info(this.getClass().getSimpleName() + " completed");
        }
        catch (EmptyStackException ex) {
            throw new IOException("Not enough values in stack to do " + this.getClass().getSimpleName() + " operation");
        }
    }
}
