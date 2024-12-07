import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args){
        File f = new File("C:\\Users\\16125\\Desktop\\java projects\\AdventOfCode\\AdventOfCode2024\\DayFour\\sample.txt");
        List<List<Character>> char_lists = new ArrayList<>();
        int[] deltas = {-1, 0 , 1};
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
            bf.close();
        }
        catch(FileNotFoundException e){System.out.println("file not found");}
        catch(IOException e){System.out.println("error reading input file's next line");}

        for(int i = 0; i < char_lists.size(); i++){
            List<Character> inside_char_list = char_lists.get(i);
            for(int j = 0; j < inside_char_list.size(); j++){
                if (inside_char_list.get(j) == 'X'){
                    for (int dx = 0; dx < deltas.length; dx++){
                        for (int dy = 0; dy < deltas.length; dy++){
                            System.out.println(String.format("deltas %d %d", deltas[dx], deltas[dy]));
                            total += find_xmas(1, i, j, deltas[dx], deltas[dy], char_lists, "MAS");
                        }
                    }
                }
            }
        }
        System.out.println(String.format("Result: %d", total));
    }

    public static int find_xmas(int depth, int i, int j, int change_i, int change_j, List<List<Character>> char_lists, String str_to_find){
        char next_ch;
        int new_i = i+change_i;
        int new_j = j+change_j;
        try {
            next_ch = char_lists.get(new_i).get(new_j);
        } 
        catch(IndexOutOfBoundsException e) {
            return 0;
        }
        if ((depth < 3) && (next_ch == str_to_find.charAt(0))){
            str_to_find = str_to_find.substring(1, str_to_find.length());
            return find_xmas(depth+1, new_i, new_j, change_i, change_j, char_lists, str_to_find);
        }
        else if ((depth == 3) && (next_ch == str_to_find.charAt(0))){
            return 1;
        }
        else{
            return 0;
        }
    }
}