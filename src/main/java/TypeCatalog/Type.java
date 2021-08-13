package TypeCatalog;

import java.util.ArrayList;
import java.util.HashSet;

import static TypeCatalog.TypeHandling.*;


// This class is used to keep give a pokemon a type. It contains the types weaknesses and strengths
// It is used for calculating damage during battle
public class Type {
    private final String _name;
    private final HashSet<String> _weaknesses;
    private final HashSet<String> _strengths;
    private final HashSet<String> _immunities;

    public Type(String name){
        _name = name;
        _weaknesses = WEAKNESS_TYPE_CHART.get(_name); //Todo
        _strengths = STRENGTHS_TYPE_CHART.get(_name);
        _immunities = IMMUNITIES_TYPE_CHART.get(_name);
    }

    public String getName() {
        return _name;
    }

    public HashSet<String> getWeaknesses() {
        if(_weaknesses == null){
            return new HashSet<>();
        }
        return _weaknesses;
    }

    public HashSet<String> getStrengths() {
        if(_strengths == null){
            return new HashSet<>();
        }
        return _strengths;
    }

    public HashSet<String> getImmunities() {
        if(_immunities == null){
            return new HashSet<>();
        }
        return _immunities;
    }
}
