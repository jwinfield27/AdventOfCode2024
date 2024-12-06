package DayOne;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Math;

public class Solution {

    public static void main(String[] args){
        File data_file_path  = new File("/home/joe/java_projects/AdventOfCode/DayOne/data.txt");
        int total_distance = 0;
        int index = 0;
        int[] left_array = new int[1000];
        int[] right_array = new int[1000];
        BufferedReader bf;
        String line;

        try {
            bf = new BufferedReader(new FileReader(data_file_path));
            while ((line = bf.readLine()) != null) {
                String[] tokens = line.split("   ");
                left_array[index] = Integer.parseInt(tokens[0]);
                right_array[index] = Integer.parseInt(tokens[1]);

                index += 1;
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getStackTrace());
        }
        catch (IOException e){
            System.out.println(e.getStackTrace());
        }


        Arrays.sort(left_array);
        Arrays.sort(right_array);
        System.out.println(left_array[999]);
        System.out.println(right_array[999]);


        for (int i = 0; i < left_array.length; i++){
            total_distance += Math.abs(right_array[i] - left_array[i]);
        }

        System.out.println(String.format("Total distance: %d", total_distance));
    }
}
