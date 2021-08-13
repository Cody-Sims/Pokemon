package TypeCatalog;

import java.lang.reflect.Array;
import java.util.*;

// Keeps track of Pokemon Types, specifically weaknesses
//Todo implement a HashMap for each type

public class TypeHandling {

    // <AttackingType, DefendingTypes>

    // Keeps track of no damage
    public static final Map<String, HashSet<String>> IMMUNITIES_TYPE_CHART = getNoDamageTypeChart();
    public static Map<String, HashSet<String>> getNoDamageTypeChart() {
        Map<String, HashSet<String>> map = new HashMap<>();
        map.put("Normal", new HashSet<>(Collections.singletonList("Ghost")));
        map.put("Electric", new HashSet<>(Collections.singletonList("Ground")));
        map.put("Fighting", new HashSet<>(Collections.singletonList("Ghost")));
        map.put("Poison", new HashSet<>(Collections.singletonList("Steel")));
        map.put("Ground", new HashSet<>(Collections.singletonList("Flying")));
        map.put("Psychic", new HashSet<>(Collections.singletonList("Dark")));
        map.put("Ghost", new HashSet<>(Collections.singletonList("Normal")));
        map.put("Dragon", new HashSet<>(Collections.singletonList("Fairy")));


        return Collections.unmodifiableMap(map);
    }

    // Keeps track of 1/2 effective typings
    public static final Map<String, List<String>> WEAKNESS_TYPE_CHART = initMap();
    public static Map<String, List<String>> initMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Normal", new ArrayList<String>(){});
        map.put("Fire", new ArrayList<String>(){{add("Water"); add("Rock");}});


        return Collections.unmodifiableMap(map);
    }

    // Keeps track of 2x effective types
}
