import java.util.HashMap;
import java.util.Map;

public class ObjectContainer {
    private Map<String, Object> container;

    public ObjectContainer() {
        this.container = new HashMap<>();
    }

    public void register(String key, Object value){
        container.put(key, value);
    }

    public Object get(String key){
        return container.get(key);
    }
}
