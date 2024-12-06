import java.util.ArrayList;

import java.lang.Math;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class SolutionTwo {
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
        System.out.println(reports.size());
        for (ArrayList<Integer> level_array : reports){
            // System.out.println(level_array);
            int dif;
            boolean retry = true;
            boolean is_safe = true;
            boolean ascending = true; 
            boolean descending = true;
            for (int i = 1; i < level_array.size() && (ascending || descending); i ++){
                boolean good = true;
                ascending = ascending && level_array.get(i) >= level_array.get(i-1);
                descending = descending && level_array.get(i) <= level_array.get(i-1);
                if (ascending == true || descending == true){
                    dif = Math.abs(level_array.get(i) - level_array.get(i-1));
                    // System.out.println(String.format("dif of %d - %d = %d", level_array.get(i), level_array.get(i-1), dif));
                    if ((1 > dif) || (dif > 3) || (dif == 0)){
                        // System.out.println("dif error");
                        good = false;
                    }
                } else {
                    // System.out.println("order error");
                    good = false;
                }

                if (good == false && retry == false){
                    is_safe = false;
                    break; 
                } else if (good == false && retry == true){
                    level_array.remove(i);
                    retry = false;
                }
            }
            if (is_safe == true){
                safe += 1;
                System.out.println(" is safe!\n");
            }
            else{
                System.out.println(" is NOT safe!\n");
            }
        }
        System.out.println(String.format("Safe Reports: %d", safe));
    } 
}