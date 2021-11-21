package mentoringSession1;

import java.util.Arrays;
import java.util.Scanner;

public class PoleCudes {

    public static void main(String[] args) {

        System.out.println("QUESTION: In which state was the first English colony in North America (this word contains 8 letters)?");

        char[] word = {'V', 'i', 'r', 'g', 'i', 'n', 'i', 'a'};
        char[] foundLetters = new char[word.length];
        Arrays.fill(foundLetters, '?');

        Scanner sc = new Scanner(System.in);

        boolean answer;

        do {
            System.out.print("\nGuess and input the letter: ");
            String letter = sc.next();
            answer = false;


            for (int i = 0; i < word.length; i++) {
                if (letter.equalsIgnoreCase(Character.toString(word[i]))) {
                    foundLetters[i] = word[i];
                    answer = true;
                }
            }

            if (answer == true)
                System.out.println("Wow, correct letter!");
            else
                System.out.println("Unfortunately, this letter is not in this word...");

            System.out.println(Arrays.toString(foundLetters));

        }
        while (!Arrays.equals(foundLetters, word));
        System.out.println("\nCongratulations! You found the word!");
    }
}

