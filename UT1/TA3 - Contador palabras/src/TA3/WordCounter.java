/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isLetter;
import java.util.ArrayList;

/**
 *
 * @author Lucas Astor
 */
public class WordCounter {

    public int countWords(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = word.length() - 1;
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;

                isWord = false;
            } else if (Character.isLetter(characters[i]) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;

    }

    public void countLetters(String str) {
        // Create an char array of given String 
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            // Declare an String with empty initialization 
            String s = "";

            // When the character is not space 
            while (i < ch.length && ch[i] != ' ') {

                // concat with the declared String 
                s = s + ch[i];
                i++;
            }

            if (s.length() > 0) {
                System.out.println(s + "->" + s.length());
            }
        }
    }


    public void countVowelConsonant(String str) {
        //Counter variable to store the count of vowels and consonant    
        int vCount = 0, cCount = 0;
        //Converting entire string to lower case to reduce the comparisons    
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            //Checks whether a character is a vowel    
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                //Increments the vowel counter    
                vCount++;
            } //Checks whether a character is a consonant    
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                //Increments the consonant counter    
                cCount++;
            }
        }
        System.out.println("Number of vowels: " + vCount);
        System.out.println("Number of consonants: " + cCount);
    }
}
