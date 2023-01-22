package struct;
import java.util.*;

public class Map {
    Dictionary<String, Integer> dict = new Hashtable<String, Integer>();
    
    public Map() {
        // Dictionary Initialization
        dict.put("A", 1);  
        dict.put("2", 2);  
        dict.put("3", 3);  
        dict.put("4", 4);  
        dict.put("5", 5);  
        dict.put("6", 6);  
        dict.put("7", 7);  
        dict.put("8", 8);  
        dict.put("9", 9);  
        dict.put("10", 10);
        dict.put("J", 11);  
        dict.put("Q", 12);  
        dict.put("K", 13);      
    }

    public int getValue (String inputSuit) {
        // Getting the value of the suit
        return dict.get(inputSuit);
    }    
}
