package TypeCatalog;

import java.util.*;

// Keeps track of Pokemon Types, specifically weaknesses
//Todo implement a HashMap for each type

public class TypeHandling {

    // Keeps track of 1/2 effective typings
    public static final Map<String, List<String>> WEAKNESS_TYPE_CHART = initMap();
    public static Map<String, List<String>> initMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Normal", new ArrayList<String>(){});
        map.put("Fire", new ArrayList<String>(){{add("Fire"); add("Water"); add("Rock"); add("Dragon");}});

        return Collections.unmodifiableMap(map);
    }

    // Keeps track of 2x effective types
}
