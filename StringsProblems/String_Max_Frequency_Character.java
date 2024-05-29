package string_assignment;

import java.util.Scanner;

public class String_Max_Frequency_Character {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] frequency = new int[256];
        int maxFrequency = 0;
        char maxChar = str.charAt(0);

        for(char ch: str.toCharArray()) {
            frequency[ch]++;
            if(frequency[ch] > maxFrequency) {
                maxFrequency = frequency[ch];
                maxChar = ch;
            }
        }

        System.out.println(maxChar);
    }

}
