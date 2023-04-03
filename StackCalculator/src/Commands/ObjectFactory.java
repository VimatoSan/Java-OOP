package Commands;

import java.util.HashMap;

public class ObjectFactory {
    private final static HashMap<String, Command> registeredObjects = new HashMap<>();
    public static void init() {
        registerObject("Push", new Push());
        registerObject("Pop", new Pop());
        registerObject("Define", new Define());
        registerObject("Sqrt", new Sqrt());
        registerObject("Add", new Add());
        registerObject("Print", new Print());
        registerObject("Mul", new Mul());
        registerObject("Sub", new Sub());
        registerObject("Div", new Div());
    }

    public static boolean isExist(String key) {
        return registeredObjects.containsKey(key);
    }

    public static void registerObject(String key, Command obj) {
        registeredObjects.put(key, obj);
    }

    public static Command createObject(String key) {
        Command obj = registeredObjects.get(key);
        if (obj == null) {
            throw new IllegalArgumentException("Object with key " + key + " is not registered.");
        }
        return obj;
    }
}