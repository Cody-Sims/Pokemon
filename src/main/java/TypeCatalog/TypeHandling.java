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
        map.put("Normal", new HashSet<>(Collections.singletonList("GHOST")));
        map.put("Electric", new HashSet<>(Collections.singletonList("GROUND")));
        map.put("Fighting", new HashSet<>(Collections.singletonList("GHOST")));
        map.put("Poison", new HashSet<>(Collections.singletonList("STEEL")));
        map.put("Ground", new HashSet<>(Collections.singletonList("FLYING")));
        map.put("Psychic", new HashSet<>(Collections.singletonList("DARK")));
        map.put("Ghost", new HashSet<>(Collections.singletonList("NORMAL")));
        map.put("Dragon", new HashSet<>(Collections.singletonList("FAIRY")));


        return Collections.unmodifiableMap(map);
    }

    // Keeps track of 1/2 effective typings
    public static final Map<String, HashSet<String>> WEAKNESS_TYPE_CHART = getWeaknessTypeChart();
    public static Map<String, HashSet<String>> getWeaknessTypeChart() {
        Map<String, HashSet<String>> map = new HashMap<>();
        map.put("Normal", new HashSet<>(Arrays.asList("ROCK", "STEEL")));
        map.put("Fire", new HashSet<>(Arrays.asList("ROCK", "DRAGON")));
        map.put("Water", new HashSet<>(Arrays.asList("WATER", "GRASS", "DRAGON")));
        map.put("Electric", new HashSet<>(Arrays.asList("ELECTRIC", "GRASS", "DRAGON")));
        map.put("Grass", new HashSet<>(Arrays.asList("FIRE", "GRASS", "POISON", "FLYING", "BUG", "DRAGON", "STEEL")));
        map.put("Ice", new HashSet<>(Arrays.asList("FIRE", "WATER", "ICE", "STEEL")));
        map.put("Fighting", new HashSet<>(Arrays.asList("POISON", "FLYING", "PSYCHIC", "BUG", "FAIRY")));
        map.put("Poison", new HashSet<>(Arrays.asList("POISON", "GROUND", "ROCK", "GHOST")));
        map.put("Ground", new HashSet<>(Arrays.asList("GRASS", "BUG")));
        map.put("Flying", new HashSet<>(Arrays.asList("ELECTRIC", "ROCK", "STEEL")));
        map.put("Psychic", new HashSet<>(Arrays.asList("PSYCHIC", "STEEL")));
        map.put("Bug", new HashSet<>(Arrays.asList("FIRE", "FIGHTING", "POISON", "FLYING", "GHOST", "STEEL", "FAIRY")));
        map.put("Rock", new HashSet<>(Arrays.asList("FIGHTING", "GROUND")));
        map.put("Ghost", new HashSet<>(Collections.singletonList("DARK")));
        map.put("Dragon", new HashSet<>(Collections.singletonList("STEEL")));
        map.put("Dark", new HashSet<>(Arrays.asList("FIGHTING", "DARK", "FAIRY")));
        map.put("Steel", new HashSet<>(Arrays.asList("FIRE", "WATER", "ELECTRIC", "STEEL")));
        map.put("Fairy", new HashSet<>(Arrays.asList("FIRE", "POISON", "STEEL")));
        return Collections.unmodifiableMap(map);
    }

    // Keeps track of 2x effective types
    public static final Map<String, HashSet<String>> STRENGTHS_TYPE_CHART = getStrengths();
    public static Map<String, HashSet<String>> getStrengths() {
        Map<String, HashSet<String>> map = new HashMap<>();
        map.put("Normal", new HashSet<>(Arrays.asList("ROCK", "STEEL")));
        map.put("Fire", new HashSet<>(Arrays.asList("ROCK", "DRAGON")));
        map.put("Water", new HashSet<>(Arrays.asList("WATER", "GRASS", "DRAGON")));
        map.put("Electric", new HashSet<>(Arrays.asList("ELECTRIC", "GRASS", "DRAGON")));
        map.put("Grass", new HashSet<>(Arrays.asList("FIRE", "GRASS", "POISON", "FLYING", "BUG", "DRAGON", "STEEL")));
        map.put("Ice", new HashSet<>(Arrays.asList("FIRE", "WATER", "ICE", "STEEL")));
        map.put("Fighting", new HashSet<>(Arrays.asList("POISON", "FLYING", "PSYCHIC", "BUG", "FAIRY")));
        map.put("Poison", new HashSet<>(Arrays.asList("POISON", "GROUND", "ROCK", "GHOST")));
        map.put("Ground", new HashSet<>(Arrays.asList("GRASS", "BUG")));
        map.put("Flying", new HashSet<>(Arrays.asList("ELECTRIC", "ROCK", "STEEL")));
        map.put("Psychic", new HashSet<>(Arrays.asList("PSYCHIC", "STEEL")));
        map.put("Bug", new HashSet<>(Arrays.asList("FIRE", "FIGHTING", "POISON", "FLYING", "GHOST", "STEEL", "FAIRY")));
        map.put("Rock", new HashSet<>(Arrays.asList("FIGHTING", "GROUND")));
        map.put("Ghost", new HashSet<>(Collections.singletonList("DARK")));
        map.put("Dragon", new HashSet<>(Collections.singletonList("STEEL")));
        map.put("Dark", new HashSet<>(Arrays.asList("FIGHTING", "DARK", "FAIRY")));
        map.put("Steel", new HashSet<>(Arrays.asList("FIRE", "WATER", "ELECTRIC", "STEEL")));
        map.put("Fairy", new HashSet<>(Arrays.asList("FIRE", "POISON", "STEEL")));

        return Collections.unmodifiableMap(map);
    }
}
