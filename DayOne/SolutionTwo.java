package DayOne;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SolutionTwo {

    public static void main(String[] args){
        File data_file_path  = new File("/home/joe/java_projects/AdventOfCode/DayOne/data.txt");
        HashMap<Integer,Integer> left_map = new HashMap<>();
        HashMap<Integer,Integer> right_map = new HashMap<>();
        BufferedReader bf;
        String line;

        try {
            bf = new BufferedReader(new FileReader(data_file_path));
            while ((line = bf.readLine()) != null) {
                String[] tokens = line.split("   ");
                int left_int = Integer.parseInt(tokens[0]);
                int right_int = Integer.parseInt(tokens[1]);

                if (left_map.containsKey(left_int)){
                    left_map.merge(left_int, 1, Integer::sum);
                }
                else {
                    left_map.put(left_int, 1);
                }

                if (right_map.containsKey(right_int)){
                    right_map.merge(right_int, 1, Integer::sum);
                }
                else {
                    right_map.put(right_int, 1);
                }
                
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getStackTrace());
        }
        catch (IOException e){
            System.out.println(e.getStackTrace());
        }

        int total = 0;
        for (int left_key : left_map.keySet()){
            if (right_map.containsKey(left_key)){
                total += left_key * right_map.get(left_key);
            }
        }

        System.out.println(String.format("Result: %d", total));
    }
    
}
