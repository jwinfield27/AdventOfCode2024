import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolutionTwo {
    public static void main(String[] args){
        File f = new File("/home/joe/java_projects/AdventOfCode/DayFour/data.txt");
        List<List<Character>> char_lists = new ArrayList<>();
        int total = 0;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bf.readLine()) != null){
                List<Character> new_char_list = new ArrayList<>();
                for(int i = 0; i < line.length(); i++){
                    new_char_list.add(line.charAt(i));
                }
                char_lists.add(new_char_list);
            }
        } 
        catch(FileNotFoundException e){System.out.println(e.getStackTrace());}
        catch(IOException e){System.out.println(e.getStackTrace());}

        for(int i = 0; i < char_lists.size(); i++){
            List<Character> inside_char_list = char_lists.get(i);
            for(int j = 0; j < inside_char_list.size(); j++){
                if (inside_char_list.get(j) == 'A'){
                    total += findMas(i, j, char_lists);
                }
            }
        }
        System.out.println(String.format("Result: %d", total));
    }
    public static int findMas(int i, int j, List<List<Character>>char_list){
        Character top_left_char;
        Character bottom_left_char;
        Character top_right_char;
        Character bottom_right_char;
        try {
            top_left_char = char_list.get(i-1).get(j+1);
            bottom_left_char = char_list.get(i-1).get(j-1);
            top_right_char = char_list.get(i+1).get(j+1);
            bottom_right_char = char_list.get(i+1).get(j-1);
        } 
        catch (IndexOutOfBoundsException e){return 0;}

        if (top_left_char == 'S' && bottom_left_char == 'S' && top_right_char == 'M' && bottom_right_char == 'M'){
            return 1;
        }
        else if (top_left_char == 'M' && bottom_left_char == 'M' && top_right_char == 'S' && bottom_right_char == 'S'){
            return 1;
        }
        else if (top_left_char == 'M' && bottom_left_char == 'S' && top_right_char == 'M' && bottom_right_char == 'S'){
            return 1;
        }
        else if (top_left_char == 'S' && bottom_left_char == 'M' && top_right_char == 'S' && bottom_right_char == 'M'){
            return 1;
        }
        return 0;
    }

}
