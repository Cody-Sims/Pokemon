package MoveCatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MoveConstants {
    public static final String[][] data = getData();
    public static String[][] getData(){
        String[][] data = new String[800][8];
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/PokemonStats/MoveList.csv"))) {
            for(int i = 0; i < data.length; i++) {
                String row = br.readLine();
                String[] stats = row.split("[,]");
                System.out.println(Arrays.toString(stats));
                for(int j = 0; j < data[i].length; j++){
                    data[i][j] = stats[j].strip();
                }
            }
        }
        catch(IOException e){
            System.out.println("Error parsing Moves");
        }
        return data;
    }

    public static final Map<String, String> MOVE_TYPES = getMoveType();
    public static Map<String, String> getMoveType(){
        Map<String, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            map.put(data[row][0], data[row][1]);
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<String, String> MOVE_CATEGORY = getMoveCategory();
    public static Map<String, String> getMoveCategory(){
        Map<String, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            map.put(data[row][0], data[row][2]);
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<String, String> MOVE_POWER = getMovePower();
    public static Map<String, String> getMovePower(){
        Map<String, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            map.put(data[row][0], data[row][3]);
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<String, String> MOVE_ACCURACY = getMoveAccuracy();
    public static Map<String, String> getMoveAccuracy(){
        Map<String, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            map.put(data[row][0], data[row][4]);
        }
        return Collections.unmodifiableMap(map);
    }

    public static final Map<String, String> MOVE_DESCRIPTION = getMoveDescription();
    public static Map<String, String> getMoveDescription(){
        Map<String, String> map = new HashMap<>();
        for(int row = 0;  row < data.length; row++){
            map.put(data[row][0], data[row][6]);
        }
        return Collections.unmodifiableMap(map);
    }
}
