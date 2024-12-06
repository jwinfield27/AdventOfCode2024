import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args){
        File test_data = new File("/home/joe/java_projects/AdventOfCode/DayTwo/data.txt");
        int safe = 0;
        ArrayList<ArrayList<Integer>> reports = new ArrayList<>();
        String line;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(test_data));
            while ((line = bf.readLine()) != null) {
                String[] str_levels = line.split(" ");
                ArrayList<Integer> new_report = new ArrayList<>();
                for (String level : str_levels){
                    new_report.add(Integer.parseInt(level));
                }
                reports.add(new_report);
            }
            bf.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getStackTrace());
        }
        catch (IOException e){
            System.out.println(e.getStackTrace());
        }

        for (ArrayList<Integer> level_array : reports){
            if (decreasing(level_array)|| increasing(level_array)) {
                safe += 1;
            }
        }

        System.out.println(String.format("Safe Reports: %d", safe));
    }

    public static boolean increasing(ArrayList<Integer> level_array){
        int outer_window = 0;
        int dif = 0;
        for (int i = 0; i < level_array.size()-1; i++){
            outer_window = i + 1;
            dif = level_array.get(outer_window) - level_array.get(i);
            if (level_array.get(i) > level_array.get(outer_window)) {
                return false;
            }
            else if (dif < 1 || dif > 3){
                return false;
            }
        }
        return true;
    }

    public static boolean decreasing(ArrayList<Integer> level_array){
        int outer_window = 0;
        int dif = 0;
        for (int i = 0; i < level_array.size()-1; i++){
            outer_window = i + 1;
            dif = level_array.get(i) - level_array.get(outer_window);
            if (level_array.get(i) < level_array.get(outer_window)) {
                return false;
            }
            else if (dif < 1 || dif > 3){
                return false;
            }
        }
        return true;
    }
}
