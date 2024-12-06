import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args){
        File data_file_path  = new File("/home/joe/java_projects/AdventOfCode/DayThree/sample.txt");
        BufferedReader bf;
        String line;
        int total = 0;
        int longest_mul_length = 12;
        char end_mul = ')';
        StringBuilder sb = new StringBuilder();
        try {
            bf = new BufferedReader(new FileReader(data_file_path));
            while ((line = bf.readLine()) != null) {
                int mul_index = 0;
                int new_mul_index = 0;
                while (mul_index != -1){
                    new_mul_index = line.indexOf("mul", mul_index+1);
                    int count = 0;
                    for (int i = mul_index+1; i < line.length()-mul_index; i++){
                        if (count > longest_mul_length){
                            break;
                        }
                        if (line.charAt(i) == end_mul) {
                            System.out.println(String.format("mul_index %d", mul_index));
                            System.out.println(String.format("i %d", i));
                            System.out.print("muls substring: ");
                            String mul_sub_string = line.substring(mul_index, i+1);
                            System.out.println(mul_sub_string);
                            int start_paren = mul_sub_string.indexOf("(");
                            int end_paren = mul_sub_string.indexOf(")");
                            if (start_paren == -1 || end_paren == -1){
                                continue;
                            }
                            String nums_substring = mul_sub_string.substring(start_paren+1, end_paren);
                            System.out.print("nums substring: ");
                            System.out.println(nums_substring);
                            String[] nums = nums_substring.split(",");
                            int num1 = 0;
                            int num2 = 0;
                            try{
                                num1 = Integer.parseInt(nums[0]);
                                num2 = Integer.parseInt(nums[1]);
                            } catch(NumberFormatException e){
                                continue;
                            }
                            total += (num1 * num2);
                            System.out.println(String.format("total is now: %d", total));
                            System.out.println("");
                            break;
                        }
                        count++;
                    }
                    mul_index = new_mul_index;
                }
            }
            System.out.println(String.format("Result: %d", total));
        } 
        catch (FileNotFoundException e){} 
        catch (IOException e){}

    }
}
