package TypeCatalog;

import java.util.ArrayList;


// This class is used to keep give a pokemon a type. It contains the types weaknesses and strengths
// It is used for calculating damage during battle
public class Type {
    private final String _name;
    private final ArrayList<String> _weaknesses;
    private final ArrayList<String> _strengths;

    public Type(String name){
        _name = name;
        _weaknesses = null; //Todo
        _strengths = null; //Todo
    }

    public String get_name() {
        return _name;
    }

    public ArrayList<String> get_weaknesses() {
        return _weaknesses;
    }

    public ArrayList<String> get_strengths() {
        return _strengths;
    }
}
