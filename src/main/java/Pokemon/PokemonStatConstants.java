package Pokemon;

import App.MainRunner;

import java.io.*;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class PokemonStatConstants {
    // A data set containing all of a pokemon's stats
    public static final String[][] data = getData();
    public static String[][] getData(){
        String[][] data = new String[152][10];

        //ClassLoader classLoader = MainRunner.class.getClassLoader();
        //String url = Objects.requireNonNull(classLoader.getResource("/Pokemon_Stats.csv")).toString();
        //System.out.println(url);


        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/PokemonStats/Pokemon_Stats.csv"))) {
            for(int i = 0; i < data.length; i++) {
                String row = br.readLine();
                for(int j = 0; j < data[i].length; j++){
                    String[] stats = row.split(",");
                    data[i][j] = stats[j];
                }
            }
        }
        catch(IOException e){
            System.out.println("Error parsing Pokemon");
        }
        return data;
    }

    public static final Map<Integer, String> POKEMON_NAMES = getPokemonNames();
    public static Map<Integer, String> getPokemonNames(){
        Map<Integer, String> map = new HashMap<>();
          for(int row = 0;  row < data.length; row++){
              map.put(row, data[row][0]);
          }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_TYPE_ONE = getPokemonTypeOne();
    public static Map<Integer, String> getPokemonTypeOne(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            map.put(row, data[row][1]);
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_TYPE_TWO = getPokemonTypeTwo();
    public static Map<Integer, String> getPokemonTypeTwo(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][2] != null){
                map.put(row, data[row][2]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_TOTAL = getPokemonTotal();
    public static Map<Integer, String> getPokemonTotal(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][2] != null){
                map.put(row, data[row][3]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_HP = getPokemonHP();
    public static Map<Integer, String> getPokemonHP(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][4] != null){
                map.put(row, data[row][4]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_ATTACK = getPokemonATTACK();
    public static Map<Integer, String> getPokemonATTACK(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][5] != null){
                map.put(row, data[row][5]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_DEFENSE = getPokemonDefense();
    public static Map<Integer, String> getPokemonDefense(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][6] != null){
                map.put(row, data[row][6]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_SPECIAL_ATTACK = getPokemonSpecialAttack();
    public static Map<Integer, String> getPokemonSpecialAttack(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][7] != null){
                map.put(row, data[row][7]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_SPECIAL_DEFENSE = getPokemonSpecialDefense();
    public static Map<Integer, String> getPokemonSpecialDefense(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][8] != null){
                map.put(row, data[row][8]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> POKEMON_SPEED = getPokemonSpeed();
    public static Map<Integer, String> getPokemonSpeed(){
        Map<Integer, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            if(data[row][9] != null){
                map.put(row, data[row][9]);
            }
            else{
                map.put(row,"None");
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
