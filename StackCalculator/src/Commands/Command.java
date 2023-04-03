package Commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public interface Command {
    void run(Stack<Double> stack, HashMap<String, Double> map, String[] args) throws IOException;
}
