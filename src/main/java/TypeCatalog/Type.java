package TypeCatalog;

import java.util.ArrayList;
import java.util.HashSet;

import static TypeCatalog.TypeHandling.IMMUNITIES_TYPE_CHART;


// This class is used to keep give a pokemon a type. It contains the types weaknesses and strengths
// It is used for calculating damage during battle
public class Type {
    private final String _name;
    private final ArrayList<String> _weaknesses;
    private final ArrayList<String> _strengths;
    private final HashSet<String> _immunities;

    public Type(String name){
        _name = name;
        _weaknesses = null; //Todo
        _strengths = null; //Todo
        _immunities = IMMUNITIES_TYPE_CHART.get(_name);
    }

    public String getName() {
        return _name;
    }

    public ArrayList<String> getWeaknesses() {
        return _weaknesses;
    }

    public ArrayList<String> getStrengths() {
        return _strengths;
    }

    public HashSet<String> getImmunities() {
        return _immunities;
    }
}
