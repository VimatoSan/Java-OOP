import java.io.*;

public class InputHeader {
    private final BufferedReader inputStream;
    public InputHeader(String[] args) throws FileNotFoundException {
        if (args.length != 0 && !args[0].isEmpty()) {
            try {
                this.inputStream = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("Incorrect filename in command line");
            }
        }
        else {
            this.inputStream = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public BufferedReader get() {
        return this.inputStream;
    }
}
