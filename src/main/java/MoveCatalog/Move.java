package MoveCatalog;

import MoveCatalog.Effects.Effect;
import Pokemon.Pokemon;


import static MoveCatalog.Effects.getEffect.getEffect;
import static MoveCatalog.MoveConstants.*;

public class Move {
    // Potentially parse a csv file for the information
    // Potentially split each move into Types and create a HashMap for each Typing
    String _name;
    String _category;
    String _type;
    String _description;

    int _power;
    int _accuracy;
    int _probability;

    Effect _effect;

    Pokemon _pokemon;

    public Move(String name, Pokemon pokemon){
        _name = name;
        _pokemon = pokemon;
        setInfo();
    }

    private void setInfo(){
        System.out.println(_name + " : Power" + MOVE_POWER.get(_name));
        System.out.println();
        _category = MOVE_CATEGORY.get(_name);
        _type = MOVE_TYPES.get(_name);
        _description = MOVE_DESCRIPTION.get(_name);

        if(!MOVE_POWER.get(_name).equals("")){
            _power = Integer.parseInt(MOVE_POWER.get(_name));
        }
        else{
            _power = 0;
            //Todo set status effect
        }

        if(!MOVE_ACCURACY.get(_name).equals("")){
            _accuracy = Integer.parseInt(MOVE_ACCURACY.get(_name));
        }else {
            _accuracy = 100;
        }

        _effect = getEffect(_description);


    }


    public String getName(){
        return _name;
    }

    public String getType() {
        return _type;
    }

    public String getCategory(){
        return _category;
    }

    public int getPower() {
        return _power;
    }

    public int getAccuracy(){
        return _accuracy;
    }

    public void calculateEffect(){
        _effect.updateStat(_pokemon);
    }

    public int getProbability(){ return _probability;}
}
