import Commands.Command;
import Commands.ObjectFactory;
import Logging.MyLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class StackCalculator {
    private static BufferedReader stream;
    private static final Stack<Double> stack = new Stack<>();
    private static final HashMap<String, Double> map = new HashMap<>();
    public static void setStream(BufferedReader inputStream) {
        stream = inputStream;
    }
    public static void work() throws IOException {
        int cmdNum = 1;
        String line;
        while ((line = stream.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty())
                throw new IOException("Empty link in input file");
            String[] instruction = line.split(" ", 2);
            String cmdName = instruction[0];
            if (cmdName.charAt(0) == '#')
                continue;
            ObjectFactory.init();
            if (!ObjectFactory.isExist(cmdName)) {
                System.err.println("Unknown command: \"" + cmdName + "\" in line " + cmdNum);
            }
            String[] parametres = null;

            if (instruction.length > 1) {
                parametres = instruction[1].split(" ");
            }
            Command curCmd = ObjectFactory.createObject(cmdName);
            if (parametres == null) {
                MyLogger.LOGGER.info("Start running command: \"" + cmdName + "\" without parametres");
            } else {
                MyLogger.LOGGER.info("Start running command: \"" + cmdName + "\" with parametres: \"" + String.join(", ", parametres) + "\"");
            }
            try {
                curCmd.run(stack, map, parametres);
            } catch (IOException ex) {
                throw new IOException(ex.getMessage() + " in line " + cmdNum);
            }
            cmdNum += 1;
        }
        stream.close();
    }
}
